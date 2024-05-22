package com.yamanin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamanin.model.dao.UserDao;
import com.yamanin.model.dto.User;
import com.yamanin.model.dto.UserLoginDto;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	// 모든 유저 조회
	@Override
	public List<User> getAllUser() {
		return userDao.selectAll();
	}
	
	// 아이디로 유저 검색
	@Override
	public User getUserById(int userId) {
		return userDao.selectOne(userId);
	}
	
	@Override
	public User getUserByLoginId(String loginId) {
		return userDao.selectOneByLoginId(loginId);
	}

	// 유저 작성
	@Override
	public boolean writeUser(User user) {
		return userDao.insertUser(user) == 1;
	}

	// 유저 수정
	@Override
	public boolean modifyUser(User user) {
		return userDao.updateUser(user) == 1;
	}

	// 유저 삭제
	@Override
	public boolean removeUser(int userId) {
		return userDao.deleteUser(userId) == 1;
	}

	@Override
	public User loginUser(UserLoginDto user) {
		return userDao.loginUser(user);
	}
}