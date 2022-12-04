package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.dao.jdbc.MemberDao;
import model.service.MemberManager;

public class MyPageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberManager manager = MemberManager.getInstance();
		
		String user_name = request.getParameter("user_name");
		Member member = manager.getMember(user_name);
		
		request.setAttribute("member", member);
		
		// GET request : 수정 요청
		if(request.getMethod().equals("GET")) {
			// 아이디로 멤버 가져오기
			System.out.println("My Page로 이동했고 회원정보 수정 요청한 아이디는 " + member.getUser_name() + "이 사람임");
			return "/member/myPage.jsp";			
		}
		
		// POST request : 입력된 회원정보가 파라미터로 전달됨
		Member updateMember = new Member( member.getMember_id(), 
				request.getParameter("user_name"), request.getParameter("newPassword"),
				request.getParameter("name"), request.getParameter("email"),
				request.getParameter("phone"), request.getParameter("birth"));

		manager.update(updateMember);
		
		System.out.println("회원정보수정 완료, 프로젝트리스트로 넘어감");
		System.out.println(updateMember);
		return "redirect:/project/list";
	}
}
