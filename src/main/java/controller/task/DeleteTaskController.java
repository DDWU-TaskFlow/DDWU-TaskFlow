package controller.task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Task;
import model.service.HistoryManager;
import model.service.TaskManager;

public class DeleteTaskController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		TaskManager tManager = TaskManager.getInstance();
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		System.out.println("삭제할 태스크" + taskId);

		// history 처리
		Task task = new Task();
		task = tManager.findTaskByTaskId(taskId);
		if (tManager.deleteTask(taskId) == 1) {
			HistoryManager hManager = HistoryManager.getInstance();
			int sessionMember = (int)request.getSession().getAttribute("member_id");
			String content = "Task : '" + task.getName() + "' | 삭제";
			hManager.insertHistory(task.getProject_id(), sessionMember, content);
		}

		return "redirect:/project/view?step=1&&projectId="+request.getParameter("projectId");
	}
}
