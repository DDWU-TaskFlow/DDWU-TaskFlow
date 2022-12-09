<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.84.0">
<title>프로젝트 입장</title>

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

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

.find-btn {
	text-align: center;
	display: inline-block;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>

<!-- Custom styles for this template -->
<link href="form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container">
		<main>
			<div class="row g-5">
				<div class="col-md-7 col-lg-8">

					<!-- 상단 바 Create Project-->
					<div class="pt-5 text-center">
						<header class="d-flex flex-wrap justify-content-center pt-3 mb-4">
							<a href="createProject.jsp"
								class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
								<svg class="bi me-2" width="5" height="32">
                                <use xlink:href="#bootstrap" />
                            </svg> <span class="fs-4">
									<p
										style="font-size: 40px; text-shadow: 1px 1px 5px rgb(197, 135, 226); font-weight: bold; color: rgb(192, 86, 224);">
										Join Project</p>
							</span>
							</a>
						</header>
						<hr class="my-4" style="width: 75%;">
					</div>

					<form class="needs-validation" action="/taskflow/project/join"
						method="post">
						<div class="row g-3">

							<!-- Team Color -->
							<!--                         <div class="col-sm-2">
                            <label for="exampleColorInput" class="form-label">Team Color</label>
                            <input type="color" name="color" class="form-control form-control-color" id="exampleColorInput"
                                value="#563d7c" title="Choose your color">
                        </div> -->

							<!-- Project Name -->
							<!-- <div class="col-sm-5" style="margin-left: 16.5%;">
								<label for="projectName" class="form-label">Project Name</label>
								<div class="input-group has-validation">
									<span class="input-group-text">#</span> <input type="text"
										name="name" class="form-control w-25" size="10"
										id="projectName" placeholder="Your project name" required>

									<div class="invalid-feedback">Your project name is
										required.</div>
								</div>

							</div> -->

							<!-- Notice -->
							<div class="col-sm-9">
								<label for="notice" class="form-label">Join Code</label> <input
									type="notice" name="code" class="form-control" id="notice"
									placeholder="초대 코드를 입력해주세요.">
							</div>
						</div>

						<!-- Join 실패한 경우 메시지를 출력 -->
						<c:if test="${joinFailed}">
							<div class="col-lg-12">
								<h6 class="text-danger" style="height: 20px;">
									<p></p>
									<p> 초대 코드를 다시 입력해주세요.</p>
								</h6>
							</div>
						</c:if>


						<hr class="my-4" style="width: 75%;">

						<div class="find-btn">
							<button class="btn btn-primary btn-lg px-4 gap-3" type="submit"
								style="background-color: rgb(161, 162, 207); border: 0; outline: 0;">Join</button>
							<button class="btn btn-outline-secondary btn-lg px-4"
								type="reset" onclick="location.href='/taskflow/project/list';">Cancel</button>
						</div>
					</form>
				</div>
			</div>
		</main>
	</div>
	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

	<script src="form-validation.js"></script>
</body>
</html>