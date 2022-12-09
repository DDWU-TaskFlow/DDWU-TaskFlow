package controller.project;

import java.util.ArrayList;
import java.util.List;

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
			ProjectManager pManager = ProjectManager.getInstance();
			
	    	List<Member> memberList = new ArrayList<Member>();
	    	int project_id = Integer.parseInt(request.getParameter("projectId"));
			memberList = pManager.findMembersInProject(project_id);			
			
			Project pro = pManager.getProject(project_id);
			
			request.setAttribute("memberList", memberList);
			request.setAttribute("project", pro);
			
			return "/project/setting.jsp";
		}
		
		MemberManager mManager = MemberManager.getInstance();
		ProjectManager pManager = ProjectManager.getInstance();

    	int projectId = Integer.parseInt(request.getParameter("project_id")); 
		Project project = pManager.getProject(projectId);
		
		String leader = request.getParameter("leader"); 
		Member leaderMem = mManager.getMemberByName(leader);
		
		project.setLeader_id(leaderMem.getMember_id());
//		project.setNotice(request.getParameter("notice"));
		
		pManager.updateProject(project);
		
		return "redirect:/project/view?step=2&&project_id="+projectId; //projectView 진입방법: step==2
	}
}
