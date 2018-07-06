package org.example.onlineagendaapp.model;

import java.util.ArrayList;
import java.util.List;

public class OnlineAgenda {

	private List<Task> tasks;

	public List<Task> getTasks() {
		if (tasks == null) {
			tasks = new ArrayList<Task>();
		}
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
