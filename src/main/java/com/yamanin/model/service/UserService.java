package com.yamanin.model.service;

import java.util.List;

import com.yamanin.model.dto.PostItem;
import com.yamanin.model.dto.User;
import com.yamanin.model.dto.UserLoginDto;

public interface UserService {
	 // 유저 전체 조회
	List<User> getAllUser();

	// 유저 1명만 아이디로 조회
	User getUserById(int userId); 

	// 유저 작성
	boolean writeUser(User user);

	// 유저 삭제
	boolean removeUser(int UserId);

	// 유저 수정
	boolean modifyUser(User user);
	
	User loginUser(UserLoginDto user);
}