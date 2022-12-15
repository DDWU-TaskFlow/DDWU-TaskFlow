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

	public Comment findCommentByCommentId(int commentId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).selectCommentByCommentId(commentId);			
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> findCommentByTaskId(int taskId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).selectCommentByTaskId(taskId);			
		} finally {
			sqlSession.close();
		}
	}
	
	public String findMemberNameByCommentId(int commentId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).selectMemberNameByCommentId(commentId);			
		} finally {
			sqlSession.close();
		}
	}
	
	public int insertComment(Comment comment) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommentMapper.class).insertComment(comment);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public int updateComment(Comment comment) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommentMapper.class).updateComment(comment);	
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
			int result = sqlSession.getMapper(CommentMapper.class).deleteComment(commentId);		
			if (result > 0) {
				sqlSession.commit();
			}
			return result;	
		} finally {
			sqlSession.close();
		}
	}
	
}
