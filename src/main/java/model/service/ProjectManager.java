package model.service;

import java.util.List;
import java.util.Random;

import model.Member;
import model.Participation;
import model.Project;
import model.dao.jdbc.MemberDao;
import model.dao.jdbc.TaskDao;
import model.dao.mybatis.ProjectDao;

public class ProjectManager {
	private static ProjectManager projectManager = new ProjectManager();
	private ProjectDao projectDAO;
	private MemberDao memberDAO;
	private TaskDao taskDAO;

	private ProjectManager() {
		try {
			projectDAO = new ProjectDao();
			memberDAO = new MemberDao();
			taskDAO = new TaskDao();
			System.out.println("projectDAO, memberDAO 생성 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ProjectManager getInstance() {
		return projectManager;
	}

	public int insertProject(Project pro) throws LongNameException {
		if(projectDAO.insertProject(pro) != 1) {
			System.out.println("project 생성 실패");
			return 0;
		} else {
			projectDAO.participateInProject(projectDAO.getProjectID(pro), pro.getLeader_id());
			return 1;
		}
	}



	//	
	//	public int updateProject(Project pro) {
	//		return projectDAO.updateProject(pro);
	//	}
	//	


	
	public int updateProject(Project pro) {
		System.out.println("ProjectManager의 updateProject() 호출됨");
		return projectDAO.updateProject(pro);
	}
	

	public List<Project> findProjectsInMember(int member_id) {
		//TEST
		System.out.println("ProjectManager의 findProjectsInMember() 호출됨");
		List<Project> projectList = projectDAO.findProjectsInMember(member_id);
		
		return projectList;
	}

	public List<Project> findProjectsInMember(String user_name) {
		//TEST
		System.out.println("ProjectManager의 findProjectsInMember() 호출됨");
		int member_id = memberDAO.findMember(user_name).getMember_id();
		
		List<Project> projectList = projectDAO.findProjectsInMember(member_id);
		for (Project project : projectList) {
			int projcetAvg = taskDAO.getProjectAvg(project.getProject_id());
			project.setAvg(projcetAvg);
		}
		
		return projectList;
	}

	public List<Member> findMembersInProject(int project_id){
		//TEST
		System.out.println("ProjectManager의 findMembersInProject() 호출됨");
		return projectDAO.findMembersInProject(project_id);
	}

	public Project getProject(int project_id) {
		//TEST
		System.out.println("ProjectManager의 getProject() 호출됨");

		// Project 객체를 반환해야 함
		return projectDAO.findProject(project_id);
	}

	/*public Participation participateInProject(Participation part) {
		return projectDAO.participateInProject(part);
	}*/

	public int deleteProject(int project_id) {
		return projectDAO.deleteProject(project_id);	
	}


	/*public int outProject(Participation part) {
		return projectDAO.outProject(part);
	}*/


	
	public int outProject(int project_id) {
		return projectDAO.outProject(project_id);
	}
	
	public int outProjectByMember(Participation part) {
		return projectDAO.outProjectForMember(part);
	}
	 

	public Project findProject(int project_id) {
		return projectDAO.findProject(project_id);
	}

	public String getRandomString() {
		int leftLimit = 48; 	// numeral '0'
		int rightLimit = 122; 	// letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
		
		return generatedString;
	}
	
	public int getProjectID(String code) {
		System.out.println("ProjectManager.java: getProjectID에 들어온 파라미터는 " + code);
		
		return projectDAO.getProjectID(code);
	}
	
	public boolean participate(int projectId, int memberId) {
		if(projectDAO.participateInProject(projectId, memberId) < 1) {
			return false;
		} else {
			projectDAO.updateProjectType(projectId);
			System.out.println("ProjectManager.java: updateProjectType 실행됨");
			return true;
		}
		
	}
}
