package com.yamanin.model.dto;

public class PostLike {
	private int likeId;
	private int postId;
	private int userId;
	private int gameId;
	
	public PostLike() {
	}

	public PostLike(int likeId, int postId, int userId, int gameId) {
		this.likeId = likeId;
		this.postId = postId;
		this.userId = userId;
		this.gameId = gameId;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
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

	@Override
	public String toString() {
		return "PostLike [likeId=" + likeId + ", postId=" + postId + ", userId=" + userId + ", gameId=" + gameId + "]";
	}
	
}
