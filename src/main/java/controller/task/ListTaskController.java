package controller.task;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.Task;
import model.service.TaskManager;

public class ListTaskController implements Controller {
    
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(!UserSessionUtils.hasLogined(request.getSession())) {
			return "/member/loginForm.jsp";
		}

		Map<String, String[]> map = request.getParameterMap();
		int projectId = Integer.parseInt(map.get("projectId")[0]);
		
		TaskManager tManager = TaskManager.getInstance();
     	request.setAttribute("projectId", projectId);
     	request.setAttribute("taskManager", tManager);
     	
     	String option = request.getParameter("option");
     	List<Task> taskList = null;
     	switch (option) {
     		case "mem":
     			taskList = tManager.orderTaskListByMember(projectId);
     			break;
     		case "prog":
     			taskList = tManager.orderTaskListByProgress(projectId);
     			break;
     		case "dead":
     			taskList = tManager.getTaskList(projectId);
     			break;
     		default:
     			taskList = tManager.orderTaskListByName(projectId);
     			break;
     	}
     	request.setAttribute("taskList", taskList);
		
		return "/task/taskList.jsp";
	}

}
