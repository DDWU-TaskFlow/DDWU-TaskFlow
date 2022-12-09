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
import model.service.LongNameException;
import model.service.ProjectManager;

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
	
	public int insertProject(Project pro) throws LongNameException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			if(pro.getName().getBytes().length >= 40) {
				throw new LongNameException("이름이 너무 깁니다.");
			}
			int result = sqlSession.getMapper(ProjectMapper.class).insertProject(pro);
			if(result > 0) {
				sqlSession.commit();
			}
			return result;
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
	
//	public Participation participateInProject(Participation part) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		try {
//			int result = sqlSession.getMapper(ProjectMapper.class).participateInProject(part);
//			if(result > 0) {
//				sqlSession.commit();
//			}
//			return part;
//		} finally {
//			sqlSession.close();
//		}
//	}
	
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
	
	public int outProjectForMember(Participation part) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(ProjectMapper.class).outProjectForMember(part);
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
			List<Project> result = sqlSession.getMapper(ProjectMapper.class).findProjectsInMember(member_id);			
//			List<Project> result = sqlSession.selectList("model.dao.mybatis.mapper.ProjectMapper.findProjectsInMember", member_id);
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

	public int participateInProject(int project_id, int leader_id) {
		System.out.println("ProjectDao.java: participateInProject 호출 완료");

		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ProjectMapper.class).participateInProject(project_id, leader_id);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		
	}

	public Integer getProjectID(String code) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ProjectMapper.class).getProjectIDByCode(code);
		} finally {
			sqlSession.close();
		}
	}

	public Integer getProjectID(Project pro) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ProjectMapper.class).getProjectIDByName(pro.getLeader_id(), pro.getName());
		} finally {
			sqlSession.close();
		}
	}
	
	public int outProject(int project_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ProjectMapper.class).outProject(project_id);
		} finally {
			sqlSession.close();
		}
	}
}
