package model.dao.test;

import java.util.List;

import model.Comment;
import model.dao.mybatis.CommentDao;

class CommentDaoMybatisTest {
	private static CommentDao commentDao = new CommentDao();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("CommentDaoMybatisTest");
		
		int testId = 1007;
		List<Comment> cmtList = commentDao.findCommentByTaskId(testId);
		System.out.println("taskId=" + testId + "의 코멘트: " + cmtList);
	}

}
