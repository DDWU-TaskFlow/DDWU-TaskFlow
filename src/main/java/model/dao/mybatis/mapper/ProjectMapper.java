package model.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.Member;
import model.Participation;
import model.Project;

public interface ProjectMapper {
	public int insertProject(Project pro);
	
	public int updateProject(Project pro);
	
//	public int participateInProject(Participation part);
	 
	public int deleteProject(int project_id); //팀장 권한
	
	public int outProjectForMember(Participation part); //팀원 권한
	 
	public Project findProject(int project_id);
	 
	public List<Project> findProjectsInMember(int member_id);
	
	public List<Member> findMembersInProject(int projectId);
	
	public int participateInProject(@Param("pro_id")int pro_id, @Param("leader_id")int leader_id);
	
	public Integer getProjectIDByCode(String code);
	
	public int getProjectIDByName(@Param("leader_id")int leader_id, @Param("name")String name);
	
	public int outProject(int project_id);
	
	public Integer updateProjectType(int pro_id);
	
}
