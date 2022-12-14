package controller.project;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import controller.member.UserSessionUtils;
import model.Member;
import model.Project;
import model.service.CommentManager;
import model.service.ProjectManager;
import model.service.TaskManager;

public class ViewProjectController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if(!UserSessionUtils.hasLogined(request.getSession())) {
			return "/member/loginForm.jsp";
		}
		Project project = null;
    	List<Member> memberList = new ArrayList<Member>();
    	
    	ProjectManager pManager = ProjectManager.getInstance();
    	
		String fromWhere = request.getParameter("step");	
		if(fromWhere != null) {
			if(fromWhere.equals("1")) {
			//1)projectList->view | step == 1
				int projectId = Integer.parseInt(request.getParameter("projectId"));
				project = pManager.getProject(projectId);		// 프로젝트 정보 검색
				memberList = pManager.findMembersInProject(projectId);	// 멤버리스트 검색	
			}//2)setting->view | step == 2
			else if(fromWhere.equals("2")) {
				int projectId = Integer.parseInt(request.getParameter("project_id"));
				project = pManager.getProject(projectId);		// 프로젝트 정보 검색			
				memberList = pManager.findMembersInProject(projectId);	// 멤버리스트 검색	
			}
			request.setAttribute("project", project);		// 프로젝트 정보 저장
			request.setAttribute("memberList", memberList);		// 멤버리스트 저장	
				
			request.setAttribute("userId", request.getSession().getAttribute("member_id"));
				
			TaskManager tManager = TaskManager.getInstance();
			request.setAttribute("taskManager", tManager);
			
			CommentManager cManager = CommentManager.getInstance();
			request.setAttribute("commentManager", cManager);
		}
		
		
		
		return "/project/projectView.jsp";				// 프로젝트 보기 화면으로 이동
	}

}
