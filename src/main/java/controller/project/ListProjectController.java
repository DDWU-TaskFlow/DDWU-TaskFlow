package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Community;
import model.Project;
import model.service.ProjectManager;
import model.service.UserManager;

public class ListProjectController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ProjectManager manager = ProjectManager.getInstance();
		List<Project> projectList = manager.getProjectList();

		// request 객체에 projectList 저장
		request.setAttribute("projectList", projectList);
		return "/index.jsp";
	}

}
