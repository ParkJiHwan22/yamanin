package com.yamanin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamanin.model.dto.User;
import com.yamanin.model.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name = "UserRestController", description = "유저 CRUD")

public class UserRestController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private final UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
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
		if (userService.modifyUser(user))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	// 게시글 삭제
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> delete(@PathVariable("userId") int id) {
		if (userService.removeUser(id))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

}
