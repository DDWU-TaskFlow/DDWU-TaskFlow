package controller.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.Comment;
import model.service.CommentManager;

public class CommentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		if(!UserSessionUtils.hasLogined(request.getSession())) {
			return "/member/loginForm.jsp";
		}
		
		CommentManager cManager = CommentManager.getInstance();
		int msg_success = 0;
		int is_insert = 0;
		if (request.getServletPath().equals("/comment/create")) { // 추가
			
			int memberId = (int) request.getSession().getAttribute("member_id");
			
			Comment comment = new Comment();
			comment.setMemberId(memberId);
			comment.setTaskId(Integer.parseInt(request.getParameter("taskId")));
			comment.setContent(request.getParameter("content"));
			System.out.println(comment);
			if (cManager.insertComment(comment) == 1) {
				System.out.println("comment insert 성공");
				msg_success = 1;
				is_insert = 1;
			}
		}
		else if(request.getServletPath().equals("/comment/delete")) { // 삭제
			int commentId = Integer.parseInt(request.getParameter("commentId"));
			System.out.println("삭제할 태스크" + commentId);
			if (cManager.deleteComment(commentId) == 1) {
				System.out.println("comment delete 성공");
				msg_success = 1;
				is_insert = 0;
			}
		}
		return "redirect:/project/view?step=1&&projectId="+request.getParameter("projectId")+"&&msg="+msg_success+"&&is_insert="+is_insert;		
	}
}
