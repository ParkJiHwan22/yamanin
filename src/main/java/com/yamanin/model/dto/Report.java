package com.yamanin.model.dto;

public class Report {
    private long reportId;
    private long postId;
    private long userId;
    private long gameId;
    private String reportDetail;
    private String createdDate;

    // Constructors
    public Report() {
    }

    public Report(long reportId, long postId, long userId, long gameId, String reportDetail, String createdDate) {
        this.reportId = reportId;
        this.postId = postId;
        this.userId = userId;
        this.gameId = gameId;
        this.reportDetail = reportDetail;
        this.createdDate = createdDate;
    }

    // Getters and Setters
    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getReportDetail() {
        return reportDetail;
    }

    public void setReportDetail(String reportDetail) {
        this.reportDetail = reportDetail;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", postId=" + postId + ", userId=" + userId + ", gameId=" + gameId
				+ ", reportDetail=" + reportDetail + ", createdDate=" + createdDate + "]";
	}    
    
}

