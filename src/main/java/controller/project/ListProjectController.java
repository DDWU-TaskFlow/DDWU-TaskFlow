package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Project;
import model.service.ProjectManager;

public class ListProjectController implements Controller {
    
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProjectManager manager = ProjectManager.getInstance();
		List<Project> projectList = manager.findProjectsInMember(1);
		// request 객체에 projectList 저장
		request.setAttribute("projectList", projectList);
		return "/member/projectList.jsp";
	}

}
