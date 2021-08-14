package com.viniciuscrispim.sbmongo.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public String id;
	
	public Date date;
	
	public String tittle;
	
	public String body;

	public User author;
	
	public Post(String id, Date date, String tittle, String body,User author) {
		this.id = id;
		this.date = date;
		this.tittle = tittle;
		this.body = body;
		this.author = author;
	}
	
	public Post() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getBody() {
		return body;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
}
