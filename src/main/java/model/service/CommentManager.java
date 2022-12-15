package model.service;

import java.util.ArrayList;
import java.util.List;

import model.Comment;
import model.dao.mybatis.CommentDao;

public class CommentManager {
	private static CommentManager commentManager = new CommentManager();
//	private CommentDao commentDao;
	private CommentDao commentDao;
	
	private CommentManager() {
		try {
			commentDao = new CommentDao();
			System.out.println("commentDAO 생성 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static CommentManager getInstance() {
		return commentManager;
	}

	public Comment findCommentByCommentId(int commentId) {
		Comment comment = new Comment();
		comment = commentDao.findCommentByCommentId(commentId);
		return comment;
	}
	
	public List<Comment> findCommentByTaskId(int taskId) {
		List<Comment> commentList = new ArrayList<Comment>();
		commentList = commentDao.findCommentByTaskId(taskId);
		return commentList;
	}
	
	public String findMemberNameByCommentId(int commentId) {
		String memberName = commentDao.findMemberNameByCommentId(commentId);
		return memberName;
	}
	
	public int insertComment(Comment comment) {
		return commentDao.insertComment(comment);
	}
	
//	public int UpdateComment(Comment comment) {
//		return commentDao.updateComment(comment);
//	}
	
	public int deleteComment(int commentId) {
		return commentDao.deleteComment(commentId);
	}
	
	
}
