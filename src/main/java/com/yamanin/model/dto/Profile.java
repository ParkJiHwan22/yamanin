package com.yamanin.model.dto;

public class Profile {
    private int userId;
    private byte[] file;
    private String profileText;
    private String supportTeam;

    public Profile() {
    }

    public Profile(int userId, byte[] profileImg, String profileText, String supportTeam) {
        this.userId = userId;
        this.file = profileImg;
        this.profileText = profileText;
        this.supportTeam = supportTeam;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public byte[] getProfileImg() {
        return file;
    }

    public void setProfileImg(byte[] profileImg) {
        this.file = profileImg;
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
        return "Profile [userId=" + userId + ", profileImg=" + "binary data" + ", profileText=" + profileText
                + ", supportTeam=" + supportTeam + "]";
    }
}