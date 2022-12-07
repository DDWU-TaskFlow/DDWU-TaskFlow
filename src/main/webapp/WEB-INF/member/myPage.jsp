<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>myPage</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/album/">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap">
    
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

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

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    <!-- Custom styles for this template -->
    <link href="myPage.jsp" rel="stylesheet">
    
<script>
function update() {
	form.submit();
	document.location.href="/taskflow/member/mypage";
}
</script>
  </head>
  <body class="bg-light">
  <form name="form" method="POST" action="/taskflow/member/mypage">  <!-- action="<c:url value='/member/myPage'/>" -->
    
<div class="container">
    <main>
        <div class="row g-5">
            <div class="col-md-7 col-lg-8">

                <!-- 상단 바 My Page -->
                <div class="pt-5 text-center">
                    <header class="d-flex flex-wrap justify-content-center pt-3 mb-4">
                        <a href="myPage.jsp"
                            class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                            <!-- <svg class="bi me-2" width="5" height="32">
                                <use xlink:href="#bootstrap" />
                            </svg> -->
                            <span class="fs-4">
                                <p style="font-size: 40px; text-shadow: 1px 1px 5px rgb(197, 135, 226); font-weight: bold; color:rgb(192, 86, 224);">My Page</p>
                            </span>
                        </a>
                    </header>
                </div>

                <hr class="my-4">

				<!--
                <form class="needs-validation" method="POST" action="<c:url value'/taskflow/member/mypage'/>">
                -->
                    <div class="row g-3">

                        <!-- Member Id 확인(읽기 전용) -->
                        <div class="col-12">
                            <label for="member_id" class="form-label">Member Id <span class="text-muted">(Read Only)</span></label>
                            <input type="text" class="form-control" name="user_name" value="${member.user_name}" readonly="readonly">
                        </div>

                        <!-- New Password -->
                        <div class="col-sm-6">
                            <label for="newPassword" class="form-label">New Password</label>
                            <input type="text" class="form-control" name="newPassword" placeholder="" value="">
                        </div>
    
                        <!-- Confirm New Password -->
                        <div class="col-sm-6">
                            <label for="confirmPassword" class="form-label">Confirm New Password</label>
                            <input type="text" class="form-control" name="confirmPassword" placeholder="" value="">
                        </div>
    
                        <!-- Name -->
                        <div class="col-12">
                            <label for="name" class="form-label">Name</label>
                            <div class="input-group has-validation">
                                <span class="input-group-text">#</span>
                                <input type="text" class="form-control" name="name" value="${member.name }" placeholder="Your name">
                            </div>
                        </div>
    
                        <!-- Email -->
                        <div class="col-12">
                            <label for="email" class="form-label">Email</label>
                            <input type="text" class="form-control" name="email" value="${member.email }" placeholder="jisoo95@naver.com">
                        </div>
    
                        <!-- Phone-->
                        <div class="col-12">
                            <label for="phone" class="form-label">Phone</label>
                            <input type="text" class="form-control" name="phone" value="${member.phone }" placeholder="010-0000-0000">
                        </div>
    
                        <!-- Birthday -->
                        <div class="col-12">
                            <label for="address2" class="form-label">Birthday</label>
                            <form>
                                <p><input type="date" value="${member.birth }"></p>
                            </form>
                        </div>
                    </div>
    
                    <hr class="my-4">

                    <div class="find-btn">
                 
                    
                        <button type="submit" class="btn btn-primary btn-lg px-4 gap-3" 
                        	style="background-color: rgb(161, 162, 207); border: 0; outline: 0;"
                        	value="Update">Update</button>
                        <button class="btn btn-outline-secondary btn-lg px-4" type="reset">Cancel</button>
                    
                    </div>
            </div>
        </div>
    </main>
</div>

      </form>
  </body>
</html>