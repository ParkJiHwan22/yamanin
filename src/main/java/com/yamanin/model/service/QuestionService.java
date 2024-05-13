package com.yamanin.model.service;

import java.util.List;

import com.yamanin.model.dto.Question;

public interface QuestionService {
	List<Question> getAllQuestion(); // 게시글 전체 조회
	int insert(Question question); // 게시글 작성
	int update(Question question); // 게시글 수정
	int delete(int qnaId); // 게시글 삭제
}
