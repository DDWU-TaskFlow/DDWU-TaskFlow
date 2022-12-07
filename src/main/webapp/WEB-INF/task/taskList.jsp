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

<body class="bg-light">

	<div class="p-2 bg-body rounded shadow-sm">

		<!-- 상단바 -->
		<div style="float: left;">
			<a href="#" class="btn rounded-pill"
				style="width: 80px; background-color: #b3c7ff;">배정</a>&nbsp; <a
				href="#" class="btn rounded-pill"
				style="width: 80px; background-color: #b3c7ff;">미배정</a>
		</div>
		<!-- 정렬 (기한, 멤버, 태스크) -->
		<!-- <div class="form-group d-flex flex-row-reverse">
  <select class="form-select" id="exampleSelect1" style="width: 100px;">
    <option selected>전체</option>
    <option>이송희</option>
    <option>심재현</option>
    <option>정유영</option>
    <option>서한나</option>
  </select>
</div> -->

	<c:set var="proId" value="${param.projectId}" />
	
		<div class="d-flex flex-row-reverse">
			<a href="<c:url value="/task/create" >
						<c:param name="projectId" value="${proId}" />
					</c:url>" class="btn" style="width: 65px; background-color: #7c78c0; color: white;">추가</a>&nbsp;
		</div>
		<hr />

	<c:set var="taskList" value="${taskManager.getTaskList(proId)}" />
	<c:forEach var="task" items="${taskList}">
		<c:set var="taskId" value="${task.task_id}" />
	
		<!-- DB에서 불러오도록 변경 -->
		<div class="d-flex p-1 align-items-center" style="height: 70px;">
			<span class="d-block text-center"><strong>'${task.name}'</strong><br>
				<span class="d-block mt-1 rounded-pill text-center"
				style="background-color: rgb(233, 231, 231); width: 200px;">
				by ${task.deadline} </span>
			</span>
			<details class="d-flex ps-2" style="width: 200px; height: 30px;">
				<summary>DETAIL</summary>
				<span class="p-2 rounded-3"
					style="width: 190px; height: 65px; background-color: black; color: white; margin-left: 80px; margin-top: -40px; overflow-y: scroll;">
					${task.content} </span>
			</details>
			<span class="rounded-pill" style="margin-left: auto;">
				<strong>- ${taskManager.findMemberNameByTaskId(taskId)}&nbsp;</strong>
			</span>
		</div>
		<hr />
		
	</c:forEach>
		
		<div class="d-flex p-1 align-items-center" style="height: 70px;">
			<span class="d-block text-center"><strong>'UI 디자인'</strong><br>
				<span class="d-block mt-1 rounded-pill text-center"
				style="background-color: rgb(233, 231, 231); width: 200px;">
				by 2022/12/05</span>
			</span>
			<details class="d-flex ps-2" style="width: 200px; height: 30px;">
				<summary>DETAIL</summary>
				<span class="p-2 rounded-3"
					style="width: 190px; height: 65px; background-color: black; color: white; margin-left: 80px; margin-top: -40px;">
					핵심 페이지 UI 디자인하기</span>
			</details>
			<span class="me-2" style="margin-left: auto;">
				<button class=" btn btn-outline-dark rounded-circle" type="button" onclick="location.href='<c:url value='/task/update/form' />';">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16" style="margin-bottom: 5px;">
					  <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
					  <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
					</svg>
				</button>
			</span>
		</div>
		<hr />


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