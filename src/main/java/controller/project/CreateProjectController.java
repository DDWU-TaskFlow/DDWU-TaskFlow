package controller.project;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Participation;
import model.Project;
import model.service.ProjectManager;

public class CreateProjectController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// GET request
		if(request.getMethod().equals("GET")) {
			return "/project/createProject.jsp";
		} 
		
		// POST request
		Project project = new Project(
				-1,
				request.getParameter("name"),
				0,
				new Date(0),
				"",
				request.getParameter("notice")
				)
				;
		
		
		ProjectManager.getInstance().insertProject(project);
		System.out.println(project + "생성 완료");
		
		// 생성된 id 가져오기 -> 우선 id 임의 생성으로 대체
		
		// 생성된 아이디로 participation 테이블에 등록
		Participation participation = new Participation(117, 1);
		ProjectManager.getInstance().participateInProject(participation);
		
		return "redirect:/project/list";
	}

}
