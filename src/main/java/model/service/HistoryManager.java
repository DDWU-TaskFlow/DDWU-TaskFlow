package model.service;

import java.util.ArrayList;
import java.util.List;

import model.Progress;
import model.dao.jdbc.HistoryDao;

public class HistoryManager {

	private static HistoryManager historyManager = new HistoryManager();
	private HistoryDao historyDao;
	
	private HistoryManager() {
		try {
			historyDao = new HistoryDao();
			System.out.println("historyDao 생성 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static HistoryManager getInstance() {
		return historyManager;
	}
	
	public List<Progress> getProgressList(int taskId) {
		List<Progress> progressList = new ArrayList<Progress>();
		progressList = historyDao.getProgressList(taskId);
		return progressList;
	}
	
	public List<Progress> findProgressByProjectId(int projectId) {
		List<Progress> progressList = new ArrayList<Progress>();
		progressList = historyDao.findProgressByProjectId(projectId);
		return progressList;
	}
	
	public int insertProgress(int taskId, int progress) {
		return historyDao.insertProgress(taskId, progress);
	}
	
}
