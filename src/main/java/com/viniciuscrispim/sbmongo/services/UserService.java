package com.viniciuscrispim.sbmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciuscrispim.sbmongo.domain.User;
import com.viniciuscrispim.sbmongo.repositories.UserRepository;
import com.viniciuscrispim.sbmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> u = repository.findById(id);
		return u.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
	}
}
