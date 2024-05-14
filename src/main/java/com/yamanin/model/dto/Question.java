package com.yamanin.model.dto;

public class Question {
	private int qnaId;
	private int userId;
	private String detail;
	private QnaType qnaType;
	private String createdDate;
	private String updatedDate;

	
    // SeatType Enum 정의
    public enum QnaType {
    	QUESTION("질문"), ANSWER("응답");

        private String value;

        QnaType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }


	public int getQnaId() {
		return qnaId;
	}


	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public QnaType getQnaType() {
		return qnaType;
	}


	public void setQnaType(QnaType qnaType) {
		this.qnaType = qnaType;
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


	@Override
	public String toString() {
		return "Question [qnaId=" + qnaId + ", userId=" + userId + ", detail=" + detail + ", qnaType=" + qnaType
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
}
