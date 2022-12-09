package controller.member;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Member;
import model.service.ExistingUserException;
import model.service.MemberManager;

public class JoinController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(JoinController.class);
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       	if (request.getMethod().equals("GET")) {
       		// GET request: 회원정보 등록 form 요청	
       		log.debug("joinForm Request");

       		return "/member/joinForm.jsp";
       	}
    	// POST request (회원정보가 parameter로 전송됨)
       	
       	Member member = new Member(
			request.getParameter("user_name"),
			request.getParameter("password"),
			request.getParameter("name"),
			request.getParameter("email"),
			request.getParameter("phone"),
			Date.valueOf(request.getParameter("birth")));
       	
       	System.out.println(member);
		
        log.debug("Create Member: {}", member);

		try {
			MemberManager manager = MemberManager.getInstance();
			manager.create(member);
	        return "redirect:/project/list";
	        
		} catch (ExistingUserException e) {	// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("member", member);

			return "/member/joinForm.jsp";
		}
    }

}
