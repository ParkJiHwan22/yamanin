package com.yamanin.model.service;

import com.yamanin.model.dto.User;

public interface UserService {
	// 게시글 작성
	public boolean writeUser(User user);

	/// 게시글 삭제
	public boolean removeUser(int UserId);

	// 게시글 수정
	public boolean modifyUser(User user);
}
