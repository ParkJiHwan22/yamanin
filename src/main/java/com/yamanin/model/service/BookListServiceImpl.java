package com.yamanin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yamanin.model.dao.BookListDao;
import com.yamanin.model.dto.BookList;

public class BookListServiceImpl implements BookListService {

	private final BookListDao bookListDao;
	
	@Autowired
	public BookListServiceImpl(BookListDao bookListDao) {
		this.bookListDao = bookListDao;
	}
	@Override
	public List<BookList> getAllBookList() {
		return bookListDao.selectAll();
	}

	@Override
	public int insert(BookList bookList) {
		return bookListDao.insertBookList(bookList);
	}

	@Override
	public int update(BookList bookList) {
		return bookListDao.updateBookList(bookList);
	}

	@Override
	public int delete(int bookId) {
		return bookListDao.deleteBookList(bookId);
	}
	
}
