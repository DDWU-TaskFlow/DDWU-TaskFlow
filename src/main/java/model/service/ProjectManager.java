package model.service;

import java.util.List;

import model.Project;
import model.dao.ProjectDao;

public class ProjectManager {
	private static ProjectManager projectManager = new ProjectManager();
	private ProjectDao projectDAO;
	
	private ProjectManager() {
		try {
			projectDAO = new ProjectDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ProjectManager getInstance() {
		return projectManager;
	}
	
	public List<Project> getProjectList() {
		//TEST
		System.out.println("ProjectManager의 getProjectList() 호출됨");
		
		return projectDAO.getProjectList();
	}
	
}
