package com.sa.entity;

import java.io.Serializable;

public class Stock implements Serializable{
	
	private static final long serialVersionUID = 4794169073579353672L;
	
	private Long id;
	private String no;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stock [id=");
		builder.append(id);
		builder.append(", no=");
		builder.append(no);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	
}
