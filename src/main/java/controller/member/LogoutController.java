package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

public class LogoutController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션에 저장된 사용자 이이디를 삭제하고 세션을 무효화 함 
		HttpSession session = request.getSession();
		session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);

		session.removeAttribute("firstAccess");
		session.invalidate();	
		System.out.println("session.invalidate() 실행됨, 로그아웃 완료!");
        
    return "redirect:/project/list";
    }
}
