package model.dao.test;

import java.util.List;

import model.Progress;
import model.dao.jdbc.HistoryDao;


public class HistoryDaoTest {

	private static HistoryDao historyDao = new HistoryDao();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HistoryDaoMybatisTest");

		List<Progress> prgList = historyDao.findProgressByProjectId(100);
		System.out.println(prgList);
		
		System.out.println(historyDao.getProgressList(1001));

	}

}
