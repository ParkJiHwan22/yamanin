package com.yamanin.model.dto;

import java.util.Arrays;

public class PostItem {
	private int postId;
	private int userId;
	private int gameId;
	private String seatInfo;
	private SeatType seatType;
	private String title;
    private String detail;
    private int price;
    private byte[] ticketImg;
	
    // SeatType Enum 정의
    public enum SeatType {
        LEFT("열정 공유"), RIGHT("자리 공유");

        private String value;

        SeatType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
    
    public PostItem() {
    }

	public PostItem(int postId, int userId, int gameId, String seatInfo, SeatType seatType, String title, String detail,
			int price, byte[] ticketImg) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.gameId = gameId;
		this.seatInfo = seatInfo;
		this.seatType = seatType;
		this.title = title;
		this.detail = detail;
		this.price = price;
		this.ticketImg = ticketImg;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getSeatInfo() {
		return seatInfo;
	}

	public void setSeatInfo(String seatInfo) {
		this.seatInfo = seatInfo;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public byte[] getTicketImg() {
		return ticketImg;
	}

	public void setTicketImg(byte[] ticketImg) {
		this.ticketImg = ticketImg;
	}

	@Override
	public String toString() {
		return "PostItem [postId=" + postId + ", userId=" + userId + ", gameId=" + gameId + ", seatInfo=" + seatInfo
				+ ", seatType=" + seatType + ", title=" + title + ", detail=" + detail + ", price=" + price
				+ ", ticketImg=" + Arrays.toString(ticketImg) + "]";
	}
    
    
}
