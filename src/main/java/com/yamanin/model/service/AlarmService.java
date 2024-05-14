package com.yamanin.model.service;

import java.util.List;

import com.yamanin.model.dto.Alarm;

public interface AlarmService {
	List<Alarm> getAllAlarm(); // 알람 전체 조회
	int insert(Alarm alarm); // 알람 작성
	int delete(int alarmId); // 알람 삭제
}
