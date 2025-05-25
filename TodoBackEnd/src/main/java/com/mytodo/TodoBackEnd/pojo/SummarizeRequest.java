package com.mytodo.TodoBackEnd.pojo;

public class SummarizeRequest {

	private String incompleteTodos;
	private String tone;
	
	public SummarizeRequest() {
		super();
	}
	public SummarizeRequest(String incompleteTodos, String tone) {
		super();
		this.incompleteTodos = incompleteTodos;
		this.tone = tone;
	}

	public String getIncompleteTodos() {
		return incompleteTodos;
	}
	public void setIncompleteTodos(String incompleteTodos) {
		this.incompleteTodos = incompleteTodos;
	}
	public String getTone() {
		return tone;
	}
	public void setTone(String tone) {
		this.tone = tone;
	}
	
	
}

