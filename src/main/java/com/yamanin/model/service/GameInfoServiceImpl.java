package com.yamanin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamanin.model.dao.GameInfoDao;
import com.yamanin.model.dto.GameInfo;

@Service
public class GameInfoServiceImpl implements GameInfoService{

	private final GameInfoDao gameInfoDao;
	
	@Autowired
	public GameInfoServiceImpl(GameInfoDao gameInfoDao) {
		this.gameInfoDao = gameInfoDao;
	}
	
	@Override
	public List<GameInfo> getAllGameInfo() {
		return gameInfoDao.selectAll();
	}

	@Override
	public GameInfo getGameInfoByGameId(int gameId) {
		return gameInfoDao.selectByGameId(gameId);
	}

	@Override
	public int insert(GameInfo gameInfo) {
		return gameInfoDao.insertGameInfo(gameInfo);
	}

	@Override
	public int delete(int gameId) {
		return gameInfoDao.deleteGameInfo(gameId);
	}

}
