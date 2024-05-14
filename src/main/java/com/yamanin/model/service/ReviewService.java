package com.yamanin.model.service;

import java.util.List;

import com.yamanin.model.dto.Review;

public interface ReviewService {
	 // 리뷰 전체 조회
	List<Review> getAllReview();
	
	// 리뷰 대상자 ID 조회
   List<Review> getReviewByMarkedId(int markedId);
   
	// 리뷰 작성자 ID 조회
   List<Review> getReviewById(int userId);
   
	// 리뷰 생성
   public int insert(Review review);
   
	// 리뷰 삭제
   public int delete(int userId);

}
