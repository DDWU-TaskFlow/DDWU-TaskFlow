package model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Comment;

public class CommentDao {
	
	private JDBCUtil jdbcUtil = null;
	
	public CommentDao() {
		
	    jdbcUtil = new JDBCUtil();
		
	}
	
	public int insertComment(Comment comment) {
		String insertQuery = "INSERT INTO Comments (comment_id, task_id, member_id, writtenDate, content) "
				+ "VALUES (SEQUENCE_Comments.nextval, ?, ?, SYSDATE, ?)";

		int result = 0;
		Object[] params = new Object[] {comment.getTask_id(), comment.getMemberId(), comment.getContent()};
		jdbcUtil.setSqlAndParameters(insertQuery, params);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
            System.out.println("코멘트 삽입에서 오류 발생!!!");
            jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}

		return result;
	}
	
	public int updateComment(Comment comment) {
		String updateQuery = "UPDATE Comments "
				+ "SET writtenDate = SYSDATE , content = ? "
				+ "WHERE comment_id = ? ";

        int result = 0;
		Object[] params = new Object[] { comment.getContent(), comment.getCommentId() };
		jdbcUtil.setSqlAndParameters(updateQuery, params);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
            System.out.println("코멘트 수정에서 오류 발생!!!");
            jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return result;
    }
	
	public int deleteComment(int commentId) {
		String deleteQuery = "DELETE FROM Comments "
				+ "WHERE comment_id = ? ";
		
		int result = 0;
		Object[] params = new Object[] { commentId };
		jdbcUtil.setSqlAndParameters(deleteQuery, params);

		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
            System.out.println("코멘트 삭제에서 오류 발생!!!");
            jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return result;
	}
	
	public List<Comment> getCommentList(int taskId) {
		String query = "SELECT comment_id, task_id, Comments.member_id AS member_id, writtenDate, content "
				+ "FROM Comments JOIN TASK USING (task_id) "
				+ "WHERE task_id = ? ";
	
		List<Comment> commentList = new ArrayList<Comment>();
		Object[] params = new Object[] { taskId };
		jdbcUtil.setSqlAndParameters(query, params);
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();
			
			while (rs.next()) {
				int commentId = rs.getInt("commentId");
				int memberId = rs.getInt("member_id");
				Timestamp writtenDate = rs.getTimestamp("writtenDate");
				String content = rs.getString("content");
				commentList.add(new Comment(commentId, taskId, memberId, writtenDate, content));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		
    	return commentList;
	}
	
}
