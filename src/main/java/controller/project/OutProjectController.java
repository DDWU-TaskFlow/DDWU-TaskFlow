package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Participation;
import model.service.MemberManager;
import model.service.ProjectManager;

public class OutProjectController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ProjectManager pManager = ProjectManager.getInstance();
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		int projectId = Integer.parseInt(request.getParameter("project_id"));
		
		Participation part = new Participation(projectId, userId);
		pManager.outProjectByMember(part);
		
		return "redirect:/project/list";
	}
}
