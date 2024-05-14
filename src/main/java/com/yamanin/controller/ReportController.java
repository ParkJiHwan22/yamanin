
package com.yamanin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yamanin.model.dto.Report;
import com.yamanin.model.service.ReportService;

@RestController
@RequestMapping("/api-reports")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // 신고/답변 글 전체목록
    @GetMapping("/")
    public ResponseEntity<List<Report>> getAllReports() {
        List<Report> reports = reportService.getAllReport();
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    // 신고/답변 글 등록
    @PostMapping("/")
    public ResponseEntity<String> insertReport(@RequestBody Report report) {
        int result = reportService.insert(report);
        if (result > 0) {
            return new ResponseEntity<>("Report created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create report", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

