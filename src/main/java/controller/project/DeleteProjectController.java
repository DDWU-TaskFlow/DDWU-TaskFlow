package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Project;
import model.service.ProjectManager;

public class DeleteProjectController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("GET")) {	
			return "/project/setting.jsp";
		}
		
		ProjectManager pManager = ProjectManager.getInstance();
		Project pro = (Project) request.getAttribute("project");
    	int projectId = pro.getProject_id();
		pManager.outProject(projectId); //해당 project에 참여한 사람들 다 없애기
		pManager.deleteProject(projectId);
		
		return "redirect:/project/view";
	}

}
