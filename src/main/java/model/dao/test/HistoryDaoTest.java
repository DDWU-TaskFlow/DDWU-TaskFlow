package model.dao.test;

import java.util.List;

import model.History;
import model.dao.jdbc.HistoryDao;


public class HistoryDaoTest {

	private static HistoryDao historyDao = new HistoryDao();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HistoryDaoTest");
		
//		System.out.println(historyDao.insertHistory(100, 10001, "Task"));
		System.out.println(historyDao.deleteHistoryByProjectId(102));

		List<History> hList = historyDao.findHistoryByProjectId(102);
		System.out.println(hList);
		
		System.out.println(historyDao.findHistoryByMemberId(100, 10001));

	}

}
