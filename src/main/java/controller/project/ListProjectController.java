package controller.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.DispatcherServlet;
import model.Community;
import model.Project;
import model.service.ProjectManager;
import model.service.UserManager;

public class ListProjectController implements Controller {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProjectManager manager = ProjectManager.getInstance();
		List<Project> projectList = manager.getProjectList();
		

        logger.debug("Initialized ListProjectController!");

		// request 객체에 projectList 저장
		request.setAttribute("projectList", projectList);
		return "/member/projectList.jsp";
	}

}
