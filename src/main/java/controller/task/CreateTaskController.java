package controller.task;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.RegisterUserController;
import model.Member;
import model.Task;
import model.service.ProjectManager;
import model.service.TaskManager;

public class CreateTaskController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		TaskManager tManager = TaskManager.getInstance();
		ProjectManager pManager = ProjectManager.getInstance();
		
		if (request.getMethod().equals("GET")) {	
			int projectId = Integer.parseInt(request.getParameter("projectId"));
			List<Member> memberList = pManager.findMembersInProject(projectId);
			System.out.println(memberList);
			
			request.setAttribute("memberList", memberList);
			request.setAttribute("projectId", projectId);
			request.setAttribute("memberList", memberList);
			
			return "/task/createTask.jsp";
		}
		
		// POST request : 입력된 태스크 정보가 파라미터로 전달됨
		System.out.println("task create Controller");
		
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		System.out.println("플젝 아디" + projectId);
		
		Task task = new Task();
		
		// 해당 태스크의 프로젝트 아이디
		task.setProject_id(projectId);
		
		// JSP 폼
		task.setName(request.getParameter("taskName"));
		
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		
		// 태스크 배정, 미배정 구분
		if (memberId != -1) {
			task.setMember_id(memberId);
		} else {	
			task.setMember_id(Integer.parseInt(request.getParameter("memberId")));
		}
		task.setDeadline(Date.valueOf(request.getParameter("deadline")));
		task.setContent(request.getParameter("content"));
		
		System.out.println(task);
		log.debug("Create Task: {}", task);
		
		if (tManager.insertTask(task) == 1) { 
			System.out.println("task insert 성공"); 
		}

		return "redirect:/project/view?step=1&&projectId="+Integer.parseInt(request.getParameter("projectId"));
	}
}
