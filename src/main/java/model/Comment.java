package model;

import java.sql.Date;

public class Comment {
	private int commentId;
	private int taskId;
	private int memberId;
	private Date writtenDate;
	private String content;
	
	public Comment() {
		this(0, 0, 0, new Date(0), "");
	}

	public Comment(int commentId, int taskId, int memberId, Date writtenDate, String content) {
		super();
		this.commentId = commentId;
		this.taskId = taskId;
		this.memberId = memberId;
		this.writtenDate = writtenDate;
		this.content = content;
	}
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getTask_id() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
		return "Comment [commentId=" + commentId + ", taskId=" + taskId + ", memberId=" + memberId
				+ ", writtenDate=" + writtenDate + ", content=" + content + "]";
	}
}
