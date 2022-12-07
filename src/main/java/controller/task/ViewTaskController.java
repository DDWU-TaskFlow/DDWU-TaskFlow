package controller.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class ViewTaskController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.getAttribute(null);
		
		request.setAttribute("projectId", response);
		request.setAttribute("memberId", response);
		request.setAttribute("taskManager", response);
		request.setAttribute("commentManager", response);

			
		return "/task/taskView.jsp";
	}

}
