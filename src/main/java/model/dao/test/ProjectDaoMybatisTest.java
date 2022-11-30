package model.dao.test;

import java.util.List;

import model.Member;
import model.Project;
import model.dao.mybatis.ProjectDao;

public class ProjectDaoMybatisTest {
    private static ProjectDao projectDao = new ProjectDao();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ProjectDaoMybatisTest starts...");
		
		/*Date date = new Date(System.currentTimeMillis());
		projectDao.insertProject(new Project("데베프팀플", 1, date, "https://dprteamproject", "공지"));
		projectDao.insertProject(new Project("소공팀플", 1, date, "https://seproject", "공지: 요구사항정의서쓰기"));
		projectDao.insertProject(new Project("생지상팀플", 1, date, "https://counselor", "공지: 보고서10장"));
		System.out.println();
		
		System.out.println(projectDao.findProject(100));
		System.out.println(projectDao.findProject(101));
		System.out.println(projectDao.findProject(102));
		System.out.println();
		*/
//		System.out.println("100번 프로젝트 찾아봐: "+projectDao.findProject(100));
		
		List<Project> proList = projectDao.findProjectsInMember(2);
		System.out.println("맴버 2번의 proList"+proList);
		System.out.println();
				
		List<Member> memList = projectDao.findMembersInProject(100);
		System.out.println("프로젝트100번의 member들"+memList);
		projectDao.deleteProject(102);
//		System.out.println();
		
		
		/*
		updateProject(20200001L, "comment #0");
		findCommentByCondition("user1");
		System.out.println();
		
		findProjectsInMember();
		System.out.println();
		
		findMembersInProject();
		System.out.println();
		
		deleteProject(20200001L);
		outProject("user1");
		System.out.println();		*/
	}

}
