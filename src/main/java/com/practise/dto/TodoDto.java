package com.practise.dto;

import java.util.Date;

public class TodoDto {

	int id;
	String user;
	String desc;
	Date dueBy;
	Boolean isDone;
	public TodoDto() {

	}

	public TodoDto(int id, String user, String desc, Date dueBy, Boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.dueBy = dueBy;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getDueBy() {
		return dueBy;
	}

	public void setDueBy(Date dueBy) {
		this.dueBy = dueBy;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	
}
