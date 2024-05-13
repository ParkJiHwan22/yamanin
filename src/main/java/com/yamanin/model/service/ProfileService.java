package com.yamanin.model.service;

import com.yamanin.model.dto.Profile;

public interface ProfileService {
	Profile getProfileById(int userId); // 게시글 하나만 아이디로 조회
	int insert(Profile profile); // 게시글 작성
	int update(Profile profile); // 게시글 수정
	int delete(int userId); // 게시글 삭제
}
