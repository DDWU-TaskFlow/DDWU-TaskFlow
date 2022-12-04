package controller.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.Project;
import model.service.MemberManager;
import model.service.ProjectManager;

public class UpdateProjectController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if (request.getMethod().equals("GET")) {	
			MemberManager mManager = MemberManager.getInstance();

			int realId = Integer.parseInt(request.getParameter("userId"));
			Member leader = mManager.getMember(realId);
			System.out.println(leader);
			
			request.setAttribute("leader", leader);
			request.setAttribute("memberManager", mManager);
			
			return "/project/setting.jsp";
		}
    	

    	ProjectManager pManager = ProjectManager.getInstance();

		Project project = (Project) request.getAttribute("project");

		Project newPro = new Project(
				project.getProject_id(),
				project.getLeader_id(),
				project.getName(),
				project.getType(),
				project.getCreationDate(),
				request.getParameter("notice"),
				project.getColor()
		);		
		pManager.updateProject(newPro);

		
		return "redirect:/project/view";
	}
}
