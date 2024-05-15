package com.yamanin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamanin.model.dto.Recomment;
import com.yamanin.model.service.RecommentService;

import java.util.List;

@RestController
@RequestMapping("/api/recomments")
public class RecommentController {

    private final RecommentService recommentService;

    @Autowired
    public RecommentController(RecommentService recommentService) {
        this.recommentService = recommentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Recomment>> getAllRecomment() {
        return ResponseEntity.ok(recommentService.getAllRecomment());
    }

    @GetMapping("/{recommentId}")
    public ResponseEntity<Recomment> getRecommentById(@PathVariable int recommentId) {
    	Recomment recomment = recommentService.getRecommentByRecommentId(recommentId);
        if (recomment != null) {
            return ResponseEntity.ok(recomment);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Void> addRecomment(@RequestBody Recomment recomment) {
        int result = recommentService.insert(recomment);
        if (result == 1) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{recommentId}")
    public ResponseEntity<Void> updateRecomment(@PathVariable int recommentId, @RequestBody Recomment recomment) {
    	Recomment existingRecomment = recommentService.getRecommentByRecommentId(recommentId);
        if (existingRecomment != null) {
            recomment.setRecommentId(recommentId);
            int updateResult = recommentService.insert(recomment);
            if (updateResult == 1) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{recommentId}")
    public ResponseEntity<Void> deleteRecomment(@PathVariable int recommentId) {
        int result = recommentService.delete(recommentId);
        if (result == 1) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
