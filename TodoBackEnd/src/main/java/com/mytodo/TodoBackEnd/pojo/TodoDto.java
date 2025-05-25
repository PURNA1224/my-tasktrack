package com.mytodo.TodoBackEnd.pojo;

import java.time.LocalDate;

public class TodoDto {
	
	private int id;
	private String title;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean isPending;
	
	public boolean getIsPending() {
		return isPending;
	}
	public void setIsPending(boolean isPending) {
		this.isPending = isPending;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
}
