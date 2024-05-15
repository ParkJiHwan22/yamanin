package com.yamanin.model.dao;

import java.util.List;

import com.yamanin.model.dto.Recomment;


public interface RecommentDao {
		// 대댓글 전체 조회
		List<Recomment> selectAll();
		
		// 대댓글 하나만 아이디로 조회
		Recomment selectById(int recommentId);
	    
		// 대댓글 생성
	    public int insertRecomment(Recomment recomment);
	    
		// 대댓글 삭제
	    public int deleteRecomment(int recommentId);
}
