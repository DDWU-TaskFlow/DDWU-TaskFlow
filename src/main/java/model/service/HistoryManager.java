package model.service;

import java.util.ArrayList;
import java.util.List;

import model.History;
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
	
	public List<History> findHistoryByProjectId(int projectId) {
		List<History> historyList = new ArrayList<History>();
		historyList = historyDao.findHistoryByProjectId(projectId);
		return historyList;
	}

	public List<History> findHistoryByMemberId(int projectId, int memberId) {
		List<History> historyList = new ArrayList<History>();
		historyList = historyDao.findHistoryByMemberId(projectId, memberId);
		return historyList;
	}

	public String findMemberNameByHistoryId(int historyId) {
		String memberName = historyDao.findMemberNameByHistoryId(historyId);
		return memberName;
	}
	
	public int insertHistory(int projectId, int memberId, String content) {
		return historyDao.insertHistory(projectId, memberId, content);
	}
	
	public int deleteHistory(int projectId) {
		return historyDao.deleteHistoryByProjectId(projectId);
	}
	
}
