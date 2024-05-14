package com.yamanin.model.dao;

import java.util.List;

import com.yamanin.model.dto.Alarm;

public interface AlarmDao {
	// 알람 글 전체 조회
    List<Alarm> selectAll();
    
	// 질의응답 글 등록
	public int insertAlarm(Alarm alarm);
	
	// 질의응답 글 삭제
	public int deleteAlarm(int alarmId);
}
