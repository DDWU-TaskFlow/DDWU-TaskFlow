package controller.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.Task;
import model.service.ProjectManager;
import model.service.TaskManager;

public class UpdateTaskController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (request.getMethod().equals("GET")) {
			int taskId = Integer.parseInt(request.getParameter("taskId"));

			Task task = new Task();
			TaskManager tManager = TaskManager.getInstance();
			task = tManager.findTaskByTaskId(taskId);
			
			ProjectManager pManager = ProjectManager.getInstance();
			List<Member> memberList = pManager.findMembersInProject(task.getProject_id());
			
			request.setAttribute("task", task);
			request.setAttribute("memberList", memberList);
					
			return "/task/updateTask.jsp";
		}
		
		
		return "redirect:/project/view";
	}
}
