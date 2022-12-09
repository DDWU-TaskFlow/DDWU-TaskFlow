package model;

import java.sql.Timestamp;

public class History {
	private int historyId;
	private int projectId;
	private int memberId;
	private String content;
	private Timestamp recordedDate;
	
	public History() {
		this(0, 0, 0, "", new Timestamp(0));
	}
	
	public History(int historyId, int projectId, int memberId, String content, Timestamp recordedDate) {
		super();
		this.historyId = historyId;
		this.projectId = projectId;
		this.memberId = memberId;
		this.content = content;
		this.recordedDate = recordedDate;
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRecordedDate() {
		return recordedDate;
	}

	public void setRecordedDate(Timestamp recordedDate) {
		this.recordedDate = recordedDate;
	}

	@Override
	public String toString() {
		return "History [historyId=" + historyId + ", projectId=" + projectId + ", memberId=" + memberId + ", content="
				+ content + ", recordedDate=" + recordedDate + "]";
	}
	

}
