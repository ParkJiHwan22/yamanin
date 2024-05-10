package com.yamanin.model.dao;

import com.yamanin.model.dto.User;

public interface UserDao {
	// 게시글 등록
	public int insertUser(User user);

	// 게시글 수정
	public int updateUser(User user);
	
	// 게시글 삭제
	public int deleteUser(int id);
	
}
