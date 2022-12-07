package controller.task;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.Member;
import model.Task;
import model.service.HistoryManager;
import model.service.ProjectManager;
import model.service.TaskManager;

public class UpdateTaskController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if(!UserSessionUtils.hasLogined(request.getSession())) {
			return "/member/projectList.jsp";
		}
	    
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

		System.out.println("task update Controller");
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		Task task = new Task();
		task = tManager.findTaskByTaskId(taskId);
		int progress = task.getTask_progress();
		
		task.setName(request.getParameter("taskName"));
		int newProgress = Integer.parseInt(request.getParameter("taskProgress"));
		task.setTask_progress(newProgress);
		task.setMember_id(Integer.parseInt(request.getParameter("memberId")));
		task.setContent(request.getParameter("content"));
		task.setDeadline(Date.valueOf(request.getParameter("deadline")));

		if (tManager.updateTask(task) == 1) {
			System.out.println("task update 성공");
			if (newProgress != progress) {
				HistoryManager hManager = HistoryManager.getInstance();
				hManager.insertProgress(taskId, progress);
			}
		}
		
		return "redirect:/project/view?step=1&&projectId="+task.getProject_id();
	}
}
