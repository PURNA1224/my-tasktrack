package com.mytodo.TodoBackEnd.pojo;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateTodoRequestModel {
	
	@NotNull(message = "Title cannot be null")
	@Size(min = 3, message = "Title must contain atleast 3 charcters")
	private String title;
	@NotNull(message = "Title cannot be null")
	@Size(min = 5, message = "Description must contain atleast 5 charcters")
	private String description;
	@NotNull(message = "Start date cannot be null")
	private LocalDate startDate;
	@NotNull(message = "End date cannot be null")
	private LocalDate endDate;
	@NotNull(message = "Choose either true or false")
	private boolean isPending;
	
	
	public CreateTodoRequestModel() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public boolean getIsPending() {
		return isPending;
	}

	public void setIsPending(boolean isPending) {
		this.isPending = isPending;
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
