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

import com.yamanin.model.dto.BookList;
import com.yamanin.model.service.BookListService;

import java.util.List;

@RestController
@RequestMapping("/api-bookLists")
public class BookListController {

    private final BookListService bookListService;

    @Autowired
    public BookListController(BookListService bookListService) {
        this.bookListService = bookListService;
    }

	// 예약 글 전체 조회
    @GetMapping("/")
    public ResponseEntity<List<BookList>> getAllBookList() {
        List<BookList> bookLists = bookListService.getAllBookList();
        return ResponseEntity.ok(bookLists);
    }

	// 예약 글 등록
    @PostMapping("/")
    public ResponseEntity<String> insertBookList(@RequestBody BookList bookList) {
        int result = bookListService.insert(bookList);
        if (result == 1) {
            return ResponseEntity.ok("Book list created successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to create book list.");
        }
    }

	// 예약 글 수정
    @PutMapping("/{bookId}")
    public ResponseEntity<String> updateBookList(@PathVariable int bookId, @RequestBody BookList bookList) {
        bookList.setBookId(bookId);
        int result = bookListService.update(bookList);
        if (result == 1) {
            return ResponseEntity.ok("Book list updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to update book list.");
        }
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBookList(@PathVariable int bookId) {
        int result = bookListService.delete(bookId);
        if (result == 1) {
            return ResponseEntity.ok("Book list deleted successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete book list.");
        }
    }
}