package com.yamanin.model.service;

import com.yamanin.model.dto.User;

public interface UserService {
	// 유저 1명만 아이디로 조회
	User getUserById(int userId); 

	// 유저 작성
	boolean writeUser(User user);

	// 유저 삭제
	boolean removeUser(int UserId);

	// 유저 수정
	boolean modifyUser(User user);
}
