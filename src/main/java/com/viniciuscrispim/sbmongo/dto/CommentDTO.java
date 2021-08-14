package com.viniciuscrispim.sbmongo.dto;

import java.io.Serializable;
import java.util.Date;

import com.viniciuscrispim.sbmongo.domain.User;

public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String text;
	private Date date;
	private UserDTO author;

	public CommentDTO() {
	}

	public CommentDTO(String text, Date date, UserDTO author) {
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserDTO getAuthor() {
		return author;
	}

	public void setAuthor(UserDTO author) {
		this.author = author;
	}

}
