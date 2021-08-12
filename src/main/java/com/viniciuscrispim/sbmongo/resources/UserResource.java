package com.viniciuscrispim.sbmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viniciuscrispim.sbmongo.domain.User;

@RestController
@RequestMapping (value = "/users")
public class UserResource {
	
	@RequestMapping(method =RequestMethod.GET)
	// ou @GetMapping
	public ResponseEntity<List<User>> findAll(){
		User u = new User(1,"Maria Souza","maria@gmail.com");
		User u2 = new User(1,"Cleber Souza","cleber@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(u,u2));
		return ResponseEntity.ok().body(list);
	}

}
