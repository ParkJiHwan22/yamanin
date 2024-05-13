package com.yamanin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamanin.model.dto.Question;
import com.yamanin.model.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api-questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

	// 질의응답 글 전체 조회
    @GetMapping("/")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestion();
        return ResponseEntity.ok(questions);
    }

	// 질의응답 글 등록
    @PostMapping("/")
    public ResponseEntity<String> createQuestion(@RequestBody Question question) {
        int result = questionService.insert(question);
        if (result == 1) {
            return ResponseEntity.ok("Question created successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to create question.");
        }
    }
    
    // 질의응답 글 수정
    @PutMapping("/{qnaId}")
    public ResponseEntity<String> updateQuestion(@PathVariable int qnaId, @RequestBody Question question) {
        question.setQnaId(qnaId);
        int result = questionService.update(question);
        if (result == 1) {
            return ResponseEntity.ok("Question updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to update question.");
        }
    }

    // 질의응답 글 삭제
    @DeleteMapping("/{qnaId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int qnaId) {
        int result = questionService.delete(qnaId);
        if (result == 1) {
            return ResponseEntity.ok("Question deleted successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete question.");
        }
    }
}