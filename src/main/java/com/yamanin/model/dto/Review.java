package com.yamanin.model.dto;

public class Review {
	private int reviewId;
	private int reviewPoint;
	private int userId;
	private int markedId;
	private String reviewDetail;
	private String createdDate;
			
	public Review() {
	}

	
	public Review(int reviewId, int reviewPoint, int userId, int markedId, String reviewDetail, String createdDate) {
		super();
		this.reviewId = reviewId;
		this.reviewPoint = reviewPoint;
		this.userId = userId;
		this.markedId = markedId;
		this.reviewDetail = reviewDetail;
		this.createdDate = createdDate;
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


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getMarkedId() {
		return markedId;
	}


	public void setMarkedId(int markedId) {
		this.markedId = markedId;
	}


	public String getReviewDetail() {
		return reviewDetail;
	}


	public void setReviewDetail(String reviewDetail) {
		this.reviewDetail = reviewDetail;
	}


	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", reviewPoint=" + reviewPoint + ", userId=" + userId + ", markedId="
				+ markedId + ", reviewDetail=" + reviewDetail + ", createdDate=" + createdDate + "]";
	}

}
