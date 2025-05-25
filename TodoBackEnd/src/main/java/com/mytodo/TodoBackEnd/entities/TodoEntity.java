package com.mytodo.TodoBackEnd.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class TodoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
		
	@Column(nullable = false)
	@Size(min = 3, message = "Title must contain atleast 3 charcters")
	private String title;
		
	@Column(nullable = false)
	@Size(min = 3, message = "Description must contain atleast 3 charcters")
	private String description;
		
	@Column(nullable = false)
	private LocalDate startDate;
		
	@Column(nullable = false)
	private LocalDate endDate;
	
	@Column(nullable = false)
	private boolean isPending;
		
	public TodoEntity() {
		super();
	}

	public TodoEntity(int id, @Size(min = 3, message = "Title must contain atleast 3 charcters") String title,
			@Size(min = 3, message = "Description must contain atleast 3 charcters") String description,
			LocalDate startDate, LocalDate endDate, boolean isPending) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isPending = isPending;
	}

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
