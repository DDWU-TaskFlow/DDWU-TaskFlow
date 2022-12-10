package controller.task;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
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
     	request.setAttribute("option", request.getParameter("option"));
		
		return "/task/taskList.jsp";
	}

}
