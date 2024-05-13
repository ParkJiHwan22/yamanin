package com.yamanin.model.dao;

import java.util.List;

import com.yamanin.model.dto.Question;


public interface QuestionDao {
	// 질의응답 글 전체 조회
    List<Question> selectAll();
    
	// 질의응답 글 등록
	public int insertQuestion(Question question);

	// 질의응답 글 수정
	public int updateQuestion(Question question);
	
	// 질의응답 글 삭제
	public int deleteQuestion(int qnaId);
	
}
