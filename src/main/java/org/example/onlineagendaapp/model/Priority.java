package org.example.onlineagendaapp.model;

public enum Priority {
	
	URGENT (0),
	IMPORTANT (1),
	TRIVIAL(2);
	
	private int priority;

	private Priority(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

}
