package model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;
import model.dao.jdbc.JDBCUtil;

public class TaskDao {
	
	private JDBCUtil jdbcUtil = null;
	
	public TaskDao() {
		
	    jdbcUtil = new JDBCUtil();
		
	}

	public int insertTask(Task task) {
		String insertQuery = "INSERT INTO TASK (task_id, taskProgress, project_id, member_id, name, deadline) "
				+ "VALUES (SEQUENCE_TASK.nextval, ?, ?, ?, ?, ?)";

		int result = 0;
		Object[] params = new Object[] { 0, task.getProject_id(), task.getMember_id(), task.getName(), task.getDeadline() };
		jdbcUtil.setSqlAndParameters(insertQuery,  params);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
            System.out.println("태스크 삽입에서 오류 발생!!!");
            jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}

		return result;
	}

	public int deleteTask(int taskId) {
		String deleteQuery = "DELETE FROM TASK "
				+ "WHERE task_id = ? ";
		
		int result = 0;
		Object[] params = new Object[] { taskId };
		jdbcUtil.setSqlAndParameters(deleteQuery, params);

		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
            System.out.println("태스크 삭제에서 오류 발생!!!");
            jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return result;
	}

	public int updateTask(Task task) {
		String updateQuery = "UPDATE TASK SET taskProgress = ? , name = ? , deadline = ? "
					+ "WHERE task_id = ? ";

        int result = 0;
		Object[] params = new Object[] { task.getTaskProgress(), task.getName(), task.getDeadline(), task.getTask_id() };
		jdbcUtil.setSqlAndParameters(updateQuery,  params);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
            System.out.println("태스크 수정에서 오류 발생!!!");
            jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return result;
    }
	
	// project별로 Task 출력
	public List<Task> getTaskList(int projectId) {
		String query = "SELECT TASK.task_id, taskProgress, project_id, member_id, TASK.name, deadline "
				+ "FROM TASK JOIN PROJECT USING (project_id) "
				+ "WHERE project_id = ? ";
//				+ "GROUP BY member_id";
	
		List<Task> taskList = new ArrayList<Task>();
		Object[] params = new Object[] { projectId };
		jdbcUtil.setSqlAndParameters(query, params);
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();
			
			while (rs.next()) {
				int taskId = rs.getInt("task_id");
				int taskProgress = rs.getInt("taskProgress");
				int member_id = rs.getInt("member_id");
				String name = rs.getString("name");
				String deadline = rs.getString("deadline");

				taskList.add(new Task(taskId, taskProgress, projectId, member_id, name, deadline));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		
    	return taskList;
	}
	
	// 멤버별 task 출력, overloading
	public List<Task> getTaskList(int projectId, int memberId) {
		String query = "SELECT TASK.task_id, taskProgress, project_id, member_id, TASK.name, deadline "
				+ "FROM TASK JOIN PROJECT USING (project_id) "
				+ "WHERE project_id = ? AND member_id = ? ";
	
		List<Task> taskList = new ArrayList<Task>();
		Object[] params = new Object[] { projectId, memberId };
		jdbcUtil.setSqlAndParameters(query, params);
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();
			
			while (rs.next()) {
				int taskId = rs.getInt("task_id");
				int taskProgress = rs.getInt("taskProgress");
				String name = rs.getString("name");
				String deadline = rs.getString("deadline");

				taskList.add(new Task(taskId, taskProgress, projectId, memberId, name, deadline));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		
    	return taskList;
	}
	
}

