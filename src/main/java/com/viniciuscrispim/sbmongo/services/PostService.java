package com.viniciuscrispim.sbmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciuscrispim.sbmongo.domain.Post;

import com.viniciuscrispim.sbmongo.repositories.PostRepository;
import com.viniciuscrispim.sbmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> u = repository.findById(id);
		return u.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		List<Post>list= repository.searchTitle(text);
		return list;
	}
	
	public Post savePost(Post post) {
		return repository.insert(post);
	}
	
	public void deletePost(String id) {
		findById(id); //caso o id nao exista ele lançara o erro
		repository.deleteById(id);
	}
	
}
