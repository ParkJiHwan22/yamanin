package com.yamanin.model.dao;

import com.yamanin.model.dto.Profile;

public interface ProfileDao {
	// 유저 프로필 id로 조회
	Profile selectOne(int userId);

	// 유저 프로필 등록
	public int insertProfile(Profile profile);

	// 유저 프로필 수정
	public int updateProfile(Profile profile);
	
	// 유저 프로필 삭제
	public int deleteProfile(int userId);
	
}