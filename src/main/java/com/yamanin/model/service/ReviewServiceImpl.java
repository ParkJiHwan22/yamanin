package com.yamanin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamanin.model.dao.ReviewDao;
import com.yamanin.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewDao reviewDao;
	
	@Autowired
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	// 리뷰 전체 조회
	@Override
	public List<Review> getAllReview() {
		return reviewDao.selectAll();
	}
	
	// 리뷰 대상자 ID 조회
	@Override
	public List<Review> getReviewByMarkedId(int markedId) {
		return reviewDao.selectByMarkedId(markedId);
	}
	
	// 리뷰 작성자 ID 조회
	@Override
	public List<Review> getReviewById(int userId) {
		return reviewDao.selectById(userId);
	}
	
	// 리뷰 생성
	@Override
	public int insert(Review review) {
		return reviewDao.insertReview(review);
	}
	
	// 리뷰 삭제
	@Override
	public int delete(int userId) {
		return reviewDao.deleteReview(userId);
	}
}
