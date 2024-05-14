package com.yamanin.model.dto;

public class Alarm {
	private int alarmId;
	private int userId;
	private String alarmDetail;
	private String alarmRead; // 알람읽음 여부
	private String createdDate;

	
	public Alarm() {
	}

	
	public Alarm(int alarmId, int userId, String alarmDetail, String alarmRead, String createdDate) {
		this.alarmId = alarmId;
		this.userId = userId;
		this.alarmDetail = alarmDetail;
		this.alarmRead = alarmRead;
		this.createdDate = createdDate;
	}


	public int getAlarmId() {
		return alarmId;
	}


	public void setAlarmId(int alarmId) {
		this.alarmId = alarmId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getAlarmDetail() {
		return alarmDetail;
	}


	public void setAlarmDetail(String alarmDetail) {
		this.alarmDetail = alarmDetail;
	}


	public String getAlarmRead() {
		return alarmRead;
	}


	public void setAlarmRead(String alarmRead) {
		this.alarmRead = alarmRead;
	}


	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	@Override
	public String toString() {
		return "Alarm [alarmId=" + alarmId + ", userId=" + userId + ", alarmDetail=" + alarmDetail + ", alarmRead="
				+ alarmRead + ", createdDate=" + createdDate + "]";
	}	
}
