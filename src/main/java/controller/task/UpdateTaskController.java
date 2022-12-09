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
		
		String oldName = task.getName();
		String newName = request.getParameter("taskName");
		int oldProgress = task.getTask_progress();
		int newProgress = Integer.parseInt(request.getParameter("taskProgress"));
		int oldMember = task.getMember_id();
		int newMember = Integer.parseInt(request.getParameter("memberId"));
		Date oldDeadline = task.getDeadline();
		Date newDeadline = Date.valueOf(request.getParameter("deadline"));
		
		task.setName(newName);
		task.setTask_progress(newProgress);
		task.setMember_id(newMember);
		task.setContent(request.getParameter("content"));
		task.setDeadline(newDeadline);

		if (tManager.updateTask(task) == 1) {
			System.out.println("task update 성공");
			
			HistoryManager hManager = HistoryManager.getInstance();
			int sessionMember = (int)request.getSession().getAttribute("member_id");
			
			if(!newName.equals(oldName)) {
				String content = "Task : " + oldName;
				content += " | 이름 변경 | " + oldName + " -> " + newName;
				hManager.insertHistory(task.getProject_id(), sessionMember, content);
			}
			if (newProgress != oldProgress) {
				String content = "Task : " + oldName;
				int dist = newProgress - oldProgress;
				content += " | 진행률 변경 | " + newProgress;
				content += " (";
				if (dist > 0) {
					content += "+";
				}
				content += dist + "%)";
				hManager.insertHistory(task.getProject_id(), sessionMember, content);
			}
			if (oldMember != newMember) {
				String content = "Task : " + oldName;
				content += " | 담당 변경 | " + tManager.findMemberNameByTaskId(taskId);
				hManager.insertHistory(task.getProject_id(), sessionMember, content);
			}
			if (oldDeadline.compareTo(newDeadline) != 0) {
				String content = "Task : " + oldName;
				content += " | 기한 변경 | " + oldDeadline + " -> " + newDeadline;
				hManager.insertHistory(task.getProject_id(), sessionMember, content);
			}
		}
		
		return "redirect:/project/view?step=1&&projectId="+task.getProject_id();
	}
}
