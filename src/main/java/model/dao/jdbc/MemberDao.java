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
	
	public int updateMember(Member mem) {
		int result = 0;
		
		String updateQuery = "UPDATE MEMBER SET ";
		
		Object[] param = new Object[10];
		int index = 0;

		// 새로운 비밀번호가 설정됐을 경우
		if(mem.getPassword() != null) {
			updateQuery += "password = ?, ";
			param[index++] = mem.getPassword();
		}
		// 새로운 닉네임이 설정됐을 경우
		if(mem.getName() != null) {
			updateQuery += "name = ?, ";
			param[index++] = mem.getName();
		}
		// 새로운 이메일이 설정됐을 경우
		if(mem.getEmail() != null) {
			updateQuery += "email = ?, ";
			param[index++] = mem.getEmail();
		}
		// 새로운 전화번호가 설정됐을 경우
		if(mem.getPhone() != null) {
			updateQuery += "phone = ?, ";
			param[index++] = mem.getPhone();
		}
		// 새로운 생일이 설정됐을 경우
		if(mem.getBirth() != null) {
			updateQuery += "birth = ?, ";
			param[index++] = mem.getBirth();
		}
		// update문에 조건 지정
		updateQuery += "WHERE user_name = ? ";
		updateQuery = updateQuery.replace(", WHERE", " WHERE");
		
		param[index++] = mem.getUser_name();
		
		Object[] newParam = new Object[index];
		for(int i = 0; i < newParam.length; i++) {
			newParam[i] = param[i];
		}
		
		jdbcUtil.setSqlAndParameters(updateQuery, newParam);

		try {               
			result = jdbcUtil.executeUpdate();      // update 문 실행
			System.out.println(mem.getUser_name() + " 님의 회원정보가 수정되었습니다.");
		} catch (Exception ex) {
			System.out.println("회원정보 수정에서 오류 발생!!!");
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {     
			jdbcUtil.commit();
			jdbcUtil.close();     
		}       
		return result;      // update 에 의해 반영된 레코드 수 반환 
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
