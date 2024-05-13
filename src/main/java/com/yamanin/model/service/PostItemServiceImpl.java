package com.yamanin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamanin.model.dao.PostItemDao;
import com.yamanin.model.dto.PostItem;

@Service
public class PostItemServiceImpl implements PostItemService {

	private final PostItemDao postItemDao;
	
	@Autowired
	public PostItemServiceImpl(PostItemDao postItemDao) {
		this.postItemDao = postItemDao;
	}
	
    @Override
    public List<PostItem> getAllPostItem() {
        System.out.println("Fetching all post items");
        // 데이터베이스에서 모든 게시글을 조회하는 로직을 구현
        return postItemDao.selectAll(); // 임시로 빈 리스트 반환
    }

    @Override
    public PostItem getPostItemById(int postId) {
        System.out.println("Fetching post item by ID: " + postId);
        // 데이터베이스에서 특정 ID를 가진 게시글을 조회하는 로직을 구현
        return postItemDao.selectOne(postId);
    }

    @Override
    public List<PostItem> getPostItemByTitle(String title) {
        System.out.println("Fetching post item by Title: " + title);
        // 데이터베이스에서 특정 제목을 가진 게시글을 조회하는 로직을 구현
        return postItemDao.selectByTitle(title);
    }

    @Override
    public int insert(PostItem postItem) {
        System.out.println("Inserting a new post item");
        // 데이터베이스에 새 게시글을 추가하는 로직을 구현
		return postItemDao.insertPostItem(postItem);
    }

    @Override
    public int update(PostItem postItem) {
        System.out.println("Updating post item with ID: " + postItem.getPostId());
        // 데이터베이스에서 특정 게시글을 업데이트하는 로직을 구현
		return postItemDao.updatePostItem(postItem);
    }

    @Override
    public int delete(int postId) {
        System.out.println("Deleting post item with ID: " + postId);
        // 데이터베이스에서 특정 게시글을 삭제하는 로직을 구현
		return postItemDao.deletePostItem(postId);
    }
}