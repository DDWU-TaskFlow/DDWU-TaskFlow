<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="EUC-KR">
	<title>task by member</title>
	
	<style>
	::-webkit-scrollbar {
	    display: none;
	}
	</style>

</head>

<body class="bg-light" id="body" style="overflow-y: scroll;">

	<div class="p-2 bg-body rounded shadow-sm">

		<!-- 상단바 -->
		<div style="float: left;">
			<a href="#" class="btn"
				style="width: 65px; background-color: #7c78c0; color: white;">버튼</a>&nbsp;
		</div>
		<!-- 정렬 (기한, 멤버, 태스크) -->
		<div class="form-group d-flex flex-row-reverse">
		  <select class="form-select" id="exampleSelect1" style="width: 100px;">
		    <option selected>기한순</option>
		    <option>진행순</option>
		  </select>
		</div>
		<hr />
		
	<c:set var="proId" value="${param.projectId}" />
	<c:set var="memId" value="${param.memberId}" />
	
	<div class="accordion" id="accordion${memId}">

	<c:set var="taskList" value="${taskManager.getTaskList(proId, memId)}" />
	<c:forEach var="task" items="${taskList}">
		
		<div class="accordion-item border">
		<div id="headingTwo" class="accordion-header d-flex p-1 align-items-center justify-content-between" style="height: 100px; max-height: 500px;">
			<span class="d-flex justify-content-center" style="width: 160px;">
				<span class="d-block ps-3 pe-3 rounded-pill text-center"
					style="background-color: #fffacc;">
					<strong style="text-decoration: underline;">${task.name}</strong><br>by
					${task.deadline}
				</span>
			</span>
			<span class="d-flex accordion-button collapsed p-2" style="width: 270px; height: 90px;" data-bs-toggle="collapse" data-bs-target="#collapse${task.task_id}">
				${task.content} (${task.task_progress}%)
			</span>
			<span class="d-flex justify-content-center" style="width: 80px;">
				<button class="d-flex btn btn-outline-warning" onclick="location.href='<c:url value='/task/update/form' />';">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
					  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
					</svg>
				</button>
			</span>
		</div>
		</div>
	    <div id="collapse${task.task_id}" class="accordion-collapse collapse" data-bs-parent="#accordion${memId}">
	      <div class="accordion-body">
	       	  <!-- include comment.jsp -->
		      <c:import url="../task/comment.jsp">
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

	<nav class="navbar fixed-bottom navbar-light bg-light"
		style="width: 549px; margin-left: auto;">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Fixed bottom</a>
		</div>
	</nav>

</body>


</html>