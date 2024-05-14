package com.yamanin.model.dao;

import java.util.List;

import com.yamanin.model.dto.Report;

public interface ReportDao {
	// 신고/답변 글 전체 조회
    List<Report> selectAll();
    
	// 신고/답변 글 등록
	public int insertReport(Report report);

}
