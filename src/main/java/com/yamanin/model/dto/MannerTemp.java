package com.yamanin.model.dto;

public class MannerTemp {
	private int userId;
	private int reviewId;
	private int reviewPoint;
	private int markedId;
	private int gamePoint;
	private int reviewCnt;
	
	
	public MannerTemp() {
	}

	public MannerTemp(int userId, int reviewId, int reviewPoint, int markedId, int gamePoint, int reviewCnt) {
		super();
		this.userId = userId;
		this.reviewId = reviewId;
		this.reviewPoint = reviewPoint;
		this.markedId = markedId;
		this.gamePoint = gamePoint;
		this.reviewCnt = reviewCnt;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getReviewPoint() {
		return reviewPoint;
	}

	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}

	public int getMarkedId() {
		return markedId;
	}

	public void setMarkedId(int markedId) {
		this.markedId = markedId;
	}

	public int getGamePoint() {
		return gamePoint;
	}

	public void setGamePoint(int gamePoint) {
		this.gamePoint = gamePoint;
	}

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	@Override
	public String toString() {
		return "MannerTemp [userId=" + userId + ", reviewId=" + reviewId + ", reviewPoint=" + reviewPoint
				+ ", markedId=" + markedId + ", gamePoint=" + gamePoint + ", reviewCnt=" + reviewCnt + "]";
	}

	
	
}
