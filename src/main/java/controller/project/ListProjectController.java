package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.Member;
import model.Project;
import model.service.MemberManager;
import model.service.ProjectManager;

public class ListProjectController implements Controller {
    
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(!UserSessionUtils.hasLogined(request.getSession())) {
			return "/member/projectList.jsp"; //여기서 session값에 따라 비로긴
		}
		
		ProjectManager projectManager = ProjectManager.getInstance();
    
		String user_name = (String)request.getSession().getAttribute("user_name");
	    System.out.println("ListProjectController: 세션 저장 값 " + user_name);
		
		List<Project> projectList = projectManager.findProjectsInMember(user_name);

		MemberManager memberManager = MemberManager.getInstance();
		Member member = memberManager.getMember(user_name);

	    request.setAttribute("userId", user_name);
		// request 객체에 projectList 저장
		request.setAttribute("projectList", projectList);
		request.setAttribute("member", member);
		return "/member/projectList.jsp"; // session값에 따라 로긴
	}

}
