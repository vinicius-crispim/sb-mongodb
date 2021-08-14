package com.viniciuscrispim.sbmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciuscrispim.sbmongo.domain.User;
import com.viniciuscrispim.sbmongo.dto.UserDTO;
import com.viniciuscrispim.sbmongo.repositories.UserRepository;
import com.viniciuscrispim.sbmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	private User u;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> u = repository.findById(id);
		return u.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
	}
	
	public User saveUser(User u) {
		return repository.insert(u);
	}
	
	public void deleteUser(String id) {
		findById(id); //caso o id nao exista ele lançara o erro
		repository.deleteById(id);
	}
	
	public User updateUser(User user) {
		User u = findById(user.getId());
		updateData(u, user);
		return repository.save(u);
	}
	
	private void updateData(User u, User user) {
		u.setEmail(user.getEmail());
		u.setName(user.getName());
	}
	
	//converte UserDTO em User
	public User fromDTO(UserDTO udto) {
		return new User(udto.getId(),udto.getName(),udto.getEmail());
	}
}
