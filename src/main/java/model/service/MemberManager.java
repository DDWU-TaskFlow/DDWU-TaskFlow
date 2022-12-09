package model.service;

import java.sql.SQLException;

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
	
	public int create(Member member) throws SQLException, ExistingUserException {
		if (memberDAO.existingUser(member.getUser_name()) == true) {
			throw new ExistingUserException(member.getUser_name() + "는 존재하는 아이디입니다.");
		}
		return memberDAO.insertMember(member);
	}
	
	public int update(Member member) throws SQLException {
		return memberDAO.updateMember(member);
	}
	
	public int delete(int member_id) throws SQLException {
		return memberDAO.deleteMember(member_id);
	}

	/*public int update(Member user) throws SQLException, MemberNotFoundException {
		int oldCommId = findUser(user.getUser_name()).getCommId();
		if (user.getCommId() != oldCommId) { 	// 소속 커뮤티니가 변경됨
			Community comm = commDAO.findCommunity(oldCommId);  // 기존 소속 커뮤니티
			if (comm != null && user.getUserId().equals(comm.getChairId())) {
				// 사용자가 기존 소속 커뮤니티의 회장인 경우 -> 그 커뮤니티의 회장을 null로 변경 및 저장
				comm.setChairId(null);
				commDAO.updateChair(comm);
			}
		}
		return userDAO.update(user);
	}	

	public int remove(String userId) throws SQLException, UserNotFoundException {
		int commId = findUser(userId).getCommId();
		Community comm = commDAO.findCommunity(commId);  // 소속 커뮤니티
		if (comm != null && userId.equals(comm.getChairId())) {
			// 사용자가 소속 커뮤니티의 회장인 경우 -> 그 커뮤니티의 회장을 null로 변경 및 저장
			comm.setChairId(null);
			commDAO.updateChair(comm);
		}
		return userDAO.remove(userId);
	}*/
	
	
	//index로 받아오는 방법.
	public Member getMember(int member_id) {
		return memberDAO.findMember(member_id);
	}
	
	//사용자 아이디로 받아오는 방법.
 	public Member getMember(String userName) {
		return memberDAO.findMember(userName);
	}
 	
 	//사용자 이름으로 받아오는 방법.
 	public Member getMemberByName(String name) {
		return memberDAO.findMemberByName(name);
	}
	
	public boolean login(String userName, String password)throws SQLException, MemberNotFoundException, PasswordMismatchException {
		Member member = getMember(userName);
		if(member == null) {
			throw new MemberNotFoundException("없는 회원입니다.");
		} else if (!member.matchPassword(password)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		return true;
	}

}
