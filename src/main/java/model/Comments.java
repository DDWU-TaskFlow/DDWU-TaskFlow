package model;

import java.sql.Date;

public class Comments {
	private int comment_id;
	private int task_id;
	private int member_id;
	private Date writtenDate;
	private String content;
	
	public Comments() {
		this(0, 0, 0, new Date(0), "");
	}

	public Comments(int comment_id, int task_id, int member_id, Date writtenDate, String content) {
		super();
		this.comment_id = comment_id;
		this.task_id = task_id;
		this.member_id = member_id;
		this.writtenDate = writtenDate;
		this.content = content;
	}
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
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
	public Date getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comments [comment_id=" + comment_id + ", task_id=" + task_id + ", member_id=" + member_id
				+ ", writtenDate=" + writtenDate + ", content=" + content + "]";
	}
}
