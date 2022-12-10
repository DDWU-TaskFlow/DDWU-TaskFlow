package model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.History;

public class HistoryDao {
    private JDBCUtil jdbcUtil = null;    // JDBCUtil 객체를 참조하기 위한 변수
    
    public HistoryDao() {   // 생성자        
        jdbcUtil = new JDBCUtil();      // JDBCUtil 객체 생성
    }
    
    public int insertHistory(int projectId, int memberId, String content) {
    	int result = 0;
    	String insertQuery = "INSERT INTO History (history_id, project_id, member_id, content, recordedDate) " +
                				"VALUES (SEQUENCE_HISTORY.nextval, ?, ?, ?, SYSDATE) ";
    	
    	Object[] param = new Object[] { projectId, memberId, content };
        jdbcUtil.setSqlAndParameters(insertQuery, param);
    	
        try {               
            result = jdbcUtil.executeUpdate();     // insert 문 실행
        } catch (SQLException ex) {
            System.out.println("히스토리 삽입 실패!!!");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();
        }      
        
        return result;
    }
    
    public int deleteHistoryByProjectId(int projectId) {
    	int result = 0;
    	String query = "DELETE FROM History "
    				+ "WHERE project_id = ? ";
    	
    	Object[] param = new Object[] { projectId };
        jdbcUtil.setSqlAndParameters(query, param);
    	
        try {               
            result = jdbcUtil.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();
        }      
        
        return result;
    }
    
    public List<History> findHistoryByProjectId(int projectId) {
    	String query = "SELECT * "
    					+ "FROM History "
    					+ "WHERE project_id = ? "
    					+ "ORDER BY recordedDate DESC";
    	
    	Object[] param = new Object[] { projectId };
        jdbcUtil.setSqlAndParameters(query, param);
        
        try { 
            ResultSet rs = jdbcUtil.executeQuery();     // query 문 실행               
            List<History> list = new ArrayList<History>();     
            
            while (rs.next()) { 
            	  History history = new History();
            	  history.setProjectId(projectId);
            	  history.setHistoryId(rs.getInt("history_id"));
            	  history.setMemberId(rs.getInt("member_id"));
            	  history.setContent(rs.getString("content"));
            	  history.setRecordedDate(rs.getTimestamp("recordedDate"));
                  list.add(history);
            }
            return list;      
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); 
        }       
        return null;    
    }
    
    public List<History> findHistoryByMemberId(int projectId, int memberId) {
    	String query = "SELECT * "
    					+ "FROM History "
    					+ "WHERE project_id = ? AND member_id = ? "
    					+ "ORDER BY recordedDate DESC";
    	
    	Object[] param = new Object[] { projectId, memberId };
        jdbcUtil.setSqlAndParameters(query, param);
        
        try { 
            ResultSet rs = jdbcUtil.executeQuery();     // query 문 실행               
            List<History> list = new ArrayList<History>();     
            
            while (rs.next()) { 
            	  History history = new History();
            	  history.setProjectId(projectId);
            	  history.setHistoryId(rs.getInt("history_id"));
            	  history.setMemberId(memberId);
            	  history.setContent(rs.getString("content"));
            	  history.setRecordedDate(rs.getTimestamp("recordedDate"));
                  list.add(history);
            }
            return list;      
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); 
        }       
        return null;    
    }
    
    public String findMemberNameByHistoryId(int historyId) {
		String query = "SELECT MEMBER.name AS mName "
				+ "FROM HISTORY JOIN MEMBER USING (member_id) "
				+ "WHERE history_id = ? ";
		
		jdbcUtil.setSqlAndParameters(query, new Object[] {historyId});
		String memberName = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			
			if (rs.next()) {		
				memberName = rs.getString("mName");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();	
		}
		return memberName;
	}
    
}




