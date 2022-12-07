package controller.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.TaskManager;

public class DeleteTaskController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		

		System.out.println("task delete Controller");
		System.out.println("deletedeletedeletedeletedeletedeletedeletedeletedeletedeletedeletedeletedeletedeletedeletedelete");
		TaskManager tManager = TaskManager.getInstance();
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		System.out.println("삭제할 태스크" + taskId);
		tManager.deleteTask(taskId);
		
		return "redirect:/project/view?step=1&&projectId="+request.getParameter("projectId");
	}
}
