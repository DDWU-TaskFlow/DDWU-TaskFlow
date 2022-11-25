package model;

public class Progress {
	private int progressId;
	private int progress;
	private int taskId;
	private String recordeDate;
	
	public Progress() {
		super();
	}

	public Progress(int project_id, int progress, int taskId, String recordeDate) {
		super();
		this.progressId = project_id;
		this.progress = progress;
		this.taskId = taskId;
		this.recordeDate = recordeDate;
	}
	
	public int getProgressId() {
		return progressId;
	}

	public void setProgressId(int progressId) {
		this.progressId = progressId;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getRecordeDate() {
		return recordeDate;
	}

	public void setRecordeDate(String recordeDate) {
		this.recordeDate = recordeDate;
	}

	@Override
	public String toString() {
		return "Progress [project_id=" + progressId + ", progress=" + progress + ", task_id=" + taskId
				+ ", recordeDate=" + recordeDate + "]";
	}
	
}
