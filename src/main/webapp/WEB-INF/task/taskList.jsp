<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<title>taskList.jsp</title>
	
	<style>
	::-webkit-scrollbar {
	    display: none;
	}
	</style>
	
</head>

<body>

<div class="p-2 bg-body rounded shadow-sm" style="margin-top: -10px;">

	<c:set var="proId" value="${param.projectId}" />
	
	<c:choose>
	  <c:when test="${option eq 'mem'}">
		<c:set var="taskList" value="${taskManager.orderTaskListByMember(proId)}" />
	  </c:when>
	  <c:when test="${option eq 'prog'}">
		<c:set var="taskList" value="${taskManager.orderTaskListByProgress(proId)}" />
	  </c:when>
	  <c:when test="${option eq 'dead'}">
		<c:set var="taskList" value="${taskManager.getTaskList(proId)}" />
	  </c:when>
	  <c:otherwise>
		<c:set var="taskList" value="${taskManager.orderTaskListByName(proId)}" />
	  </c:otherwise>
	</c:choose>
	
	<!-- 테스크가 없을 경우 -->
	<c:if test="${empty taskList}">
		<div class="d-flex p-1 align-items-center justify-content-center" style="height: 70px;">
			<span class="d-block text-center">
				 태스크를 추가하세요.
			</span>
		</div>
	</c:if>
	
	<c:forEach var="task" items="${taskList}">
		<c:set var="taskId" value="${task.task_id}" />
	
		<!-- DB에서 불러오도록 변경 -->
		<div class="d-flex p-1 align-items-center" style="height: 70px;">
			<span class="d-block text-center"><strong>'${task.name}'</strong><br>
				<span class="d-block mt-1 rounded-pill text-center"
				style="background-color: rgb(233, 231, 231); width: 200px;">
				<c:choose>
				  <c:when test="${empty task.deadline}">무기한</c:when>
				  <c:otherwise>by ${task.deadline}</c:otherwise>
				</c:choose>
				</span>
			</span>
				<details class="d-flex ps-2" style="width: 200px; height: 30px;">
					<summary>DETAIL</summary>
					<c:if test="${not empty task.content}">
						<span class="p-2 rounded-3"
							style="width: 190px; height: 65px; background-color: black; color: white; margin-left: 80px; margin-top: -40px; overflow-y: scroll;">
							${task.content} : ${task.task_progress}% 진행됨
						</span>
					</c:if>
				</details>
			<c:choose>
			  <c:when test="${task.member_id != -1}">
				<span class="rounded-pill" style="margin-left: auto;">
					<strong>- ${taskManager.findMemberNameByTaskId(taskId)}&nbsp;</strong>
				</span>
			  </c:when>
			  <c:otherwise>
				<span class="me-2" style="margin-left: auto;">
				<button class=" btn btn-outline-dark rounded-circle" type="button"
						onclick="location.href='<c:url value='/task/update'>
	 											  <c:param name="taskId" value="${task.task_id}" />
											    </c:url>';">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16" style="margin-bottom: 5px;">
					  <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
					  <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
					</svg>
				</button>
			    </span>
			   </c:otherwise>
			</c:choose>
		</div>
		<hr />
		
	</c:forEach>
	
	</div>

	<div style="height: 70px;"></div>

	<nav class="fixed-bottom navbar-light bg-light"
		style="width: 549px; height: 45px; margin-left: auto;">
		<span class="d-flex pt-2 justify-content-center align-items-center">Task List</span>
	</nav>

</body>


</html>