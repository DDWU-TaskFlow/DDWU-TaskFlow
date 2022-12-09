package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Member;
import model.service.MemberManager;

public class DeleteMemberController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberManager memberManager = MemberManager.getInstance();
		
		String user_name = request.getParameter("user_name");
		Member member = memberManager.getMember(user_name);
		
		System.out.println("회원탈퇴할 아이디는 " + user_name);
		
		int memberId = member.getMember_id();
		
		System.out.println("탈퇴할 멤버의 아이디는 " + memberId);
		memberManager.delete(memberId);
		
		// 탈퇴 했으니 세션 해제 필수!
		HttpSession session = request.getSession();
		session.invalidate();	
		
		return "redirect:/project/list";
	}
}
