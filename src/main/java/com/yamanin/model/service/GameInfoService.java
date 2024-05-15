package com.yamanin.model.service;

import java.util.List;

import com.yamanin.model.dto.GameInfo;

public interface GameInfoService {
		// 경기정보 전체 조회
		List<GameInfo> getAllGameInfo();
		
		// 경기정보 하나만 아이디로 조회
		GameInfo getGameInfoByGameId(int gameId);
	    
	    // 경기정보 생성	
	    public int insert(GameInfo gameInfo);
	    
		// 경기정보 삭제
	    public int delete(int gameId);
}
