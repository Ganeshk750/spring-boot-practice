package com.ganesh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.model.Post;
import com.ganesh.repository.PostRepository;
import com.ganesh.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepo;

	@Override
	public List<Post> getAllPosts() {
		return postRepo.findAll();
	}

	@Override
	public Post getOnePost() {
		List<Post> list = postRepo.findAll();
		Post post = list.get(list.size() - 1);
		return post;
	}

	@Override
	public void createPost(Post newPost) {
		Post post = postRepo.save(newPost);
	}

	@Override
	public Post getPost(Integer postId) {
		return postRepo.getById(postId);
	}

	@Override
	public void updatePost(Post updatedPost) {
		Post post = postRepo.save(updatedPost);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = postRepo.getById(postId);
		postRepo.delete(post);
	}

}
