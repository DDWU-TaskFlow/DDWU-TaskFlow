package model.dao.jdbc;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import model.Member;
import model.Participation;
import model.dao.jdbc.JDBCUtil;

public class ProjectDao {

    private JDBCUtil jdbcUtil = null;    // JDBCUtil 객체를 참조하기 위한 변수
    
    public ProjectDao() {           
        jdbcUtil = new JDBCUtil();    
    }        
    
    public int insertProject(Project pro) {
        int result = 0;
        String insertQuery = "INSERT INTO PROJECT (PROJECT_ID, NAME, TYPE, CREATIONDATE, CREATEDLINK, NOTICE) " +
                "VALUES (SEQUENCE_PROJECT.nextval, ?, ?, to_date(SYSDATE, 'YYYY-MM-DD HH24:mi:SS'), ?, ?) ";
        Object[] param = new Object[] { pro.getName(), pro.getType(), pro.getCreatedLink(), pro.getNotice() };        
        
        jdbcUtil.setSqlAndParameters(insertQuery, param);
        
        try {               
            result = jdbcUtil.executeUpdate();      // insert 문 실행
            System.out.println(pro.getProject_id() + " 번의 프로젝트 정보가 삽입되었습니다.");
        } catch (SQLException ex) {
            System.out.println("입력오류 발생!!!");
            if (ex.getErrorCode() == 1)
                System.out.println("동일한 프로젝트 정보가 이미 존재합니다."); 
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();     
        }       
        return result;      // insert 에 의해 반영된 레코드 수 반환 
    }

//    public int updateProject(Project pro) {
//    	
//    }
    
    public int participateInProject(Project pro, Member mem) {
        int result = 0;
        String insertQuery = "INSERT INTO PARTICIPATION (PROJECT_ID, MEMBER_ID) " +
                "VALUES (?, ?) ";
        Object[] param = new Object[] {pro.getProject_id(), mem.getMember_id()};
                
        jdbcUtil.setSqlAndParameters(insertQuery, param);
        try {               
            result = jdbcUtil.executeUpdate();      // insert 문 실행
            System.out.println(pro.getProject_id() + " 번의 프로젝트 정보가 삽입되었습니다.");
        } catch (SQLException ex) {
            System.out.println("입력오류 발생!!!");
            if (ex.getErrorCode() == 1)
                System.out.println("동일한 프로젝트 정보가 이미 존재합니다."); 
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();     
        }       
        return result;      // insert 에 의해 반영된 레코드 수 반환 
    }
    
    public int deleteProject(int project_id) {
        String deleteQuery = "DELETE FROM PROJECT WHERE PROJECT_ID = ?";
        
        Object[] param = new Object[] {project_id};
        jdbcUtil.setSqlAndParameters(deleteQuery, param);          
        
        try {
            int result = jdbcUtil.executeUpdate();      // delete 문 실행
            return result;                      // delete 에 의해 반영된 레코드 수 반환
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();       
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();     
        }
        return 0;
    }
    
//    public Participation outProject() {
//    	
//    }
    
    public List<Project> getProjectList() {
        String allQuery = "SELECT PROJECT_ID, NAME, TYPE, CREATIONDATE, CREATEDLINK, NOTICE FROM PROJECT";
        jdbcUtil.setSqlAndParameters(allQuery, null);
                
        try { 
            ResultSet rs = jdbcUtil.executeQuery();     // query 문 실행               
            List<Project> list = new ArrayList<Project>();     
            
            while (rs.next()) { 
                Project dto = new Project();     
                dto.setProject_id(rs.getInt("PROJECT_ID"));
                dto.setName(rs.getString("NAME"));
                dto.setType(rs.getInt("TYPE"));
                dto.setCreationDate(rs.getDate("CREATIONDATE"));
                dto.setCreatedLink(rs.getString("CREATEDLINK"));
                dto.setNotice(rs.getString("NOTICE"));
                list.add(dto);      
            }
            return list;       
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); 
        }       
        return null;    
    }
    
    public Project findProject(int project_id) {
    	String sql = "SELECT * FROM PROJECT WHERE PROJECT_ID = ?";
        Object[] param = new Object[] {project_id};
        jdbcUtil.setSqlAndParameters(sql, param); 
        
        Project project = null;
        
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				project = new Project(		// Community 객체를 생성하여 커뮤니티 정보를 저장
					project_id,
					rs.getString("name"),
					rs.getInt("type"),
					rs.getDate("creationdate"),
					rs.getString("createdlink"),
					rs.getString("notice"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		
		return project;
    }
    
    public List<Project> findProjectsInMember(int member_id) {
    	String query = "SELECT PROJECT.project_id AS project_id, PROJECT.name AS name, PROJECT.type AS type, PROJECT.creationDate AS creationDate, PROJECT.createdlink AS createdLink, PROJECT.notice AS notice "
    			+ "FROM MEMBER LEFT JOIN PARTICIPATION ON MEMBER.member_id = PARTICIPATION.member_id JOIN PROJECT ON PROJECT.project_id = PARTICIPATION.project_id "
    			+ "WHERE MEMBER.member_id = ?";
    	
        Object[] param = new Object[] {member_id};
        jdbcUtil.setSqlAndParameters(query, param);
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();      // query문 실행
            List<Project> list = new ArrayList<Project>(); 
            
            while(rs.next()) {
            	Project dto = new Project();
            	dto.setName(rs.getString("name"));
            	dto.setType(rs.getInt("type"));
            	dto.setCreationDate(rs.getDate("creationDate"));
            	dto.setCreatedLink(rs.getString("createdLink"));
            	dto.setNotice(rs.getString("notice"));
                list.add(dto);
            }
            return list;          
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();       
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();     
        }
        return null;
    }
    
    public List<Member> findMembersInProject(int projectId) throws SQLException {
        String query = "SELECT MEMBER.member_id AS member_id, MEMBER.password AS password, MEMBER.name AS name, MEMBER.email AS email, MEMBER.phone AS phone, MEMBER.birth AS birth "
                + "FROM MEMBER LEFT JOIN PARTICIPATION ON MEMBER.member_id = PARTICIPATION.member_id JOIN PROJECT ON PROJECT.project_id = PARTICIPATION.project_id "
                + "WHERE PROJECT.project_id = ?";
        Object[] param = new Object[] {projectId};
        jdbcUtil.setSqlAndParameters(query, param);
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();      // query문 실행
            List<Member> list = new ArrayList<Member>(); 
            
            while(rs.next()) {
                Member dto = new Member();
                
                dto.setMember_id(rs.getInt("member_id"));
                dto.setPassword(rs.getString("password"));
                dto.setName(rs.getString("name"));
                dto.setEmail(rs.getString("email"));
                dto.setPhone(rs.getString("phone"));
                dto.setBirth(rs.getString("birth"));

                list.add(dto);
            }
            return list;          
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();       
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();     
        }
        return null;
    }
    
}

