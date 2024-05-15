package com.yamanin.model.dto;

public class Recomment {
	private long recommentId;
    private long commentId;
    private long postId;
    private long userId2;
    private long gameId2;
    private String commentDetail;
    private String createdDate;
    private String updatedDate;

    // Constructors
    public Recomment() {}

    public Recomment(long recommentId, long commentId, long postId, long userId2, long gameId2, String commentDetail, String createdDate, String updatedDate) {
        this.recommentId = recommentId;
    	this.commentId = commentId;
        this.postId = postId;
        this.userId2 = userId2;
        this.gameId2 = gameId2;
        this.commentDetail = commentDetail;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    // Getters and setters
    public long getRecommentId() {
		return recommentId;
	}

	public void setRecommentId(long recommentId) {
		this.recommentId = recommentId;
	}

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getUserId2() {
        return userId2;
    }

    public void setUserId2(long userId2) {
        this.userId2 = userId2;
    }

    public long getGameId2() {
        return gameId2;
    }

    public void setGameId2(long gameId2) {
        this.gameId2 = gameId2;
    }

    public String getCommentDetail() {
        return commentDetail;
    }

    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}

