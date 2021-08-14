package com.viniciuscrispim.sbmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.viniciuscrispim.sbmongo.domain.Post;
import com.viniciuscrispim.sbmongo.domain.User;
import com.viniciuscrispim.sbmongo.dto.UserDTO;
import com.viniciuscrispim.sbmongo.services.UserService;

@RestController
@RequestMapping (value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method =RequestMethod.GET)
	// ou @GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		//convertendo list de user para listDTO com instrução lambida
		//transforma list original para stream que é uma coleção compativel
		//com exprssão lambida, depois faz um map passando os users e retornando um userdto
		//por fim converte o stream pra lista com o collect
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User u = service.findById(id);
		UserDTO udto = new UserDTO(u);
		return ResponseEntity.ok().body(udto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveUser(@RequestBody UserDTO udto){
		User u = service.fromDTO(udto);
		u = service.saveUser(u);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(u.getId())
				.toUri();
		return ResponseEntity.created(uri).build();			
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable String id){
		service.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO udto){
		User u = service.fromDTO(udto);
		u.setId(id);
		service.updateUser(u);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User u = service.findById(id);
		return ResponseEntity.ok().body(u.getPosts());
	}
	
}
