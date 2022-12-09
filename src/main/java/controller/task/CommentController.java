package controller.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.UserSessionUtils;
import model.Comment;
import model.service.CommentManager;
import model.service.HistoryManager;
import model.service.TaskManager;

public class CommentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		if(!UserSessionUtils.hasLogined(request.getSession())) {
			return "/member/loginForm.jsp";
		}

		int memberId = (int) request.getSession().getAttribute("member_id");
		
		CommentManager cManager = CommentManager.getInstance();
		int msg_success = 0;
		int is_insert = 0;
		if (request.getServletPath().equals("/comment/create")) { // 추가
			
			Comment comment = new Comment();
			comment.setMemberId(memberId);
			comment.setTaskId(Integer.parseInt(request.getParameter("taskId")));
			comment.setContent(request.getParameter("content"));
			System.out.println(comment);
			if (cManager.insertComment(comment) == 1) {
				System.out.println("comment insert 성공");
				msg_success = 1;
				is_insert = 1;
				
				// history 처리
				HistoryManager hManager = HistoryManager.getInstance();
				TaskManager tManager = TaskManager.getInstance();
				String taskName = tManager.findTaskByTaskId(comment.getTask_id()).getName();
				String content = "Comment : '" + taskName + "'";
				content += " | 댓글 작성 | " + "\"";
				if (comment.getContent().length() > 20) {
					content += comment.getContent().substring(0, 10) + "...\"";
				} else {
					content += comment.getContent() + "\"";
				}
				hManager.insertHistory(Integer.parseInt(request.getParameter("projectId")), memberId, content);
			}
		}
		else if(request.getServletPath().equals("/comment/delete")) { // 삭제
			int commentId = Integer.parseInt(request.getParameter("commentId"));
			System.out.println("삭제할 코멘트" + commentId);
			Comment comment = new Comment();
			comment = cManager.findCommentByCommentId(commentId);
			
			if (cManager.deleteComment(commentId) == 1) {
				System.out.println("comment delete 성공");
				msg_success = 1;
				is_insert = 0;

				// history 처리
				HistoryManager hManager = HistoryManager.getInstance();
				TaskManager tManager = TaskManager.getInstance();
				String taskName = tManager.findTaskByTaskId(comment.getTask_id()).getName();
				String content = "Comment : '" + taskName + "'";
				content += " | 댓글 삭제 | " + "\"";
				if (comment.getContent().length() > 20) {
					content += comment.getContent().substring(0, 10) + "...\"";
				} else {
					content += comment.getContent() + "\"";
				}
				hManager.insertHistory(Integer.parseInt(request.getParameter("projectId")), memberId, content);
			}
		}
		return "redirect:/project/view?step=1&&projectId="+request.getParameter("projectId")+"&&msg="+msg_success+"&&is_insert="+is_insert;		
	}
}
