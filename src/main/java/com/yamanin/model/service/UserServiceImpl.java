package com.yamanin.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.yamanin.model.dao.UserDao;
import com.yamanin.model.dto.User;

public class UserServiceImpl implements UserService {

	private final UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	// 게시글 작성
	@Override
	public boolean writeUser(User user) {
		return userDao.insertUser(user) == 1;
	}

	// 게시글 수정
	@Override
	public boolean modifyUser(User user) {
		return userDao.updateUser(user) == 1;
	}
	
	// 게시글 삭제
	@Override
	public boolean removeUser(int userId) {
		return userDao.deleteUser(userId) == 1;
	}

}