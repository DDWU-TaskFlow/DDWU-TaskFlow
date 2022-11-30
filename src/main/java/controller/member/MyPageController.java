package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.service.MemberManager;

public class MyPageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberManager manager = MemberManager.getInstance();
		Member member = manager.getMember(-1);
		
		request.setAttribute("member", member);
		return "/member/myPage.jsp";
	}

}
