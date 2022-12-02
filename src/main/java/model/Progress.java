package model;

import java.sql.Date;

public class Progress {
	private int progress_id;
	private int progress;
	private int task_id;
	private Date recordeDate;
	
	public Progress() {
		super();
	}
	public Progress(int progress_id, int progress, int taskId, Date recordeDate) {
		super();
		this.progress_id = progress_id;
		this.progress = progress;
		this.task_id = taskId;
		this.recordeDate = recordeDate;
	}
	
	public int getProgressId() {
		return progress_id;
	}

	public void setProgressId(int progressId) {
		this.progress_id = progressId;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getTaskId() {
		return task_id;
	}

	public void setTaskId(int taskId) {
		this.task_id = taskId;
	}

	public Date getRecordeDate() {
		return recordeDate;
	}

	public void setRecordeDate(Date recordeDate) {
		this.recordeDate = recordeDate;
	}

	@Override
	public String toString() {
		return "Progress [progress_id=" + progress_id + ", progress=" + progress + ", task_id=" + task_id
				+ ", recordeDate=" + recordeDate + "]";
	}	
}
