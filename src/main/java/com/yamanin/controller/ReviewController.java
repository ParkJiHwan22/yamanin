package com.yamanin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamanin.model.dto.Review;
import com.yamanin.model.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReview();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/marked/{markedId}")
    public ResponseEntity<List<Review>> getReviewsByMarkedId(@PathVariable int markedId) {
        List<Review> reviews = reviewService.getReviewByMarkedId(markedId);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUserId(@PathVariable int userId) {
        List<Review> reviews = reviewService.getReviewById(userId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/")
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        int result = reviewService.insert(review);
        if (result == 1) {
            return ResponseEntity.ok("Review created successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to create review.");
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable int reviewId) {
        int result = reviewService.delete(reviewId);
        if (result == 1) {
            return ResponseEntity.ok("Review deleted successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete review.");
        }
    }
}