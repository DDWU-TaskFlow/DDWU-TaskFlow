package controller.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.Task;
import model.service.ProjectManager;
import model.service.TaskManager;

public class CreateTaskController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		TaskManager tManager = TaskManager.getInstance();
		ProjectManager pManager = ProjectManager.getInstance();
		
		if (request.getMethod().equals("GET")) {	
			int projectId = Integer.parseInt(request.getParameter("projectId"));
			List<Member> memberList = pManager.findMembersInProject(projectId);
			System.out.println(memberList);
			
			request.setAttribute("memberList", memberList);
			
			return "/task/createTask.jsp";
		}
		
		Task task = new Task();
		
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		if (memberId != -1) {
			task.setMember_id(memberId);
		}
		
		
		/*
		 * if (tManager.insertTask(task) == 1) { System.out.println("task insert 성공"); }
		 */
		
		
		return "redirect:/project/view?step=1&&projectId="+request.getParameter("projectId");
	}
}
