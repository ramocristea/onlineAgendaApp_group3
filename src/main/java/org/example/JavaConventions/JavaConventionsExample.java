package org.example.JavaConventions;

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

	public static void main(String[] args) {
		AgendaCreation(); tasksintheagenda();
		System.out.println("-----------------------------");
		Tasktoagenda(LocalDateTime.of(2018, 7, 5, 17, 50), "New task for today", Priority.IMPORTANT);
		Tasktoagenda(LocalDateTime.of(2018, 7, 5, 19, 50), "New task for today 2", Priority.IMPORTANT);
		tasksintheagenda();
		System.out.println("-----------------------------");
		tasksfortoday();
	}
	private static void AgendaCreation() {
		Onlineagenda = new OnlineAgenda(); int id;
		LocalDateTime today = LocalDateTime.now();Task yesterdayTask = new Task();
		id = getNextRandomId();
		idlist.add(id);
		yesterdayTask.setId(id);
		yesterdayTask.setTargetCompletionDate(today.minusDays(1));
		yesterdayTask.setPriority(Priority.URGENT);
		yesterdayTask.setDescription("Yesterday's Task");
		Onlineagenda.getTasks().add(yesterdayTask);
		Task todayTask = new Task();
		id = getNextRandomId();
		idlist.add(id);
		todayTask.setId(id);
		todayTask.setTargetCompletionDate(today);
		todayTask.setPriority(Priority.TRIVIAL);
		todayTask.setDescription("Today's Task");
		Onlineagenda.getTasks().add(todayTask);
		Task tomorrowTask = new Task();id = getNextRandomId();
		idlist.add(id);
		tomorrowTask.setId(id);
		tomorrowTask.setTargetCompletionDate(today.plusDays(1));
		tomorrowTask.setPriority(Priority.IMPORTANT);
		tomorrowTask.setDescription("Tomorrow's Task");
		Onlineagenda.getTasks().add(tomorrowTask);
	}
	private static void tasksintheagenda() {
		for (Task task : Onlineagenda.getTasks()) {System.out.println(task);}
	}
	private static void Tasktoagenda(LocalDateTime c, String d, Priority p) {
		Task tomorrowTask=new Task();int id=getNextRandomId();
		idlist.add(id);
		tomorrowTask.setId(id);
		tomorrowTask.setTargetCompletionDate(c);
		tomorrowTask.setPriority(p);
		tomorrowTask.setDescription(d);
		Onlineagenda.getTasks()
		.add(tomorrowTask);
	}
	private static List<Integer> idlist = new ArrayList<>();
	private static void deleteTaskFromAgenda(int id) {
		Iterator<Task> iterator = Onlineagenda.getTasks().iterator();
		while (iterator.hasNext()) 
		{if (iterator.next().getId() == id) 
		{iterator.remove(); return;}}
	}
	private static OnlineAgenda Onlineagenda;
	private static void updateTaskPriority(int id, Priority newPriority) {
		for (Task task : Onlineagenda.getTasks()) {if (task.getId() == id) 
		{task.setPriority(newPriority);return;}
		}
	}
	private static int getNextRandomId() {
		Random random = new Random();
		return random.nextInt(100);
	}
	private static void tasksfortoday() {
		List<Task> list1 = new ArrayList<>();
		List<Task> list2 = new ArrayList<>();
		List<Task> list3 = new ArrayList<>();
		for (Task task : Onlineagenda.getTasks()) 
		{if (LocalDate.now().isEqual(task.getTargetCompletionDate().toLocalDate())) 
		{switch (task.getPriority()) {
				case URGENT: list1.add(task);break;
			case IMPORTANT:list2.add(task);
					break;
				case TRIVIAL:
					list3.add(task);break;
		}}}
		Collections.sort(list1, new Comparator<Task>() {@Override
			public int compare(Task o1, Task o2) {if (o1.getTargetCompletionDate() == null && o2.getTargetCompletionDate() != null) {
					return -1;
			}return o1.getTargetCompletionDate().compareTo(o2.getTargetCompletionDate());
			}
				});
		Collections.sort(list2, new Comparator<Task>() {@Override
			public int compare(Task o1, Task o2) {if (o1.getTargetCompletionDate() == null && o2.getTargetCompletionDate() != null) {
					return -1;
			}return o1.getTargetCompletionDate().compareTo(o2.getTargetCompletionDate());
			}
				});
		Collections.sort(list3, new Comparator<Task>() {@Override
			public int compare(Task o1, Task o2) {if (o1.getTargetCompletionDate() == null && o2.getTargetCompletionDate() != null) {
					return -1;
			}return o1.getTargetCompletionDate().compareTo(o2.getTargetCompletionDate());
			}
				});
		System.out.println("URGENT tasks for today:");
		if (CollectionUtils.isEmpty(list1)) {
		System.out.println("You have no URGENT tasks");} else {
			for (Task task : list1) {System.out.println(task.toString());
			}}System.out.println("-----------------------------");
		System.out.println("IMPORTANT tasks for today:");
		if (CollectionUtils.isEmpty(list2)) {
		System.out.println("You have no IMPORTANT tasks");} 
		
		else 
		{for (Task task : list2) {System.out.println(task.toString());
			}
				}
		System.out.println("-----------------------------");
		System.out.println("TRIVIAL tasks for today:");
		if (CollectionUtils.isEmpty(list3)) 
		{System.out.println("You have no TRIVIAL tasks");} else 
		{for (Task task : list3) {System.out.println(task.toString());
			}
			}

	}

}
