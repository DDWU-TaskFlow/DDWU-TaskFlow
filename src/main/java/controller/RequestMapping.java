package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.member.DeleteMemberController;
import controller.member.RegisterMemberController;
import controller.member.LoginController;
import controller.member.LogoutController;
import controller.member.MyPageController;
import controller.project.CreateProjectController;
import controller.project.DeleteProjectController;
import controller.project.HistoryController;
import controller.project.JoinProjectController;
import controller.project.ListProjectController;
import controller.project.OutProjectController;
import controller.project.SendMessageController;
import controller.project.UpdateProjectController;
import controller.project.ViewProjectController;
import controller.task.CommentController;
import controller.task.CreateTaskController;
import controller.task.DeleteTaskController;
import controller.task.ListTaskController;
import controller.task.UpdateTaskController;

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
        mappings.put("/member/join", new RegisterMemberController());	// get, post
        mappings.put("/member/mypage", new MyPageController());
        mappings.put("/member/delete", new DeleteMemberController());
        
        // project
        mappings.put("/project/create", new CreateProjectController());	// get, post
        mappings.put("/project/update", new UpdateProjectController());
        mappings.put("/project/delete", new DeleteProjectController());
        mappings.put("/project/out", new OutProjectController());
        mappings.put("/project/list", new ListProjectController());
        mappings.put("/project/view", new ViewProjectController());
        mappings.put("/project/join", new JoinProjectController());		// get, post
        
        mappings.put("/project/sendMessage", new SendMessageController());
        
        // task
        mappings.put("/task/create", new CreateTaskController()); // get, post
        mappings.put("/task/update", new UpdateTaskController()); // get, post
        mappings.put("/task/delete", new DeleteTaskController());
        mappings.put("/task/list", new ListTaskController());
        
        // comment
        mappings.put("/comment/create", new CommentController());
        mappings.put("/comment/delete", new CommentController());
        
        // history
        mappings.put("/history/list", new HistoryController());
        
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}