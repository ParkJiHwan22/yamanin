package com.yamanin.model.dto;

public class Reservation {
    private Long id;
    private Long userId;
    private Long gameId;
    private String userName;
    private Boolean isAuthor;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getIsAuthor() {
        return isAuthor;
    }

    public void setIsAuthor(Boolean isAuthor) {
        this.isAuthor = isAuthor;
    }

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", userId=" + userId + ", gameId=" + gameId + ", userName=" + userName
				+ ", isAuthor=" + isAuthor + "]";
	}
}
