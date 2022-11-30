package model.dao.test;

import model.dao.jdbc.MemberDao;

public class MemberDaoTest {
	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		
		// insert 테스트
//		memberDao.insertMember(new Member());
		
		// findMember 테스트
		System.out.println(memberDao.findMember(-1));
	}
}
