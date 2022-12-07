<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.84.0">
  <title>Task Flow</title>

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

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
    .container {
      margin:auto;
    }
    .clrcle {
      width:500px;
      height:500px;
      border-radius: 50%;
      background: #808080;
      text-align: center;
    }
    .card-text {
      text-align: right;
    }
  </style>
  
</head>


<body>

<main>

  <!-- 상단 Task Flow, member, project 생성 아이콘 
  <section class="container py-5" style="height: 250px;">
    <div class="container-fluid text-center" style="margin-top: 10px; width: 400px; height: 100px;">
      <a href="index.jsp" style="color:rgb(192, 86, 224); display: block;">
        <p style="font-size: 70px; text-shadow: 1px 1px 5px rgb(197, 135, 226); font-weight: bold;">Task Flow</p>
      </a>
    </div>
  </section>-->

  <!-- 프로젝트 -->
  <div class="container align-items-center" style="max-width: 1130px;">
  
  <div class="row justify-content-center">
  
    <!-- 로그인 -->
    <div class="card border-dark mb-3" style="width: 350px; height: 200px;">
    <div class="card-body">
      <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">
        <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7Zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216ZM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z"/>
      </svg>
      <h4 class="card-title"><a class="card-title" href="<c:url value='/member/login/form' />">로그인</a></h4>
      <div style="height: 50px;"></div>
      <div class="progress" style="height: 25px;">
        <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 100%; height: 25px; background-color: #b3c7ff;"
            aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">
        </div>
      </div>
    </div>
    </div>
    
    <div style="width: 25px;"></div>
    

    <!-- 회원가입 -->
    <div class="card border-dark mb-3" style="width: 350px; height: 200px;">
    <div class="card-body">
      <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">
        <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7Zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216ZM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z"/>
      </svg>
      <h4 class="card-title"><a class="card-title" href="<c:url value='/member/join' />">회원가입</a></h4>
      <div style="height: 50px;"></div>
      <div class="progress" style="height: 25px;">
        <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 100%; height: 25px; background-color: #A1A2D3;"
            aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">
        </div>
      </div>
    </div>
    </div>

    
  </div>
    
</div>

</main>

</body>
</html>