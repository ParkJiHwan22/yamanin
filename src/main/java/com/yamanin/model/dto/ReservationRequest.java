package com.yamanin.model.dto;

import java.time.LocalDateTime;

public class ReservationRequest {
    private Long id;
    private Long postId;
    private Long userId;
    private String userName;
    private LocalDateTime requestDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

	@Override
	public String toString() {
		return "ReservationRequest [id=" + id + ", postId=" + postId + ", userId=" + userId + ", userName=" + userName
				+ ", requestDate=" + requestDate + "]";
	}
}
