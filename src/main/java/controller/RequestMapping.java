package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.member.EnterMemberController;
import controller.member.JoinController;
import controller.member.ListTeamMemberController;
import controller.member.LoginController;
import controller.member.LogoutController;
import controller.member.MyPageController;
import controller.project.CreateProjectController;
import controller.project.DeleteProjectController;
import controller.project.ListProjectController;
import controller.project.OutProjectController;
import controller.project.UpdateProjectController;
import controller.project.ViewProjectController;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
        mappings.put("/", new ForwardController("index.jsp"));
        
        // member
        mappings.put("/member/login/form", new ForwardController("/member/loginForm.jsp")); //테스트용
        mappings.put("/member/login", new LoginController());
        mappings.put("/member/logout", new LogoutController());
        
        mappings.put("/member/join", new JoinController());	// get, post
        
        mappings.put("/member/team", new ListTeamMemberController());
        mappings.put("/member/entrance", new EnterMemberController());
        mappings.put("/member/mypage", new MyPageController());
        
        // projeDct
        mappings.put("/project/create", new CreateProjectController());	// get, post
        mappings.put("/project/update", new UpdateProjectController());
        mappings.put("/project/delete", new DeleteProjectController());
        mappings.put("/project/setting/out", new OutProjectController());
        mappings.put("/project/list", new ListProjectController());
        mappings.put("/project/view", new ViewProjectController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}