package com.yamanin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamanin.model.dao.CommentDao;
import com.yamanin.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService{

	private final CommentDao commentDao;
	
	@Autowired
	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	@Override
	public List<Comment> getAllComment() {
		return commentDao.selectAll();
	}

	@Override
	public Comment getCommentByCommentId(int commentId) {
		return commentDao.selectById(commentId);
	}

	@Override
	public int insert(Comment comment) {
		return commentDao.insertComment(comment);
	}

	@Override
	public int delete(int commentId) {
		return commentDao.deleteComment(commentId);
	}

}
