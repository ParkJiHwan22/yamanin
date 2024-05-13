package com.yamanin.model.service;

import java.util.List;

import com.yamanin.model.dto.BookList;

public interface BookListService {
	// 예약 글 전체 조회
    List<BookList> getAllBookList();
    
	// 예약 글 등록
	public int insert(BookList bookList);

	// 예약 글 수정
	public int update(BookList bookList);
	
	// 예약 글 삭제
	public int delete(int bookId);
	
}
