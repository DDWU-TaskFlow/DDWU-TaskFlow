package model.dao.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Comments;
import model.dao.jdbc.JDBCUtil;

public class CommentsDao {
	
	private JDBCUtil jdbcUtil = null;
	
	public CommentsDao() {
		
	    jdbcUtil = new JDBCUtil();
		
	}
	
	public int insertComment(Comments comment) {
		String insertQuery = "INSERT INTO Comments (comment_id, task_id, member_id, writtenDate, content) "
				+ "VALUES (SEQUENCE_Comments.nextval, ?, ?, to_date(SYSDATE, 'YYYY-MM-DD HH24:mi:SS'), ?)";

		int result = 0;
		Object[] params = new Object[] {comment.getTask_id(), comment.getMember_id(), comment.getContent()};
		jdbcUtil.setSqlAndParameters(insertQuery, params);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
            System.out.println("스레드 삽입에서 오류 발생!!!");
            jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}

		return result;
	}
	
	public int updateComment(Comments comment) {
		String updateQuery = "UPDATE Comments "
				+ "SET writtenDate = to_date(SYSDATE, 'YYYY-MM-DD HH24:mi:SS') , content = ? "
				+ "WHERE comment_id = ? ";

        int result = 0;
		Object[] params = new Object[] { comment.getContent(), comment.getComment_id() };
		jdbcUtil.setSqlAndParameters(updateQuery, params);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
            System.out.println("스레드 수정에서 오류 발생!!!");
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
            System.out.println("스레드 삭제에서 오류 발생!!!");
            jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return result;
	}
	
	public List<Comments> getCommentList(int taskId) {
		String query = "SELECT comment_id, task_id, Comments.member_id AS member_id, writtenDate, content "
				+ "FROM Comments JOIN TASK USING (task_id) "
				+ "WHERE task_id = ? ";
	
		List<Comments> commentList = new ArrayList<Comments>();
		Object[] params = new Object[] { taskId };
		jdbcUtil.setSqlAndParameters(query, params);
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();
			
			while (rs.next()) {
				int comment_id = rs.getInt("comment_id");
				int member_id = rs.getInt("member_id");
				Date writtenDate = rs.getDate("writtenDate");
				String content = rs.getString("content");
				commentList.add(new Comments(comment_id, taskId, member_id, writtenDate, content));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		
    	return commentList;
	}
	
}
