package model.dao.mybatis.mapper;

import java.util.List;
import model.Member;
import model.Participation;
import model.Project;

public interface ProjectMapper {
	public int insertProject(Project pro);
	
	public int updateProject(Project pro);
	
	public int participateInProject(Participation part);
	 
	public int deleteProject(int project_id); //팀장 권한
	
	public int outProject(Participation part); //팀원 권한
	 
	public Project findProject(int project_id);
	 
	public List<Project> findProjectsInMember(int member_id);
	
	public List<Member> findMembersInProject(int projectId);
}
