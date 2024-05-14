package com.yamanin.model.dao;

import java.util.List;

import com.yamanin.model.dto.Review;

public interface ReviewDao {
	 // 리뷰 전체 조회
	List<Review> selectAll();
	
	// 리뷰 대상자 ID 조회
    List<Review> selectByMarkedId(int markedId);
    
	// 리뷰 작성자 ID 조회
    List<Review> selectById(int userId);
    
	// 리뷰 생성
    public int insertReview(Review review);
    
	// 리뷰 삭제
    public int deleteReview(int userId);

}
