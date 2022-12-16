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

		
		Comment comment = new Comment();comment.setMemberId(10001);
		comment.setTaskId(1001); comment.setContent("댓글 테스트");
		System.out.println(commentDao.insertComment(comment));
		

		/* System.out.println(commentDao.deleteComment(1000007)); */

	}

}
