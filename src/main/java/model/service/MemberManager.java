package model.service;

import model.Member;
import model.dao.jdbc.MemberDao;

public class MemberManager {
	private static MemberManager memberManager = new MemberManager();
	private MemberDao memberDAO;
	
	private MemberManager() {
		try {
			memberDAO = new MemberDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberManager getInstance() {
		return memberManager;
	}
	
	public Member getMember(int member_id) {
		return memberDAO.findMember(member_id);
	}

}
