package com.yamanin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamanin.model.dao.QuestionDao;
import com.yamanin.model.dto.Question;

@Service
public class QuestionServiceImpl implements QuestionService {

	private final QuestionDao questionDao;
	
	@Autowired
	public QuestionServiceImpl(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
	@Override
	public List<Question> getAllQuestion() {
		// 게시글 전체 조회
		return questionDao.selectAll();
	}

	@Override
	public int insert(Question question) {
		// 게시글 작성
		return questionDao.insertQuestion(question);
	}

	@Override
	public int update(Question question) {
		// 게시글 수정
		return questionDao.updateQuestion(question);
	}

	@Override
	public int delete(int qnaId) {
		// 게시글 삭제
		return questionDao.deleteQuestion(qnaId);
	}

}
