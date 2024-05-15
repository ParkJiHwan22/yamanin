package com.yamanin.model.service;

import java.util.List;

import com.yamanin.model.dto.Comment;

public interface CommentService {
			// 댓글 전체 조회
			List<Comment> getAllComment();
			
			// 댓글 하나만 아이디로 조회
			Comment getCommentByCommentId(int commentId);
		    
		    // 댓글 생성	
		    public int insert(Comment comment);
		    
			// 댓글 삭제
		    public int delete(int commentId);
}
