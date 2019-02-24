package org.example.javaconventions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.CollectionUtils;
import org.example.onlineagendaapp.model.OnlineAgenda;
import org.example.onlineagendaapp.model.Priority;
import org.example.onlineagendaapp.model.Task;

public class JavaConventionsExample {
	private static OnlineAgenda onlineAgenda;
	private static List<Integer> idList = new ArrayList<>();

	public static void main(String[] args) {
		onlineAgenda = new OnlineAgenda();

		initializeAgenda();
		printAllTasksFromAgenda();

		System.out.println("-----------------------------");

		addTaskToAgenda(LocalDateTime.of(2019, 2, 24, 19, 50), "New task for today 2", Priority.IMPORTANT);
		addTaskToAgenda(LocalDateTime.of(2019, 2, 24, 17, 50), "New task for today", Priority.IMPORTANT);
		
		printAllTasksFromAgenda();
		
		System.out.println("-----------------------------");
		printAllTodaysTasksGroupedByPriorityAndSortedByTargetDate();
	}

	private static void initializeAgenda() {
		LocalDateTime today = LocalDateTime.now();
		addTaskToAgenda(today.minusDays(1), "Yesterday's Task", Priority.URGENT);
		addTaskToAgenda(today, "Today's Task", Priority.TRIVIAL);
		addTaskToAgenda(today.plusDays(1), "Tomorrow's Task", Priority.IMPORTANT);
	}

	private static void printAllTasksFromAgenda() {
		for (Task task : onlineAgenda.getTasks()) {
			System.out.println(task);
		}
	}

	private static void addTaskToAgenda(LocalDateTime completionDate, String description, Priority priority) {
		int id = getNextRandomId();
		idList.add(id);
		Task task = new Task(id, completionDate, priority, description);

		onlineAgenda.getTasks().add(task);
	}

	private static void deleteTaskFromAgenda(int id) {
		Iterator<Task> iterator = onlineAgenda.getTasks().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == id) {
				iterator.remove();
				return;
			}
		}
	}

	private static void updateTaskPriority(int id, Priority newPriority) {
		for (Task task : onlineAgenda.getTasks()) {
			if (task.getId() == id) {
				task.setPriority(newPriority);
				return;
			}
		}
	}

	private static int getNextRandomId() {
		Random random = new Random();
		return random.nextInt(100);
	}
	
	private static void sortTasks(List<Task> tasks) {
		Collections.sort(tasks, new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				if (o1.getTargetCompletionDate() == null && o2.getTargetCompletionDate() != null) {
					return -1;
				}
				return o1.getTargetCompletionDate().compareTo(o2.getTargetCompletionDate());
			}
		});
	}
	
	public static List<Task> getTodaysTasksByPriority(List<Task> tasks, Priority priority) {
		List<Task> urgentTasks = new ArrayList<>();
		for(Task task : tasks) {
			if(task.getPriority().equals(priority) && 
					LocalDate.now().isEqual(task.getTargetCompletionDate().toLocalDate())) {
				urgentTasks.add(task);
			}
		}
		
		return urgentTasks;
	}

	private static void printAllTodaysTasksGroupedByPriorityAndSortedByTargetDate() {
		List<Task> urgentTasks = getTodaysTasksByPriority(onlineAgenda.getTasks(), Priority.URGENT);
		List<Task> importantTasks = getTodaysTasksByPriority(onlineAgenda.getTasks(), Priority.IMPORTANT);
		List<Task> trivialTasks = getTodaysTasksByPriority(onlineAgenda.getTasks(), Priority.TRIVIAL);
		
		sortTasks(urgentTasks);
		sortTasks(importantTasks);
		sortTasks(trivialTasks);
		
		System.out.println("URGENT tasks for today:");
		if (CollectionUtils.isEmpty(urgentTasks)) {
			System.out.println("You have no URGENT tasks");
		} else {
			for (Task task : urgentTasks) {
				System.out.println(task.toString());
			}
		}
		System.out.println("-----------------------------");
		System.out.println("IMPORTANT tasks for today:");
		if (CollectionUtils.isEmpty(importantTasks)) {
			System.out.println("You have no IMPORTANT tasks");
		}

		else {
			for (Task task : importantTasks) {
				System.out.println(task.toString());
			}
		}
		System.out.println("-----------------------------");
		System.out.println("TRIVIAL tasks for today:");
		if (CollectionUtils.isEmpty(trivialTasks)) {
			System.out.println("You have no TRIVIAL tasks");
		} else {
			for (Task task : trivialTasks) {
				System.out.println(task.toString());
			}
		}

	}

}
