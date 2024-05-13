package com.yamanin.model.dto;

public class BookList {
	private int bookId;
	private int postId;
	private int userId;
	private int gameId;
	private int bookUserId;
	private String bookDetail;
	
	public BookList(int bookId, int postId, int userId, int gameId, int bookUserId, String bookDetail) {
		this.bookId = bookId;
		this.postId = postId;
		this.userId = userId;
		this.bookUserId = bookUserId;
		this.bookDetail = bookDetail;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getBookUserId() {
		return bookUserId;
	}

	public void setBookUserId(int bookUserId) {
		this.bookUserId = bookUserId;
	}

	public String getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}

	@Override
	public String toString() {
		return "BookList [bookId=" + bookId + ", postId=" + postId + ", userId=" + userId + ", gameId=" + gameId
				+ ", bookUserId=" + bookUserId + ", bookDetail=" + bookDetail + "]";
	}

	
	
	
}
