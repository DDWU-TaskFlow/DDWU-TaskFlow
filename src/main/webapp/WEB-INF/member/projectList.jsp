<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<%@page import="controller.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.84.0">
<title>Task Flow</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/album/">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap">

<!-- Bootstrap core CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
* {
	font-family: 'Gowun Dodum', sans-serif;
	font-weight: bold;
}

a {
	text-decoration: none;
	color: black;
}

h4.card-title {
	font-weight: bold;
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.container {
	margin: auto;
}

.clrcle {
	width: 500px;
	height: 500px;
	border-radius: 50%;
	background: #808080;
	text-align: center;
}

.card-text {
	text-align: right;
}
</style>

<script type="text/javascript">
<%String strID = (String) session.getAttribute("user_name");
if (strID != null) {
	int firstAccess = (int) session.getAttribute("firstAccess");
	if (firstAccess == 1) {%> 
var strName="<%=strID%>
	";
	alert(strName + "님 방가방가");
<%}
session.setAttribute("firstAccess", 0);
}%>
	
</script>

</head>
<body>

	<main>
		<!-- 상단 Task Flow, member, project 생성 아이콘 -->
		<section class="container py-5" style="height: 250px;">
			<%-- 			<c:if test="${not empty userId}">
				<div
					style="width: 100px; height: 50px; margin-top: 5px; margin-right: 140px; float: right; color: rgb(0, 0, 0);">
					<button type="button" class="btn btn-primary btn-lg px-4 gap-3"
						style="border: 1px solid #FFFFFF; background-color: rgb(192, 86, 224); width: 100px; height: 50px; font-size: 10px;"
						onClick="location.href='<c:url value='/member/logout'/>'">로그아웃</button>
				</div>
			</c:if> --%>
			<div class="container-fluid text-center"
				style="margin-top: 10px; width: 400px; height: 100px;">
				<a href="index.jsp"
					style="color: rgb(192, 86, 224); display: block;">
					<p
						style="font-size: 70px; text-shadow: 1px 1px 5px rgb(197, 135, 226); font-weight: bold;">Task
						Flow</p>
				</a>
			</div>

			<c:if test="${not empty userId}">
				<!-- +버튼 생성 -->
				<a style="float: left; width: 60px;"
					href="<c:url value='/project/create'></c:url>">
					<div
						class="d-flex justify-content-center align-items-center border border-secondary rounded-circle"
						style="width: 40px; height: 40px; margin-right: 150px; margin-left: 20px; float: left;">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
  						<path
								d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
  						<path
								d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z" />
					</svg>
					</div>
				</a>

				<!-- 		<div class="d-flex"
					style="width: 50px; height: 50px; margin-left: 120px; float: left;">
					<button type="button"
						onclick="location.href='/taskflow/project/create';"
						style="border: 1px solid #FFFFFF; border-radius: 2em; cursor: pointer; cursor: hand; background-color: #ebebeb; color: rgb(0, 0, 0); width: 50px; height: 50px;">+</button>
				</div> -->


				<!-- in버튼 생성 -->
				<a style="float: left; width: 60px;"
					href="<c:url value='/project/join'></c:url>">
					<div
						class="d-flex justify-content-center align-items-center border border-secondary rounded-circle"
						style="width: 40px; height: 40px; margin-right: 150px; margin-left: 20px; float: left;">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-box-arrow-in-left"
							viewBox="0 0 16 16">
  						<path fill-rule="evenodd"
								d="M10 3.5a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-2a.5.5 0 0 1 1 0v2A1.5 1.5 0 0 1 9.5 14h-8A1.5 1.5 0 0 1 0 12.5v-9A1.5 1.5 0 0 1 1.5 2h8A1.5 1.5 0 0 1 11 3.5v2a.5.5 0 0 1-1 0v-2z" />
  						<path fill-rule="evenodd"
								d="M4.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H14.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z" />
					</svg>
					</div>
				</a>


				<!-- 로그아웃 -->
				<a style="float: right; width: 60px;"
					href="<c:url value='/member/logout'></c:url>">
					<div
						class="d-flex justify-content-center align-items-center border border-secondary rounded-circle"
						style="width: 40px; height: 40px; margin-right: 20px; float: right;">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-box-arrow-right"
							viewBox="0 0 16 16">
  						<path fill-rule="evenodd"
								d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z" />
  						<path fill-rule="evenodd"
								d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" />
					</svg>
					</div>
				</a>

				<!-- 마이페이지 -->
				<a style="float: right; width: 40px;"
					href="<c:url value='/member/mypage'>
						<c:param name='user_name' value='${member.user_name}'/>
						</c:url>">

					<div
						class="d-flex justify-content-center align-items-center border border-secondary rounded-circle"
						style="width: 40px; height: 40px; margin-right: 20px; float: right;">
						<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32"
							fill="currentColor" class="bi bi-person-circle"
							viewBox="0 0 16 16">
          				<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
						<path fill-rule="evenodd"
								d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
       		 		</svg>
					</div>
				</a>



			</c:if>
		</section>

		<c:choose>
			<c:when test="${not empty userId}">

				<!-- 프로젝트 -->
				<div class="container align-items-center" style="max-width: 1130px;">

					<div class="row justify-content-center">

						<c:forEach var="project" items="${projectList}">

							<div class="card border-dark mb-3"
								style="width: 350px; height: 200px;">
								<div class="card-body">
									<c:if test="${project.type == 0}">
										<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
  											<path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
										</svg>
      								</c:if>
      								<c:if test="${project.type == 1}">
										<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35"
											fill="currentColor" class="bi bi-people-fill"
											viewBox="0 0 16 16">
	        								<path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7Zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216ZM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z" />
	      								</svg>
      								</c:if>
									<h4 class="card-title">
										<a class="card-title"
											href="<c:url value='/project/view'>
														<c:param name='step' value='1'/> 
						      							<c:param name='projectId' value='${project.project_id}'/>
						   					</c:url>">
											<!-- projectView 진입방법1 --> ${project.name}
										</a>
									</h4>
									<p></p>
									<p class="card-text" text-align="right">${project.avg}%</p>
									<p></p>
									<div class="progress" style="height: 25px;">
										<div class="progress-bar progress-bar-striped"
											role="progressbar"
											style="width: ${project.avg}%; height: 25px; background-color: ${project.color};"
											aria-valuenow="${project.avg}" aria-valuemin="0"
											aria-valuemax="100"></div>
									</div>
								</div>
							</div>

							<div style="width: 25px;"></div>

						</c:forEach>
			</c:when>
			<c:when test="${empty userId}">
				<jsp:include page="nonLogin.jsp" />
			</c:when>
		</c:choose>

		<!-- 				생활지도 및 상담 프로젝트
				<div class="card border-dark mb-3"
					style="width: 350px; height: 200px;">
					<div class="card-body">
						<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35"
							fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">
        					<path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7Zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216ZM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z" />
      					</svg>
						<h4 class="card-title">
							<a class="card-title" href="./project/project.jsp">생활지도 및 상담</a>
						</h4>
						<p></p>
						<p class="card-text" text-align="right">70%</p>
						<p></p>
						<div class="progress" style="height: 25px;">
							<div class="progress-bar progress-bar-striped" role="progressbar"
								style="width: 70%; height: 25px; background-color: #A1A2D3;"
								aria-valuenow="70" aria-valuemin="0" aria-valuemax="100">
							</div>
						</div>
					</div>
				</div>
				<div style="width: 25px;"></div>
				백준 Class 2 다 풀기 프로젝트
				<div class="card border-dark mb-3"
					style="width: 350px; height: 200px;">
					<div class="card-body">
						<div style="height: 35px;"></div>
						<h4 class="card-title">
							<a class="card-title" href="./project/project.jsp">백준 Class 2 다 풀기</a>
						</h4>
						<p></p>
						<p class="card-text" text-align="right">30%</p>
						<p></p>
						<div class="progress" style="height: 25px;">
							<div class="progress-bar progress-bar-striped" role="progressbar"
								style="width: 30%; height: 25px; background-color: #f5b6c4;"
								aria-valuenow="30" aria-valuemin="0" aria-valuemax="100">
							</div>
						</div>
					</div>
				</div>
				<div style="width: 25px;"></div>
				동아리 프로젝트 프로젝트
				<div class="card border-dark mb-3"
					style="width: 350px; height: 200px;">
					<div class="card-body">
						<svg xmlns="http://www.w3.org/2000/svg" width="35" height="35"
							fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">
            				<path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7Zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216ZM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z" />
         				</svg>
						<h4 class="card-title">
							<a class="card-title" href="./project/project.jsp">동아리 프로젝트</a>
						</h4>
						<p></p>
						<p class="card-text" text-align="right">10%</p>
						<p></p>
						<div class="progress" style="height: 25px;">
							<div class="progress-bar progress-bar-striped" role="progressbar"
								style="width: 10%; height: 25px; background-color: #f0c466;"
								aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div>
						</div>
					</div>
				</div>
				<div style="width: 25px;"></div>
				sqld 자격증 공부 프로젝트
				<div class="card border-dark mb-3"
					style="width: 350px; height: 200px;">
					<div class="card-body">
						<div style="height: 35px;"></div>
						<h4 class="card-title">
							<a class="card-title" href="./project/project.jsp">sqld 자격증 공부</a>
						</h4>
						<p></p>
						<p class="card-text" text-align="right">0%</p>
						<p></p>
						<div class="progress" style="height: 25px;">
							<div class="progress-bar progress-bar-striped" role="progressbar"
								style="width: 0%; height: 25px; background-color: #ac68da;"
								aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>
						</div>
					</div>
				</div>
				<div style="width: 25px;"></div> -->


		</div>

		</div>

	</main>

</body>
</html>