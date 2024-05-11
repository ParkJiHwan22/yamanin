package com.yamanin.model.dao;

import java.util.List;

import com.yamanin.model.dto.PostItem;

public interface PostItemDao {
	// 게시글 전체 조회
    List<PostItem> selectAll();
    
    // 게시글 하나만 아이디로 조회
    PostItem selectOne(int postId);
	
    // 게시글 title로 조회
    List<PostItem> selectByTitle(String title);
    
	// 게시글 등록
	public int insertPostItem(PostItem postItem);

	// 게시글 수정
	public int updatePostItem(PostItem postItem);
	
	// 게시글 삭제
	public int deletePostItem(int postId);
	
}
