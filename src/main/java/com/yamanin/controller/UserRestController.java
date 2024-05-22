package com.yamanin.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yamanin.model.dto.PostItem;
import com.yamanin.model.dto.User;
import com.yamanin.model.dto.UserLoginDto;
import com.yamanin.model.service.UserService;
import com.yamanin.util.JwtUtil;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
@Tag(name = "UserRestController", description = "유저 CRUD")

public class UserRestController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private final UserService userService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Value("${jwt.refreshtoken.expiretime}")
	private int refreshTokenExpireTime;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLoginDto user, HttpServletResponse response) throws UnsupportedEncodingException{

		Map<String, Object> result = new HashMap<>();
		
		
		// DB에서 유저 가져오기
		User dbUser = userService.loginUser(user);
		
		// 일치하는 유저가 없다면 UNAUTHORIZED 반환.
		if(dbUser == null) {
			result.put("message", "일치하는 유저가 없습니다.");
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.UNAUTHORIZED);
		}
		
		// 있으면 Token 발급
		// AccessToken, RefreshToken 두 개를 발급해준다.
		String accessToken = jwtUtil.createAccessToken(dbUser.getLoginId());
		String refreshToken = jwtUtil.createRefreshToken(dbUser.getLoginId());
		
		int userId = dbUser.getUserId();
		
		// refreshtoken은 처음 발급할 때 -> DB에 저장.
		// INSERT INTO `refresh-token` (userId, refreshToken)  VALUE (#{userId}, #{refreshToken}) 
		
		
		// Front End와 합의사항
		//1.) accessToken, refreshToken => 본문에 둘다 보내도 되고,
		//   refreshToken: localStorage에 저장, accessToken: sessionStorage 또는 pinia store에만.
		
		//2.) accessToken만 응답 본문에 넣어서 보내고, refreshToken은 쿠키에 넣어서 보냄. => 
		//  refreshToken은 브라우저에 자동 저장
		//  accessToken만 sessionStorage 또는 pinia store에 저장.
		
		Cookie cookie = new Cookie("refreshToken", refreshToken);
		cookie.setMaxAge(refreshTokenExpireTime);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		result.put("accessToken", accessToken);
		result.put("name", dbUser.getName());
		result.put("userId", userId);
		
//		System.out.println(result);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
	// 모든 유저 검색
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }
    
	
	// 유저 ID로 검색
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
	
	// 유저 LoginID로 검색
		@GetMapping("/lid/{loginId}")
		public ResponseEntity<User> getUserByLoginId(@PathVariable("loginId") String loginId) {
	        User user = userService.getUserByLoginId(loginId);
	        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	    }

	// 유저 등록 (JSON형태로 보낸다)
	@PostMapping("/adduser")
	public ResponseEntity<?> write(@RequestBody User user) {
		userService.writeUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	// 게시글 수정 (JSON형태로 보낸다) 경로 중요
//	@PutMapping("/modifyuser/{id}") --> PathVariable 처리와 ID 추가 작업 필요
	@PutMapping("/modifyuser")
	public ResponseEntity<String> update(@RequestBody User user) {
		userService.modifyUser(user);
		if (userService.modifyUser(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	// 게시글 삭제
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> delete(@PathVariable("userId") int id) {
		if (userService.removeUser(id))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}
	
//	@AuthRequired // 토큰이 있어야지만 접근 가능한 메서드.
//	@GetMapping("/mypage")
//	ResponseEntity<?> mypage(HttpServletRequest request) throws ParseException{
//		String accessToken = request.getHeader("Authorization");
//		String userId = jwtUtil.getUserId(accessToken);
//		
//		return new ResponseEntity<String>(userId, HttpStatus.OK);
//	}
//	
//	@GetMapping("/refresh")
//	ResponseEntity<?> refreshToken(){
//		
//		// accessToken의 유효기간이 얼마 안남았고
//		// refreshToken은 있는 상황에만 accessToken을 재발급해주겠다.
//		
//		// 1. COOKIE 헤더에서 refreshToken 가져오기
//		// 2. DB에 있는 refreshToken과 일치여부 확인
//		//   2-1. 일치한다면 accessToken을 새걸로 만들어서 반환
//		//   2-2. 그렇지 않다면 "messege" "다시 로그인하세요"
//		// 3. refreshToken이 이상한 경우 => 다시 로그인하세요.
//		
//		
//		// ex) 은행 로그인에서 로그인 연장하기 버튼을 눌렀을 때
//		//     또는
//		//     웹 서비스를 정상적으로 사용하고 있을 때(주기적으로 refresh 요청을 같이 날려서
//		//     accessToken을 최신화해줌.
//		
//				
//		return null;
//	}
	
	
}