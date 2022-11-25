package model;

public class Thread {
	private int thread_number;
	private String writtenDate;
	private String content;
	private int task_id;
	private int member_id;
	
	public Thread() {
		this(0, "", "", 0, 0);
	}
	public Thread(int thread_number, String writtenDate, String content, int task_id, int member_id) {
		super();
		this.thread_number = thread_number;
		this.writtenDate = writtenDate;
		this.content = content;
		this.task_id = task_id;
		this.member_id = member_id;
	}
	
	public int getThread_number() {
		return thread_number;
	}
	public void setThread_number(int thread_number) {
		this.thread_number = thread_number;
	}
	public String getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(String writtenDate) {
		this.writtenDate = writtenDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	@Override
	public String toString() {
		return "Thread [thread_number=" + thread_number 
				+ ", writtenDate=" + writtenDate 
				+ ", content=" + content 
				+ ", task_id=" + task_id 
				+ ", member_id=" + member_id + "]";
	}
	
	
}
