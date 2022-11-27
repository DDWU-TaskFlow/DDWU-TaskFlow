package model.dao.test;

import model.dao.jdbc.ProjectDao;

public class ProjectDaoTest {
	public static void main(String[] args) {
		ProjectDao projectDao = new ProjectDao();
		System.out.println(projectDao.getProjectList());
	}
}
