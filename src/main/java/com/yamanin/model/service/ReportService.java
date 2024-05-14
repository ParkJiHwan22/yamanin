package com.yamanin.model.service;

import java.util.List;

import com.yamanin.model.dto.Report;

public interface ReportService {
	List<Report> getAllReport();// 게시글 전체 조회
	int insert(Report report); // 게시글 작성	
}
