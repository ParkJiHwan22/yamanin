package com.yamanin.model.dto;

public class ProfileDto {
    private int userId;
    private String profileImg; // base64 encoded string
    private String profileText;
    private String supportTeam;
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getProfileText() {
		return profileText;
	}
	public void setProfileText(String profileText) {
		this.profileText = profileText;
	}
	public String getSupportTeam() {
		return supportTeam;
	}
	public void setSupportTeam(String supportTeam) {
		this.supportTeam = supportTeam;
	}
	@Override
	public String toString() {
		return "ProfileDto [userId=" + userId + ", profileImg=" + profileImg + ", profileText=" + profileText
				+ ", supportTeam=" + supportTeam + "]";
	}

    // Getters and Setters
}
