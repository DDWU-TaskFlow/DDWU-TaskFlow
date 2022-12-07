package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.Member;
import model.service.MemberManager;
import model.service.ProjectManager;

public class JoinProjectController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// GET request
		if(request.getMethod().equals("GET")) {
			return "/project/joinProject.jsp";
		} 
		
		// POST request
		ProjectManager projectManager = ProjectManager.getInstance();
		MemberManager memberManager = MemberManager.getInstance();
		
		String code = request.getParameter("code");
		int projectId = projectManager.getProjectID(code);
		
		Member member = memberManager.
				getMember((String)request.getSession().getAttribute("user_name"));
		int memeberId = member.getMember_id();
		
		projectManager.participate(projectId, memeberId);
		
		return "redirect:/project/list";
	}

}