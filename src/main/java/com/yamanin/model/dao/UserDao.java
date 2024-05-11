package com.yamanin.model.dao;

import com.yamanin.model.dto.User;

public interface UserDao {
	// 유저 등록
	public int insertUser(User user);

	// 유저 수정
	public int updateUser(User user);
	
	// 유저 삭제
	public int deleteUser(int id);
	
}
