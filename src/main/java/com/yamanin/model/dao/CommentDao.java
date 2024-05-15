package com.yamanin.model.dao;

import java.util.List;

import com.yamanin.model.dto.Comment;

public interface CommentDao {
		// 댓글 전체 조회
		List<Comment> selectAll();
		
		// 댓글 하나만 아이디로 조회
		Comment selectById(int commentId);
	    
		// 댓글 생성
	    public int insertComment(Comment comment);
	    
		// 댓글 삭제
	    public int deleteComment(int commentId);
}
