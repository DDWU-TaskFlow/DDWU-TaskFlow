package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.HistoryManager;
import model.service.ProjectManager;

public class DeleteProjectController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		ProjectManager pManager = ProjectManager.getInstance();
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		
		System.out.println("삭제할 프로젝트"+project_id);
		pManager.outProject(project_id); //해당 project에 참여한 사람들 다 없애기
		
		HistoryManager hManager = HistoryManager.getInstance();
		if (pManager.deleteProject(project_id) == 1) {
			hManager.deleteHistoryByProjectId(project_id);
		}
		
		return "redirect:/project/list";
	}

}
