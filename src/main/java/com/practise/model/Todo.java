package com.practise.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "todo")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String user;
	
	String desc;
	
	@Column(updatable = false, nullable = false)
    @CreatedDate
    Date dueBy;
	
	Boolean isDone;

	public Todo() {
	}

	public Todo(int id, String user, String desc, Date dueBy, Boolean isDone) {
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

	public String getuser() {
		return user;
	}

	public String getDesc() {
		return desc;
	}

	public Date getDueBy() {
		return dueBy;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setDueBy(Date dueBy) {
		this.dueBy = dueBy;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

}
