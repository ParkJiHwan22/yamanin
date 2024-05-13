package com.yamanin.model.dto;

public class Question {
	private int qnaId;
	private int userId;
	private String detail;
	private QnaType qnaType;
	
    // SeatType Enum 정의
    public enum QnaType {
        Qustion("질문"), Answer("응답");

        private String value;

        QnaType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

	public Question(int qnaId, int userId, String detail, QnaType qnaType, int qustionId) {
		this.qnaId = qnaId;
		this.userId = userId;
		this.detail = detail;
		this.qnaType = qnaType;
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

	@Override
	public String toString() {
		return "Question [qnaId=" + qnaId + ", userId=" + userId + ", detail=" + detail + ", qnaType=" + qnaType + "]";
	}    
}
