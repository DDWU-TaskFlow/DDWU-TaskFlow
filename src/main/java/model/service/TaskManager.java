package model.service;

import java.util.List;

import model.Task;
import model.dao.jdbc.TaskDao;

public class TaskManager {
	private static TaskManager taskManager = new TaskManager();
	private TaskDao taskDao;
	
	private TaskManager() {
		try {
			taskDao = new TaskDao();
			System.out.println("taskDAO 생성 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TaskManager getInstance() {
		return taskManager;
	}
	
	public List<Task> getTaskList(int projectId) {
		List<Task> taskList = null;
		taskList = taskDao.getTaskList(projectId);
		
		System.out.println("getTaskList");
		return taskList;
	}
	
	public List<Task> getTaskList(int projectId, int memberId) {
		List<Task> taskList = null;
		taskList = taskDao.getTaskList(projectId, memberId);
		
		System.out.println("getTaskList");
		return taskList;
	}
	
	public int getMemberProgress(int projectId, int memberId) {
		List<Task> taskList = getTaskList(projectId, memberId);
		int progress = 0;
		int count = 0;
		for (Task task : taskList) {
			progress += task.getTask_progress();
			count++;
		}
		if (progress > 0) {
			progress /= count;
		}

		return progress;
	}
	
	public Task findTaskByTaskId(int taskId) {
		Task task = taskDao.findTaskByTaskId(taskId);
		return task;
	}
	
	public String findMemberNameByTaskId(int taskId) {
		String memberName = taskDao.findMemberNameByTaskId(taskId);
		return memberName;
	}
	
	public int updateTask(Task task) {
		return taskDao.updateTask(task);
	}
	
}
