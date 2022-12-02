package model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;
import model.dao.jdbc.JDBCUtil;

public class MemberDao {

	private JDBCUtil jdbcUtil = null;    // JDBCUtil 객체를 참조하기 위한 변수

	public MemberDao() {   // 생성자        
		jdbcUtil = new JDBCUtil();      // JDBCUtil 객체 생성
	}

	public int insertMember(Member mem) {
		int result = 0;
		String insertQuery = "INSERT INTO MEMBER (member_id, user_name, password, name, email, phone, birth) " +
				"VALUES (SEQUENCE_MEMBER.nextval, ?, ?, ?, ?, ?, ?) ";

		Object[] param = new Object[] {mem.getUser_name(), mem.getPassword(), mem.getName(), mem.getEmail(), mem.getPhone(), mem.getBirth()};

		jdbcUtil.setSqlAndParameters(insertQuery, param);

		try {               
			result = jdbcUtil.executeUpdate();      // insert 문 실행
			System.out.println(mem.getUser_name() + " 님이 가입하셨습니다.");
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
	
	public Member findMember(int member_id) {
		String sql = "SELECT * "
				+ "FROM MEMBER "
				+ "WHERE member_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {member_id});	// JDBCUtil에 query문과 매개 변수 설정
		Member mem = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				mem = new Member(		// Community 객체를 생성하여 커뮤니티 정보를 저장
						member_id,
						rs.getString("user_name"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("birth"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return mem;
	}

	public Member findMember(String user_name) {
		String sql = "SELECT * "
				+ "FROM MEMBER "
				+ "WHERE user_name=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_name});	
		Member mem = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			if (rs.next()) {						
				mem = new Member(	
						user_name,
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("birth"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();	
		}
		return mem;
	}
	
	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingUser(String user_name) throws SQLException {
		String sql = "SELECT count(*) FROM MEMBER WHERE user_name=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_name});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}

}
