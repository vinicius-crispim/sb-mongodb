package com.viniciuscrispim.sbmongo.dto;

import java.io.Serializable;

import com.viniciuscrispim.sbmongo.domain.User;

public class AuthorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	
	public AuthorDTO() {
		
	}
	public AuthorDTO(User u) {
		id = u.getId();
		name = u.getName();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
