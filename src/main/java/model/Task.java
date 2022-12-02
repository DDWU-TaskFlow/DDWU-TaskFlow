package model;

import java.sql.Date;

public class Task {
	private int task_id;
	private int task_progress;
	private int project_id;
	private int member_id;
	private String name;
	private String content;
	private Date deadline;
	
	public Task() {
		this(0, 0, 0, 0, "", "", new Date(0));
	}
	
	public Task(int task_id, int task_progress, int project_id, int member_id, String name, String content,
			Date deadline) {
		super();
		this.task_id = task_id;
		this.task_progress = task_progress;
		this.project_id = project_id;
		this.member_id = member_id;
		this.name = name;
		this.content = content;
		this.deadline = deadline;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	
	public int getTask_progress() {
		return task_progress;
	}
	public void setTask_progress(int task_progress) {
		this.task_progress = task_progress;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", task_progress=" + task_progress + ", project_id=" + project_id
				+ ", member_id=" + member_id + ", name=" + name + ", content=" + content + ", deadline=" + deadline
				+ "]";
	}
}
