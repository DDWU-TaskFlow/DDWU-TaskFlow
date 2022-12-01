package model.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.dao.mybatis.mapper.ThreadMapper;

public class ThreadDao {
	private SqlSessionFactory sqlSessionFactory;

	public ThreadDao() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public List<Thread> findThreadByTaskId(int taskId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ThreadMapper.class).selectThreadByTaskId(taskId);			
		} finally {
			sqlSession.close();
		}
	}
	
	public int insertThread(Thread thread) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ThreadMapper.class).insertThread(thread);			
		} finally {
			sqlSession.close();
		}
	}

	public int updateThread(Thread thread) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ThreadMapper.class).updateThread(thread);			
		} finally {
			sqlSession.close();
		}
	}

	public int deleteThread(int threadNumber) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(ThreadMapper.class).deleteThread(threadNumber);			
		} finally {
			sqlSession.close();
		}
	}
	
	
}
