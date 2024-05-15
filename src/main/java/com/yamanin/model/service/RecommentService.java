package com.yamanin.model.service;

import java.util.List;

import com.yamanin.model.dto.Recomment;


public interface RecommentService {
			// 대댓글 전체 조회
			List<Recomment> getAllRecomment();
			
			// 대댓글 하나만 아이디로 조회
			Recomment getRecommentByRecommentId(int recommentId);
		    
		    // 대댓글 생성	
		    public int insert(Recomment recomment);
		    
			// 대댓글 삭제
		    public int delete(int recommentId);
}
