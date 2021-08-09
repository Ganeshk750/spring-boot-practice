package com.ganesh.service;

import java.util.List;

import com.ganesh.model.Post;

public interface PostService {
	
	public List<Post> getAllPosts();
	public Post getOnePost();
	public void createPost(Post newPost);
	public Post getPost(Integer postId);
	public void updatePost(Post updatedPost);
	public void deletePost(Integer postId);

}
