package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.Project;
import model.service.ProjectManager;

public class ListProjectController implements Controller {
    
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(!UserSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/member/login/form";
		}
		ProjectManager manager = ProjectManager.getInstance();
    
		String user_name = request.getParameter(UserSessionUtils.USER_SESSION_KEY);
		List<Project> projectList = manager.findProjectsInMember(user_name);

		// request 객체에 projectList 저장
		request.setAttribute("projectList", projectList);
		return "/member/projectList.jsp"; // index.jsp안에 include 될 예정 -- 특정 회원의 project들 등장
	}

}
