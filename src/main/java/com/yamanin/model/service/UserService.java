package com.yamanin.model.service;

import com.yamanin.model.dto.User;

public interface UserService {
	// 유저 작성
	boolean writeUser(User user);

	// 유저 삭제
	boolean removeUser(int UserId);

	// 유저 수정
	boolean modifyUser(User user);
}
