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


	  <%String success = request.getParameter("success");
	  if (success != null) {
		  if(success.equals("0")) {%>
			    alert("전송 실패했습니다.");
		  <%}
		  else {%>
		  		alert("전송 성공했습니다.");
		  <%}
	  }%>
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
		<form method="POST" name="form">
		<input type="hidden" name="project_id" value="${project.project_id}"> <!-- 값 저장을 위함 -->
		<input type="hidden" name="member_list" value="${memberList}">
		<input type="hidden" name="leader_id" value="${project.leader_id}">
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
		  &nbsp;&nbsp;<textarea name="notice" id="notice" cols="60" rows="2">${project.notice}</textarea> 
		  <button class="btn btn-outline-secondary" type="submit" style="width: 62px;" onclick="javascript: form.action='/taskflow/project/sendMessage';">
			<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-telegram" viewBox="0 0 16 16">
			  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.287 5.906c-.778.324-2.334.994-4.666 2.01-.378.15-.577.298-.595.442-.03.243.275.339.69.47l.175.055c.408.133.958.288 1.243.294.26.006.549-.1.868-.32 2.179-1.471 3.304-2.214 3.374-2.23.05-.012.12-.026.166.016.047.041.042.12.037.141-.03.129-1.227 1.241-1.846 1.817-.193.18-.33.307-.358.336a8.154 8.154 0 0 1-.188.186c-.38.366-.664.64.015 1.088.327.216.589.393.85.571.284.194.568.387.936.629.093.06.183.125.27.187.331.236.63.448.997.414.214-.02.435-.22.547-.82.265-1.417.786-4.486.906-5.751a1.426 1.426 0 0 0-.013-.315.337.337 0 0 0-.114-.217.526.526 0 0 0-.31-.093c-.3.005-.763.166-2.984 1.09z"/>
			</svg>
	  	  </button>
		</div>
		
		<div>
			<b>프로젝트</b>
			&nbsp;&nbsp;<span><a href="<c:url value='/project/delete'> <c:param name="project_id" value="${project.project_id}" /></c:url>">삭제</a></span>
		</div> 
		
		<br>
		<br>
		<div>
		<button class="btn btn-primary btn-lg px-4 gap-3" type="submit" onclick="javascript: form.action='/taskflow/project/update';"
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