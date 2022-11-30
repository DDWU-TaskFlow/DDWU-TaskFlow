package model.dao.test;

import model.dao.jdbc.ProjectDao;

public class ProjectDaoTest {
	public static void main(String[] args) {
		ProjectDao projectDao = new ProjectDao();
		
		// getPorjectList()
		System.out.println(projectDao.getProjectList());

		// findProject(id)
		System.out.println(projectDao.findProject(1111));
	
	}
}
