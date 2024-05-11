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

import com.yamanin.model.dto.PostItem;
import com.yamanin.model.service.PostItemService;

import java.util.List;

@RestController
@RequestMapping("/api-postItems")
public class PostItemController {

    private final PostItemService postItemService;

    @Autowired
    public PostItemController(PostItemService postItemService) {
        this.postItemService = postItemService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PostItem>> getAllPostItems() {
        List<PostItem> postItems = postItemService.getAllPostItem();
        return ResponseEntity.ok(postItems);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostItem> getPostItemById(@PathVariable int postId) {
        PostItem postItem = postItemService.getPostItemById(postId);
        return ResponseEntity.ok(postItem);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<PostItem>> getPostItemByTitle(@PathVariable String title) {
        List<PostItem> postItem = postItemService.getPostItemByTitle(title);
        return ResponseEntity.ok(postItem);
    }

    @PostMapping("/")
    public ResponseEntity<String> createPostItem(@RequestBody PostItem postItem) {
        int result = postItemService.insert(postItem);
        if (result == 1) {
            return ResponseEntity.ok("Post item created successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to create post item.");
        }
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePostItem(@PathVariable int postId, @RequestBody PostItem postItem) {
        postItem.setPostId(postId);
        int result = postItemService.update(postItem);
        if (result == 1) {
            return ResponseEntity.ok("Post item updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to update post item.");
        }
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostItem(@PathVariable int postId) {
        int result = postItemService.delete(postId);
        if (result == 1) {
            return ResponseEntity.ok("Post item deleted successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete post item.");
        }
    }
}