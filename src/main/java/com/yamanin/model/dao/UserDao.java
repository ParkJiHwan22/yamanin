package com.yamanin.model.dao;

import java.util.List;

import com.yamanin.model.dto.PostItem;
import com.yamanin.model.dto.Profile;
import com.yamanin.model.dto.User;
import com.yamanin.model.dto.UserLoginDto;

public interface UserDao {
	// 유저 전체 조회
    List<User> selectAll();
    
	// 유저 프로필 id로 조회
	User selectOne(int userId);
	User selectOneByLoginId(String loginId);
	
	// 유저 등록
	public int insertUser(User user);

	// 유저 수정
	public int updateUser(User user);
	
	// 유저 삭제
	public int deleteUser(int id);
	
	User loginUser(UserLoginDto user);
	
}
