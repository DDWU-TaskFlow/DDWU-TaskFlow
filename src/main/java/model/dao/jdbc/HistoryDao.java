package model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Progress;
import model.dao.jdbc.JDBCUtil;

public class HistoryDao {
    private JDBCUtil jdbcUtil = null;    // JDBCUtil 객체를 참조하기 위한 변수
    
    public HistoryDao() {   // 생성자        
        jdbcUtil = new JDBCUtil();      // JDBCUtil 객체 생성
    }
    
    public int insertProgress(int taskId, int progress) {
    	int result = 0;
    	String insertQuery = "INSERT INTO PROGRESS (progress_id, progress, task_id, recordedDate) " +
                				"VALUES (SEQUENCE_PROGRESS.nextval, ?, ?, to_date(SYSDATE, 'YYYY-MM-DD HH24:mi:SS')) ";
    	
    	Object[] param = new Object[] {progress, taskId};
    	
        jdbcUtil.setSqlAndParameters(insertQuery, param);
        
        System.out.println("쿼리 생성 완료");
    	
        try {               
            result = jdbcUtil.executeUpdate();     // insert 문 실행
            System.out.println(taskId + "번 태스크의 진행률 변경이 progress에 추가 되었습니다.");
        } catch (SQLException ex) {
            System.out.println("프로그래스 삽입 실패!!!");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();     
        }      
        
        System.out.println("insert 결과: " + result);
        return result;      // insert 에 의해 반영된 레코드 수 반환 
    }
    
    public List<Progress> getProgressList(int taskId) {
    	String allQuery = "SELECT * FROM PROGRESS "
    					+ "WHERE TASK_ID = ? ";
    	Object[] param = new Object[] {taskId};
    	
        jdbcUtil.setSqlAndParameters(allQuery, param);
        
        try { 
            ResultSet rs = jdbcUtil.executeQuery();     // query 문 실행               
            List<Progress> list = new ArrayList<Progress>();     
            
            while (rs.next()) { 
                  Progress progress = new Progress();
                  progress.setProgressId(rs.getInt("PROGRESS_ID"));
                  progress.setProgress(rs.getInt("PROGRESS"));
                  progress.setTaskId(rs.getInt("TASK_ID"));
                  progress.setRecordeDate(rs.getDate("RECORDEDDATE"));
                  list.add(progress);
            }
            return list;      
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); 
        }       
        return null;    
    }
}




