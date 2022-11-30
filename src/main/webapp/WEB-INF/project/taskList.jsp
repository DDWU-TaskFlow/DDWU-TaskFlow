<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="EUC-KR">
	<title>taskList.jsp</title>
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
		<div class="d-flex flex-row-reverse">
			<a href="createTask.jsp" class="btn"
				style="width: 65px; background-color: #7c78c0; color: white;">추가</a>&nbsp;
		</div>
		<hr />

		<!-- DB에서 불러오도록 변경 -->
		<div class="d-flex p-1 align-items-center" style="height: 70px;">
			<span class="d-block text-center"><strong>'요구사항 분석'</strong><br>
				<span class="d-block mt-1 rounded-pill text-center"
				style="background-color: rgb(233, 231, 231); width: 200px;">
				by 2022/11/27 </span>
			</span>
			<details class="d-flex ps-2" style="width: 200px; height: 30px;">
				<summary>DETAIL</summary>
				<span class="p-2 rounded-3"
					style="width: 190px; height: 65px; background-color: black; color: white; margin-left: 80px; margin-top: -40px;">
					요구사항 명세서 작성하고 파일 제출하기 </span>
			</details>
			<span class="rounded-pill" style="margin-left: auto;">
				<strong>- 정유영&nbsp;</strong>
			</span>
		</div>
		<hr />
		
		<div class="d-flex p-1 align-items-center" style="height: 70px;">
			<span class="d-block text-center"><strong>'데이터베이스 설계'</strong><br>
				<span class="d-block mt-1 rounded-pill text-center"
				style="background-color: rgb(233, 231, 231); width: 200px;">
				by 2022/10/15</span>
			</span>
			<details class="d-flex ps-2" style="width: 200px; height: 30px;">
				<summary>DETAIL</summary>
				<span class="p-2 rounded-3"
					style="width: 190px; height: 65px; background-color: black; color: white; margin-left: 80px; margin-top: -40px;">
					ERWIN 모델링 시작하기</span>
			</details>
			<span class="rounded-pill" style="margin-left: auto;">
				<strong>- 심재현&nbsp;</strong>
			</span>
		</div>
		<hr />
		
		<div class="d-flex p-1 align-items-center" style="height: 70px;">
			<span class="d-block text-center"><strong>'MVC 구조 설계'</strong><br>
				<span class="d-block mt-1 rounded-pill text-center"
				style="background-color: rgb(233, 231, 231); width: 200px;">
				by 2022/11/08</span>
			</span>
			<details class="d-flex ps-2" style="width: 200px; height: 30px;">
				<summary>DETAIL</summary>
				<span class="p-2 rounded-3"
					style="width: 190px; height: 65px; background-color: black; color: white; margin-left: 80px; margin-top: -40px;">
					엑셀 파일 만들고 노션에 공유하기</span>
			</details>
			<span class="rounded-pill" style="margin-left: auto;">
				<strong>- 이송희&nbsp;</strong>
			</span>
		</div>
		<hr />
		
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
			<span class="rounded-pill" style="margin-left: auto;">
				<strong>- 서한나&nbsp;</strong>
			</span>
		</div>
		<hr />
		
		<div class="d-flex p-1 align-items-center" style="height: 70px;">
			<span class="d-block text-center"><strong>'요구사항 분석'</strong><br>
				<span class="d-block mt-1 rounded-pill text-center"
				style="background-color: rgb(233, 231, 231); width: 200px;">
				by 2022/11/27 </span>
			</span>
			<details class="d-flex ps-2" style="width: 200px; height: 30px;">
				<summary>DETAIL</summary>
				<span class="p-2 rounded-3"
					style="width: 190px; height: 65px; background-color: black; color: white; margin-left: 80px; margin-top: -40px;">
					요구사항 명세서 작성하고 파일 제출하기 </span>
			</details>
			<span class="me-2" style="margin-left: auto;">
				<button class=" btn btn-outline-dark rounded-circle" type="button" onclick="location.href='updateTask.jsp';">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16" style="margin-bottom: 5px;">
					  <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
					  <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
					</svg>
				</button>
			</span>
		</div>
		<hr />
		
		<div class="d-flex p-1 align-items-center" style="height: 70px;">
			<span class="d-block text-center"><strong>'데이터베이스 설계'</strong><br>
				<span class="d-block mt-1 rounded-pill text-center"
				style="background-color: rgb(233, 231, 231); width: 200px;">
				by 2022/10/15</span>
			</span>
			<details class="d-flex ps-2" style="width: 200px; height: 30px;">
				<summary>DETAIL</summary>
				<span class="p-2 rounded-3"
					style="width: 190px; height: 65px; background-color: black; color: white; margin-left: 80px; margin-top: -40px;">
					ERWIN 모델링 시작하기</span>
			</details>
			<span class="me-2" style="margin-left: auto;">
				<button class=" btn btn-outline-dark rounded-circle" type="button" onclick="location.href='updateTask.jsp';">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16" style="margin-bottom: 5px;">
					  <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
					  <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
					</svg>
				</button>
			</span>
		</div>
		<hr />
		
		<div class="d-flex p-1 align-items-center" style="height: 70px;">
			<span class="d-block text-center"><strong>'MVC 구조 설계'</strong><br>
				<span class="d-block mt-1 rounded-pill text-center"
				style="background-color: rgb(233, 231, 231); width: 200px;">
				by 2022/11/08</span>
			</span>
			<details class="d-flex ps-2" style="width: 200px; height: 30px;">
				<summary>DETAIL</summary>
				<span class="p-2 rounded-3"
					style="width: 190px; height: 65px; background-color: black; color: white; margin-left: 80px; margin-top: -40px;">
					엑셀 파일 만들고 노션에 공유하기</span>
			</details>
			<span class="me-2" style="margin-left: auto;">
				<button class=" btn btn-outline-dark rounded-circle" type="button" onclick="location.href='updateTask.jsp';">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16" style="margin-bottom: 5px;">
					  <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
					  <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
					</svg>
				</button>
			</span>
		</div>
		<hr />
		
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
				<button class=" btn btn-outline-dark rounded-circle" type="button" onclick="location.href='updateTask.jsp';">
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