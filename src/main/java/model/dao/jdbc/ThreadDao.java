package model.dao.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Thread;
import model.dao.jdbc.JDBCUtil;

public class ThreadDao {
	
	private JDBCUtil jdbcUtil = null;
	
	public ThreadDao() {
		
	    jdbcUtil = new JDBCUtil();
		
	}
	
	public int insertThread(Thread thread) {
		String insertQuery = "INSERT INTO THREAD (thread_number, writtendate, content, task_id, member_id) "
				+ "VALUES (SEQUENCE_THREAD.nextval, to_date(SYSDATE, 'YYYY-MM-DD HH24:mi:SS'), ?, ?, ?)";

		int result = 0;
		Object[] params = new Object[] { thread.getContent(), thread.getTask_id(), thread.getMember_id() };
		jdbcUtil.setSqlAndParameters(insertQuery,  params);
		
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
	
	public int updateThread(Thread thread) {
		String updateQuery = "UPDATE THREAD SET writtendate = to_date(SYSDATE, 'YYYY-MM-DD HH24:mi:SS') , content = ? "
					+ "WHERE thread_number = ? ";

        int result = 0;
		Object[] params = new Object[] { thread.getContent(), thread.getThread_number() };
		jdbcUtil.setSqlAndParameters(updateQuery,  params);
		
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
	
	public int deleteThread(int threadId) {
		String deleteQuery = "DELETE FROM THREAD "
				+ "WHERE thread_number = ? ";
		
		int result = 0;
		Object[] params = new Object[] { threadId };
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
	
	public List<Thread> getThreadList(int taskId) {
		String query = "SELECT thread_number, writtendate, content, task_id, THREAD.member_id "
				+ "FROM THREAD JOIN TASK USING (task_id) "
				+ "WHERE task_id = ? ";
	
		List<Thread> threadList = new ArrayList<Thread>();
		Object[] params = new Object[] { taskId };
		jdbcUtil.setSqlAndParameters(query, params);
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();
			
			while (rs.next()) {
				int threadNumber = rs.getInt("thread_number");
				String writtenDate = rs.getString("writtendate");
				String content = rs.getString("content");
				int memberId = rs.getInt("member_id");

				threadList.add(new Thread(threadNumber, writtenDate, content, taskId, memberId));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		
    	return threadList;
	}
	
}
