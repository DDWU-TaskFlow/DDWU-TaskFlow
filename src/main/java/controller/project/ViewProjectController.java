package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Project;
import model.service.ProjectManager;

public class ViewProjectController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Project project = null;
    	ProjectManager manager = ProjectManager.getInstance();
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		project = manager.getProject(projectId);		// 프로젝트 정보 검색	
		
		request.setAttribute("project", project);		// 프로젝트 정보 저장, 일단 ID 저장			
		return "/project/projectView.jsp";				// 프로젝트 보기 화면으로 이동
	}

}
