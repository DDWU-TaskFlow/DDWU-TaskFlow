package controller.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.TaskManager;

public class DeleteTaskController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		if (request.getServletPath().equals("/comment/create")) {		// 추가
		    
		}
		else if(request.getServletPath().equals("/comment/delete")) {	// 삭제
			TaskManager tManager = TaskManager.getInstance();
			int taskId = Integer.parseInt(request.getParameter("taskId"));
			System.out.println("삭제할 태스크" + taskId);
			tManager.deleteTask(taskId);
		}
		 
		
		return "redirect:/project/view?step=1&&projectId="+request.getParameter("projectId");
	}
}
