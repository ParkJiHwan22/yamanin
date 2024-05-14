package com.yamanin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamanin.model.dao.ReportDao;
import com.yamanin.model.dto.Report;

@Service
public class ReportServiceImpl implements ReportService {

	private final ReportDao reportDao;
	
	@Autowired
	public ReportServiceImpl(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	
	@Override
	public List<Report> getAllReport() {
		return reportDao.selectAll();
	}

	@Override
	public int insert(Report report) {
		return reportDao.insertReport(report);
	}

}
