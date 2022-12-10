<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>task by member</title>
	
	<style>
	::-webkit-scrollbar {
	    display: none;
	}
	</style>

</head>

<body class="bg-light" id="body" style="overflow-y: scroll;">

	<div class="p-2 bg-body rounded shadow-sm">

	<c:set var="proId" value="${project.project_id}" />
	<c:set var="memId" value="${param.memberId}" />
	
	<div class="accordion" id="accordion${memId}">
	
	<c:set var="taskList" value="${taskManager.getTaskList(proId, memId)}" />

	<!-- 테스크가 없을 경우 -->
	<c:if test="${empty taskList}">
		<div class="d-flex p-1 align-items-center justify-content-center" style="height: 70px;">
			<span class="d-block text-center">
				 태스크를 추가하세요.
			</span>
		</div>
	</c:if>
	
	<c:forEach var="task" items="${taskList}">
		
		<div class="accordion-item border">
		<div id="headingTwo" class="accordion-header d-flex p-1 align-items-center justify-content-between" style="height: 100px; max-height: 500px;">
			<span class="d-flex justify-content-center" style="width: 160px;">
				<span class="d-block ps-3 pe-3 rounded-pill text-center"
					style="background-color: #fffacc;">
					<strong style="text-decoration: underline;">${task.name}</strong><br>
					<c:choose>
					  <c:when test="${empty task.deadline}">무기한</c:when>
					  <c:otherwise>by ${task.deadline}</c:otherwise>
					</c:choose>
				</span>
			</span>
			<span class="d-flex accordion-button collapsed p-2" style="width: 270px; height: 90px;" data-bs-toggle="collapse" data-bs-target="#collapse${task.task_id}">
				${task.content} (${task.task_progress}%)
			</span>
			<c:choose>
			  <c:when test="${(sessionScope.member_id == task.member_id) || (sessionScope.member_id == project.leader_id)}">
			    <span class="d-flex justify-content-center" style="width: 80px;">
					<button class="d-flex btn btn-outline-warning"
						onclick="location.href='<c:url value='/task/update'>
	 											  <c:param name="taskId" value="${task.task_id}" />
											    </c:url>';">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
						  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
						</svg>
					</button>
				</span>
			  </c:when>
			  <c:otherwise>
				  <span class="d-flex justify-content-center" style="width: 10px;">
					</span>
			  </c:otherwise>
			</c:choose>
			
		</div>
		</div>
	    <div id="collapse${task.task_id}" class="accordion-collapse collapse" data-bs-parent="#accordion${memId}">
	      <div class="accordion-body">
	       	  <!-- include comment.jsp -->
		      <c:import url="../task/comment.jsp">
		      	<c:param name="projectId" value="${proId}" />
		      	<c:param name="taskId" value="${task.task_id}" />
      			<c:param name="commentManager" value="${commentManager}" />
		      </c:import>
	      </div>
	    </div>
		<hr />
		
	</c:forEach>

	</div>


	</div>

	<div style="height: 70px;"></div>

	<nav class="fixed-bottom navbar-light bg-light"
		style="width: 549px; height: 45px; margin-left: auto;">
		<span class="d-flex pt-2 justify-content-center align-items-center">Task View & Comment</span>
	</nav>

</body>


</html>