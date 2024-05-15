package com.yamanin.model.dao;

import java.util.List;

import com.yamanin.model.dto.GameInfo;


public interface GameInfoDao {
		// 경기정보 전체 조회
		List<GameInfo> selectAll();
		
		// 경기정보 하나만 아이디로 조회
		GameInfo selectByGameId(int gameId);
	    
	    // 경기정보 생성	
	    public int insertGameInfo(GameInfo review);
	    
		// 경기정보 삭제
	    public int deleteGameInfo(int gameId);
}
