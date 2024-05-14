package com.yamanin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamanin.model.dao.AlarmDao;
import com.yamanin.model.dto.Alarm;

@Service
public class AlarmServiceImpl implements AlarmService {
	
	private final AlarmDao alarmDao;
	
	@Autowired
	public AlarmServiceImpl(AlarmDao alarmDao) {
		this.alarmDao = alarmDao;
	}
	
	
	// 알람 전체 조회
    
	@Override
	public List<Alarm> getAllAlarm() {
		return alarmDao.selectAll();
	}
	
	// 알람 작성
    @Override
    public int insert(Alarm alarm) {
		return alarmDao.insertAlarm(alarm);
    }

	// 알람 삭제
    @Override
    public int delete(int alarmId) {
		return alarmDao.deleteAlarm(alarmId);
    }
	
}
