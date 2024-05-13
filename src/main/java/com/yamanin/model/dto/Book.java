package com.yamanin.model.dto;

public class Book {
	private int book_id;
	private int post_id;
	private int user_id;
	private int game_id;
	private int book_cnt;
	
	public Book(int book_id, int post_id, int user_id, int game_id, int book_cnt) {
		this.book_id = book_id;
		this.post_id = post_id;
		this.user_id = user_id;
		this.game_id = game_id;
		this.book_cnt = book_cnt;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public int getBook_cnt() {
		return book_cnt;
	}

	public void setBook_cnt(int book_cnt) {
		this.book_cnt = book_cnt;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", post_id=" + post_id + ", user_id=" + user_id + ", game_id=" + game_id
				+ ", book_cnt=" + book_cnt + "]";
	}
	
	
}
