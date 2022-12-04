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
			return "/project/setting.jsp";
		}
    	
		MemberManager mManager = MemberManager.getInstance();
    	ProjectManager pManager = ProjectManager.getInstance();
		
    	int projectId = Integer.parseInt(request.getParameter("projectId"));
		Project project = pManager.getProject(projectId);		// 프로젝트 정보 검색

		String realName = request.getParameter("leader");
		Member leader = mManager.getMemberByName(realName);
		
		Project newPro = new Project(
				projectId,
				leader.getMember_id(),
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
