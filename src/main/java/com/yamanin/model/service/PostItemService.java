package com.yamanin.model.service;

import java.util.List;

import com.yamanin.model.dto.PostItem;

public interface PostItemService {
	List<PostItem> getAllPostItem(); // 게시글 전체 조회
	PostItem getPostItemById(int postId); // 게시글 하나만 아이디로 조회
	List<PostItem> getPostItemByTitle(String title); // 게시글 title로 조회
	int insert(PostItem postItem); // 게시글 작성
	int update(PostItem postItem); // 게시글 수정
	int delete(int postId); // 게시글 삭제
}
