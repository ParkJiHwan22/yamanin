package com.yamanin.model.dao;

import java.util.List;

import com.yamanin.model.dto.BookList;

public interface BookListDao {
	// 예약 글 전체 조회
    List<BookList> selectAll();
    
	// 예약 글 등록
	public int insertBookList(BookList bookList);

	// 예약 글 수정
	public int updateBookList(BookList bookList);
	
	// 예약 글 삭제
	public int deleteBookList(int bookId);
	
}
