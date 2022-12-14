package controller.project;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Project;
import model.service.MemberManager;
import model.service.ProjectManager;

public class CreateProjectController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// GET request
		if(request.getMethod().equals("GET")) {
			return "/project/createProject.jsp";
		} 
		
		try {
			// POST request
			ProjectManager manager = ProjectManager.getInstance();
			
			// session에 저장되어있는 값 통해 리더 아이디 가져오기
			String userName = (String)request.getSession().getAttribute("user_name");
			System.out.println("CreateProjectController: 가져온 userName은 " + userName);
			
			model.Member member = MemberManager.getInstance().getMember(userName);
			
			Project project = new Project(
					member.getMember_id(),
					request.getParameter("name"),
					0,
					new Date(0),
					manager.getRandomString(),
					request.getParameter("notice"),
					request.getParameter("color")
					);
			
			
			manager.insertProject(project);
			System.out.println(project + "생성 완료");
			
			return "redirect:/project/list";
		} catch (Exception e) {
			/* request.getParameter("name") 예외처리*/
      request.setAttribute("createFailed", true);
			request.setAttribute("exception", e);
			
			return "/project/createProject.jsp";
		}

	}

}
