package model.dao.mybatis;

import java.io.*;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import model.Comment;
import model.dao.mybatis.mapper.CommentMapper;

public class CommentSessionDao {
	private final String namespace = "model.dao.mybatis.mapper.CommentMapper";

	private SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();
	
	private SqlSessionFactory createSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public Comment findCommentByCommentId(int commentId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne(namespace + ".selectCommentByCommentId", commentId);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> findCommentByTaskId(int taskId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList(namespace + ".selectCommentByTaskId", taskId);
		} finally {
			sqlSession.close();
		}
	}
	
	public String findMemberNameByCommentId(int commentId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne(namespace + ".selectMemberNameByCommentId", commentId);
		} finally {
			sqlSession.close();
		}
	}

	public int insertComment(Comment comment) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.insert(namespace + ".insertComment", comment);
			if (result > 0) {
				sqlSession.commit();
			} 			
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public int deleteComment(int commentId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.insert(namespace + ".deleteComment", commentId);
			if (result > 0) {
				sqlSession.commit();
			} 			
			return result;
		} finally {
			sqlSession.close();
		}
	}

}
