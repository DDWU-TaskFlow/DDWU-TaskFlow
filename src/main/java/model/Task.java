package model;

public class Task {
	private int task_id;
	private int taskProgress;
	private int project_id;
	private int member_id;
	private String name;
	private String deadline;
	
	public Task() {
		this(0, 0, 0, 0, "", "");
	}
	public Task(int task_id, int taskProgress, int project_id, int member_id, String name, String deadline) {
		super();
		this.task_id = task_id;
		this.taskProgress = taskProgress;
		this.project_id = project_id;
		this.member_id = member_id;
		this.name = name;
		this.deadline = deadline;
	}
	
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public int getTaskProgress() {
		return taskProgress;
	}
	public void setTaskProgress(int taskProgress) {
		this.taskProgress = taskProgress;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	@Override
	public String toString() {
		return "TaskDTO [task_id=" + task_id 
				+ ", taskProgress=" + taskProgress 
				+ ", project_id=" + project_id
				+ ", member_id=" + member_id 
				+ ", name=" + name 
				+ ", deadline=" + deadline + "]";
	}
	
}
