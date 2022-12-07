package controller.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.Project;
import model.Task;
import model.service.ProjectManager;
import model.service.TaskManager;

public class UpdateTaskController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		TaskManager tManager = TaskManager.getInstance();
		ProjectManager pManager = ProjectManager.getInstance();
		
		if (request.getMethod().equals("GET")) {
			int taskId = Integer.parseInt(request.getParameter("taskId"));

			Task task = new Task();
			task = tManager.findTaskByTaskId(taskId);
			
			List<Member> memberList = pManager.findMembersInProject(task.getProject_id());
			System.out.println(memberList);
			
			request.setAttribute("task", task);
			request.setAttribute("memberList", memberList);
					
			return "/task/updateTask.jsp";
		}

		Task task = new Task();
		task = tManager.findTaskByTaskId(Integer.parseInt(request.getParameter("taskId")));
		
		task.setName(request.getParameter("taskName"));
		task.setTask_progress(Integer.parseInt(request.getParameter("taskProgress")));
		task.setMember_id(Integer.parseInt(request.getParameter("memberId")));
		task.setContent(request.getParameter("content"));
		task.setDeadline(Date.valueOf(request.getParameter("deadline")));

		if (tManager.updateTask(task) == 1) {
			System.out.println("task update 성공");
		}
		
		return "redirect:/project/view?step=1&&projectId="+task.getProject_id();
	}
}
