<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.84.0">

	<title>setting</title>

  <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/offcanvas-navbar/">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap">

  <!-- Bootstrap core CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" />

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

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
  </style>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
  <script>
	function clip() {
		var url = '';
		var textarea = document.createElement("textarea");
		document.body.appendChild(textarea);
		url = ''//window.document.location.href;
		textarea.value = url;
		textarea.select();
		document.execCommand("copy");
		document.body.removeChild(textarea);
		alert("초대링크가 복사되었습니다.")
	}

</script>
</head>


<body class="bg-light">


<main class="container align-items-center">
	  <!-- background-image: radial-gradient(circle at 15%, #A1A2D3 5%, #FFFFFF 20%, #A1A2D3); -->
	  <nav class="navbar fixed-top navbar-dark border border-2 border-dark rounded mx-auto" aria-label="Main navigation" style="background-color: #A1A2D3; width: 90%; height: 120px; max-width: 1300px; margin-top: 50px;">
	    <div class="container-fluid justify-content-between" style="margin-top: 10px;">
	      <p style="text-shadow: 1px 1px 5px #000; margin-left: 10%;">
	        <a class="navbar-brand fs-2" href="../index.jsp">TaskFlow</a><br/>
	        <a class="fs-5 ms-1" href='<c:url value='/project/projectView.jsp'/>' style="color: rgba(255, 255, 255, 0.863); text-decoration: none;">${project.name}</a>
	      </p>
	     </div>
	  </nav>
	    <div class="p-3 bg-body rounded mx-auto" style="margin-top: 200px; width: 100%; height: 510px; overflow-y: auto;">
		<div style="padding:80px;">
		<form method="POST" action="<c:url value='/project/update' />">
		<input type="hidden" name="project_id" value="${project.project_id}"> <!-- 값 저장을 위함 -->
		<input type="hidden" name="member_list" value="${memberList}">
		<div>
			<b>팀장 선택&nbsp;&nbsp;</b>
			    <select name="leader" id="leader_select">
				<c:forEach var="m" items="${memberList}">
			        <option>${m.name}</option>
			    </c:forEach> 
			    </select> 
		</div>
		<br>
		<div>
			<b>초대링크&nbsp;&nbsp;</b>
				<span class="button gray medium" ><a href="${project.createdLink}" onclick="clip(); return false;"> 복사</a></span>
		</div>
		<br>
		<div class="input-group mb-3">
		  <b>공지 발송</b>
		  &nbsp;&nbsp;<textarea name="notion" cols="60" rows="2"></textarea> <button type="button" style="width:30px; height:30px;"></button>
		</div>
		
		<div>
			<b>프로젝트</b>
			&nbsp;&nbsp;<span><a href="<c:url value='/project/delete'> <c:param name="project_id" value="${project.project_id}" /></c:url>">삭제</a></span>
		</div> 
		
		<br>
		<br>
		<div>
	        
		<button class="btn btn-primary btn-lg px-4 gap-3" type="submit" 
	     style="background-color: rgb(161, 162, 207); border: 0; outline: 0;">확인</button>
	     
		<button class="btn btn-primary btn-lg px-4 gap-3" type="reset" onClick="history.back()"
	     style="background-color: rgb(161, 162, 207); border: 0; outline: 0;">뒤로가기</button>
        </div>
		</form>
		</div>
	</div>     
  	<!-- 하단바 -->
	<span class="d-flex justify-content-center" style="margin-top: 20px; color: lightgrey;">2022 DBP BAMANSAEJO</span>
	
</main>

</body>
</html>