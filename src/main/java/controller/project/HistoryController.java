package controller.project;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.History;
import model.service.HistoryManager;

public class HistoryController implements Controller {
    
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(!UserSessionUtils.hasLogined(request.getSession())) {
			return "/member/loginForm.jsp";
		}

		Map<String, String[]> map = request.getParameterMap();
		int projectId = Integer.parseInt(map.get("projectId")[0]);
		
     	HistoryManager hManager = HistoryManager.getInstance();
     	request.setAttribute("projectId", projectId);
     	request.setAttribute("historyManager", hManager);
     	
     	String option = request.getParameter("option");
     	List<History> historyList = null;
     	switch (option) {
     		case "all":
     			historyList = hManager.findHistoryByProjectId(projectId);
     			break;
     		default:
     			historyList = hManager.findHistoryByMemberId(projectId, Integer.parseInt(option));
     			break;
     	}
     	request.setAttribute("historyList", historyList);

		
		return "/project/history.jsp";
	}
}
