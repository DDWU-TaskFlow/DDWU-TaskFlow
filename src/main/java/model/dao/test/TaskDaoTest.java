package model.dao.test;

import model.dao.jdbc.TaskDao;

public class TaskDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskDao taskDao = new TaskDao();
		
		// findMemberNameByTaskId 테스트
//		System.out.println(taskDao.findMemberNameByTaskId(1001));
		
		// getProjectAvg 테스트
		System.out.println(taskDao.getProjectAvg(101));
	}

}
