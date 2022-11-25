package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.*;
import controller.comm.*;
import controller.member.EnterMemberController;
import controller.member.ListTeamMemberController;
import controller.member.LogoutController;
import controller.member.RegisterUserController;
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
        mappings.put("/member/login/form", new ForwardController("/user/loginForm.jsp")); 
        mappings.put("/member/login", new LoginController());
        mappings.put("/member/logout", new LogoutController());
        mappings.put("/member/join", new RegisterUserController());	// get, post
        mappings.put("/member/team", new ListTeamMemberController());
        mappings.put("/member/entrance", new EnterMemberController());
        
        // project
        mappings.put("/project/create/form", new CreateProjectController());
        mappings.put("/project/create", new CreateProjectController());
        mappings.put("/project/update", new UpdateProjectController());
        mappings.put("/project/delete", new DeleteProjectController());
        mappings.put("/project/setting/out", new OutProjectController());
        mappings.put("/project/list", new ListProjectController());
        mappings.put("/project/view", new ViewProjectController());

        // 사용자 정보 수정 폼 요청과 수정 요청 처리 병합
//      mappings.put("/user/update/form", new UpdateUserFormController());
//      mappings.put("/user/update", new UpdateUserController());        
        mappings.put("/user/update", new UpdateUserController());
        
        mappings.put("/user/delete", new DeleteUserController());
        
        // 커뮤니티 관련 request URI 추가
        mappings.put("/community/list", new ListCommunityController());
        mappings.put("/community/view", new ViewCommunityController());
        mappings.put("/community/create/form", new ForwardController("/community/creationForm.jsp"));
        mappings.put("/community/create", new CreateCommunityController());
        mappings.put("/community/update", new UpdateCommunityController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}