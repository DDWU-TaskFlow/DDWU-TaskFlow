<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.84.0">
<title>myPage</title>

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
<script>
function memberCreate() {
	if (form.userName.value == "") {
		alert("����� ID�� �Է��Ͻʽÿ�.");
		form.userId.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("��й�ȣ�� �Է��Ͻʽÿ�.");
		form.password.focus();
		return false;
	}
	if (form.password.value != form.confirmPassword.value) {
		alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		form.name.focus();
		return false;
	}
	if (form.name.value == "") {
		alert("�̸��� �Է��Ͻʽÿ�.");
		form.name.focus();
		return false;
	}
	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(emailExp.test(form.email.value)==false) {
		alert("�̸��� ������ �ùٸ��� �ʽ��ϴ�.");
		form.email.focus();
		return false;
	}
	var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
	if(phoneExp.test(form.phone.value)==false) {
		alert("��ȭ��ȣ ������ �ùٸ��� �ʽ��ϴ�.");
		form.phone.focus();
		return false;
	}
	
	form.submit();
}
</script>
</head>
<body class="bg-light">

	<div class="container">
		<main>
			<div class="row g-5">
				<div class="col-md-7 col-lg-8">

					<!-- ��� �� Join -->
					<div class="pt-5 text-center">
						<header class="d-flex flex-wrap justify-content-center pt-3 mb-4">
							<a href="joinForm.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
								<svg class="bi me-2" width="5" height="32">
                                <use xlink:href="#bootstrap" />
                            </svg> <span class="fs-4">
									<p style="font-size: 40px; text-shadow: 1px 1px 5px rgb(197, 135, 226); font-weight: bold; color: rgb(192, 86, 224);">Join</p>
							</span>
							</a>
						</header>
					</div>

					<hr class="my-4">

					<form class="needs-validation" novalidate name="form" method="POST" action="<c:url value='/member/join'/>">
						<div class="row g-3">

							<!-- Member Id -->
							<div class="col-12">
								<label for="userName" class="form-label">Member Id</label> 
									<input type="text" class="form-control" id="userName" value="">
							</div>

							<!-- Password -->
							<div class="col-sm-6">
								<label for="password" class="form-label">Password</label>
								<input type="text" class="form-control" id="password" placeholder="" value="">
							</div>

							<!-- Confirm New Password -->
							<div class="col-sm-6">
								<label for="confirmPassword" class="form-label">Confirm Password</label> <input type="text" class="form-control"
									id="confirmPassword" placeholder="" value="">
							</div>

							<!-- Name -->
							<div class="col-12">
								<label for="name" class="form-label">Name</label>
								<div class="input-group has-validation">
									<span class="input-group-text">#</span> <input type="text"
										class="form-control" id="name" placeholder="Your name">
								</div>
							</div>

							<!-- Email -->
							<div class="col-12">
								<label for="email" class="form-label">Email</label> 
								<input type="text" class="form-control" id="email" placeholder="jisoo95@naver.com">
							</div>

							<!-- Phone-->
							<div class="col-12">
								<label for="phone" class="form-label">Phone</label> 
								<input type="text" class="form-control" id="phone" placeholder="010-0000-0000">
							</div>

							<!-- Birthday -->
							<div class="col-12">
								<label for="birthday" class="form-label">Birthday</label>
								<form> <p><input type="date" id="birthday"></p> </form>
							</div>
						</div>

						<hr class="my-4">

						<div class="find-btn">
							<button class="btn btn-primary btn-lg px-4 gap-3" onClick="memberCreate()"
								style="background-color: rgb(161, 162, 207); border: 0; outline: 0;">Join</button>
							<button class="btn btn-outline-secondary btn-lg px-4"
								type="reset">Cancel</button>
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