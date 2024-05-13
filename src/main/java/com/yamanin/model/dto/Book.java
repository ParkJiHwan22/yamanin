package com.yamanin.model.dto;

public class Book {
	private int bookId;
	private int postId;
	private int userId;
	private int gameId;
	private int bookCnt;

	public Book(int bookId, int postId, int userId, int gameId, int bookCnt) {
		this.bookId = bookId;
		this.postId = postId;
		this.userId = userId;
		this.gameId = gameId;
		this.bookCnt = bookCnt;
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

	public int getBookCnt() {
		return bookCnt;
	}

	public void setBookCnt(int bookCnt) {
		this.bookCnt = bookCnt;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", postId=" + postId + ", userId=" + userId + ", gameId=" + gameId
				+ ", bookCnt=" + bookCnt + "]";
	}
}
