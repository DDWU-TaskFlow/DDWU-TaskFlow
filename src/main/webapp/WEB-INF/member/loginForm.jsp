<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.84.0">

<title>로그인</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/offcanvas-navbar/">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap">
<!-- Bootstrap core CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<style>
* {
	font-family: 'Gowun Dodum', sans-serif;
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
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<script>
function login() {
	if (form.userName.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.userId.focus();
		return false;
	}
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}
	form.submit();
}
</script>

</head>
<body class="text-center">

	<div class="container">
		<!-- 상단 Task Flow -->
		<section class="container py-5" style="height: 250px;">
			<div class="container-fluid text-center"
				style="margin-top: 10px; width: 400px; height: 100px;">
				<a href="index.jsp"
					style="color: rgb(192, 86, 224); display: block;">
					<p style="font-size: 70px; text-shadow: 1px 1px 5px rgb(197, 135, 226); font-weight: bold;">Task Flow</p>
				</a>
			</div>
		</section>
	</div>
		<br> <br>
		<!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
		<!--  <div class="col-lg-12">
			<c:if test="${loginFailed}">
				<h6 class="text-danger">
					<c:out value="${exception.getMessage()}" />
				</h6>
			</c:if>
		</div>-->
		<!-- login form  -->
		<div class="d-flex row text-center justify-content-center" style="width: 100%">
			<form class="col-md-6 col-lg-6" name="form" method="POST" action="<c:url value='/member/login' />">
				<div class="d-flex justify-content-center">
					<div
						style="width: 150px; height: 40px; color: black; font-size: large;">ID</div>
					<div>
						<input type="text" name="userName" class="form-control"
							placeholder="사용자 ID">
					</div>
				</div>
				<div class="d-flex justify-content-center">
					<div
						style="width: 150px; height: 40px; color: black; font-size: large;">PW</div>
					<div>
						<input type="password" name="password" class="form-control"
							placeholder="비밀번호">
					</div>
				</div>
				<br>
				<br>
				<div class="find-btn">
					<input type="button" class="btn btn-primary btn-lg px-4 gap-3" 
								style="background-color: rgb(161, 162, 207); border: 0; outline: 0;"
								 value="로그인" onClick="login()">
					<div class="btn btn-outline-secondary btn-lg px-4" type="reset">
					<a href="<c:url value='/member/join' />">회원가입</a> </div>
				</div>
			</form>
		</div>
</body>
</html>
