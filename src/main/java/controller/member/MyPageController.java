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
		
		String password; // 비밀번호 변경을 하지 않을 경우 null 저장되는 것 방지하기 위하여 별도로 password 변수 선언
		
		// New password, Confirm New password 미입력시
		if(request.getParameter("newPassword").equals("null") || request.getParameter("newPassword").equals("")) {
			password = member.getPassword();
		} else {
			password = request.getParameter("newPassword");
		}
		
		// POST request : 입력된 회원정보가 파라미터로 전달됨
		Member updateMember = new Member( member.getMember_id(), 
				request.getParameter("user_name"), password,
				request.getParameter("name"), request.getParameter("email"),
				request.getParameter("phone"), request.getParameter("birth"));

		manager.update(updateMember);
		
		System.out.println("회원정보수정 완료, 프로젝트리스트로 넘어감");
		System.out.println(updateMember);
		return "redirect:/project/list";
	}
}
