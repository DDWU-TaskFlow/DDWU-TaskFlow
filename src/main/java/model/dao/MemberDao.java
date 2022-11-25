package model.dao;

import java.sql.SQLException;

import model.Member;
import model.dao.JDBCUtil;

public class MemberDao {
    
    private JDBCUtil jdbcUtil = null;    // JDBCUtil 객체를 참조하기 위한 변수
    
    public MemberDao() {   // 생성자        
        jdbcUtil = new JDBCUtil();      // JDBCUtil 객체 생성
    }

    public int insertMember(Member mem) {
        int result = 0;
        String insertQuery = "INSERT INTO MEMBER (member_id, password, name, email, phone, birth) " +
                             "VALUES (?, ?, ?, ?, ?, ?) ";
        
        Object[] param = new Object[] {mem.getMember_id(), mem.getPassword(), mem.getName(), mem.getEmail(), mem.getPhone(), mem.getBirth()};
 
        jdbcUtil.setSqlAndParameters(insertQuery, param);
        
        try {               
            result = jdbcUtil.executeUpdate();      // insert 문 실행
            System.out.println(mem.getMember_id() + " 님이 가입하셨습니다.");
        } catch (SQLException ex) {
            System.out.println("사용자 추가에서 입력오류 발생!!!");
            if (ex.getErrorCode() == 1)
                System.out.println("동일한 사용자 정보가 이미 존재합니다."); 
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();     
        }       
        return result;      // insert 에 의해 반영된 레코드 수 반환 
    }
       
    public int deleteMember(int member_id) {
        String deleteQuery = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
        
        Object[] param = new Object[] {member_id};
        jdbcUtil.setSqlAndParameters(deleteQuery, param);
        
        try {
            int result = jdbcUtil.executeUpdate();      // delete 문 실행
            return result;                      // delete 에 의해 반영된 레코드 수 반환
        } catch (Exception ex) {
            System.out.println("사용자 삭제에서 오류 발생!!!");
            jdbcUtil.rollback();
            ex.printStackTrace();       
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();     
        }
        return 0;
    }
}
