package model.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Comment;
import model.dao.mybatis.mapper.CommentMapper;

public class CommentDao {
	private SqlSessionFactory sqlSessionFactory;

	public CommentDao() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public List<Comment> findCommentByTaskId(int taskId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).selectCommentByTaskId(taskId);			
		} finally {
			sqlSession.close();
		}
	}
	
	public int insertComment(Comment comment) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).insertComment(comment);			
		} finally {
			sqlSession.close();
		}
	}

	public int updateComment(Comment comment) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).updateComment(comment);			
		} finally {
			sqlSession.close();
		}
	}

	public int deleteComment(int commentId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).deleteComment(commentId);			
		} finally {
			sqlSession.close();
		}
	}
	
	
}
