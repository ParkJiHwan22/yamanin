package com.yamanin.model.dto;

public class GameInfo {
    private long gameId;
    private String gameDT;
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private String gamePlace;
    private String gameStatus;

    // Constructors
    public GameInfo() {}

	public GameInfo(long gameId, String gameDT, String homeTeam, String awayTeam, int homeScore, int awayScore,
			String gamePlace, String gameStatus) {
		this.gameId = gameId;
		this.gameDT = gameDT;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.gamePlace = gamePlace;
		this.gameStatus = gameStatus;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public String getGameDT() {
		return gameDT;
	}

	public void setGameDT(String gameDT) {
		this.gameDT = gameDT;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	public String getGamePlace() {
		return gamePlace;
	}

	public void setGamePlace(String gamePlace) {
		this.gamePlace = gamePlace;
	}

	public String getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}

	@Override
	public String toString() {
		return "GameInfo [gameId=" + gameId + ", gameDT=" + gameDT + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam
				+ ", homeScore=" + homeScore + ", awayScore=" + awayScore + ", gamePlace=" + gamePlace + ", gameStatus="
				+ gameStatus + "]";
	}
    
}

