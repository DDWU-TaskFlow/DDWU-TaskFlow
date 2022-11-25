package model.dao;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import model.Member;
import model.dao.JDBCUtil;

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
    
    /*public List<MemberDTO> findMembersInProject(int projectId) throws SQLException {
        //        String query = "SELECT member_id, password, name, email, phone, brith "
        //                + "FROM MEMBER, PARTICIPATION USING (member_id) "
        //                + "WHERE projectId = ? ";

        //        String query = "SELECT member_id, password, name, email, phone, brith "
        //                + " from participation mp"
        //                + " inner join member m on mp.member_id=m.member_id"
        //                + " where mp.project_id=" + rs.getInt("project_id");

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@dblab.dongduk.ac.kr:1521:orcl", "dbpr0202", "1017");
        List<MemberDTO> memberList = null;
        PreparedStatement stmt = con.prepareStatement(
                "select p.no, p.title, p.sdt, p.edt, m.name owner_name"
                    + " from pms_project p inner join pms_member m on p.owner=m.no"
                    + " order by p.no desc");
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                StringBuilder members = new StringBuilder();

                while (rs.next()) {
                    try (PreparedStatement stmt2 = con.prepareStatement(
                            "SELECT member_id, password, name, email, phone, brith "
                                    + " from participation mp"
                                    + " inner join member m on mp.member_id=m.member_id"
                                    + " where mp.project_id=" + rs.getInt("project_id"));
                            ResultSet memberRs = stmt2.executeQuery()) {
                        while (memberRs.next()) { 
                            MemberDTO dto = new MemberDTO();

                            dto.setMember_id(rs.getInt("member_id"));
                            dto.setPassword(rs.getString("password"));
                            dto.setName(rs.getString("name"));
                            dto.setEmail(rs.getString("email"));
                            dto.setPhone(rs.getString("phone"));
                            dto.setBirth(rs.getString("birth"));

                            memberList.add(dto); 
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    } finally {
                        jdbcUtil.close(); 
                    }       
                    return memberList;         
                }
            }
        } catch (Exception e) {
            System.out.println("프로젝트 조회 중 오류 발생!");
            e.printStackTrace();
        } finally {
            jdbcUtil.close(); 
        }       
        return memberList;  
    }*/
}

