package controller.project;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import model.Project;
import model.service.ProjectManager;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;

public class SendMessageController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	List<Member> memberList = new ArrayList<Member>(); //수신자 -> 이 프로젝트에 있는 모든 사람
    	String notice = request.getParameter("notice"); //공지 내용

		ProjectManager pManager = ProjectManager.getInstance();
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		int leader_id = Integer.parseInt(request.getParameter("leader_id"));
		
		Project pro = pManager.getProject(project_id);
		memberList = pManager.findMembersInProject(project_id);	
		
		request.setAttribute("memberList", memberList);
		
		System.out.println(memberList);
		DefaultMessageService messageService =  NurigoApp.INSTANCE.initialize("NCSPUG3RCJPOKFDP", "PZMFWVTPUE8RMMSHMT6MRFTWMDLBGGMG", "https://api.solapi.com");

		Message message = new Message();
		message.setFrom("01020107204");
		int success = 0;
		
		for(int i=0; i<memberList.size(); i++) {
			Member mem = memberList.get(i);
			if(mem.getMember_id() != leader_id) 
			{
				String phone = mem.getPhone();
				phone = phone.replaceAll("[^0-9]", "");
				System.out.println("수신자 전화번호"+phone);
				message.setTo(phone);
				message.setText(notice);
				
				try {
				  messageService.send(message);
				  success = 1;
				  pro.setNotice(notice);	
				  pManager.updateProject(pro);			
				  request.setAttribute("project", pro);		  
				} catch (NurigoMessageNotReceivedException exception) {				  
				  System.out.println(exception.getFailedMessageList());
				  System.out.println(exception.getMessage());
				} catch (Exception exception) {
				  System.out.println(exception.getMessage());
				}
			}
		}		
		return "/project/setting.jsp?success="+success;
	}
}
