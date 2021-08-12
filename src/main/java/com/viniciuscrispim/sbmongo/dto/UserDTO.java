package com.viniciuscrispim.sbmongo.dto;

import java.io.Serializable;

import com.viniciuscrispim.sbmongo.domain.User;

/*DTO é um objeto q serve para carregar dados das
 entidades de forma simples, podendo inclusive projetar
 apenas alguns dados da entidade original
 EX: Entidade User possui 10 atributos, mas eu faço um DTO
 para pegar apenas 4
*/
public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String id;
	public String name;
	public String email;

	public UserDTO(){}
	
	//abaixo para instanciar um dto apartir de um user
	public UserDTO(User u) {
		id = u.getId();
		name = u.getName();
		email = u.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
