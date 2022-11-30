package model.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Member;
import model.Participation;
import model.Project;
import model.dao.mybatis.mapper.ProjectMapper;

public class ProjectDao {
	private SqlSessionFactory sqlSessionFactory;

	public ProjectDao() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public Project insertProject(Project pro) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(ProjectMapper.class).insertProject(pro);
			if(result > 0) {
				sqlSession.commit();
			}
			return pro;
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateProject(Project pro) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(ProjectMapper.class).updateProject(pro);
			if(result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}	
	public Participation participateInProject(Participation part) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(ProjectMapper.class).participateInProject(part);
			if(result > 0) {
				sqlSession.commit();
			}
			return part;
		} finally {
			sqlSession.close();
		}
	}
	
	public int deleteProject(int project_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(ProjectMapper.class).deleteProject(project_id);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;	
		} finally {
			sqlSession.close();
		}
	}
	
	public int outProject(Participation part) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(ProjectMapper.class).outProject(part);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;	
		} finally {
			sqlSession.close();
		}
	}
	
	public Project findProject(int project_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ProjectMapper.class).findProject(project_id);
		} finally {
			sqlSession.close();
		}
	}

	public List<Project> findProjectsInMember(int member_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
//			List<Project> result = sqlSession.getMapper(ProjectMapper.class).findProjectsInMember(member_id);			
			List<Project> result = sqlSession.selectList("model.dao.mybatis.mapper.ProjectMapper.findProjectsInMember", member_id);
			System.out.println("test"+result);
			return result;			
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Member> findMembersInProject(int project_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ProjectMapper.class).findMembersInProject(project_id);			
		} finally {
			sqlSession.close();
		}	
	}
}
