<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">

<head>
  <meta charset="EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.84.0">

  <title> ${project.name} </title>

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

  <!-- toggle tooltip -->
  <script>
    $(document).ready(function(){
      $('[data-toggle="tooltip"]').tooltip();   
    });
  </script>
  
</head>


<body class="bg-light" style="overflow-y: hidden;">

  <!-- 상단바, project.name 변경 예정 (DB 연결) -->
  <!-- background-image: radial-gradient(circle at 15%, #A1A2D3 5%, #FFFFFF 20%, #A1A2D3); -->
  <nav class="navbar fixed-top navbar-dark border border-2 border-dark rounded mx-auto" aria-label="Main navigation" style="background-color: #A1A2D3; width: 90%; height: 120px; max-width: 1300px; margin-top: 50px;">
    <div class="container-fluid justify-content-between" style="margin-top: 10px;">
      <p style="text-shadow: 1px 1px 5px #000; margin-left: 10%;">
        <a class="navbar-brand fs-2" href="../index.jsp">Task Flow</a><br/>
        <a class="fs-5 ms-1" href="#" onclick="location.reload()" style="color: rgba(255, 255, 255, 0.863); text-decoration: none;">${project.name}</a>
      </p>
      <a href="<c:url value='/project/update/form' />" style="float: right;">
        <div class="d-flex justify-content-center align-items-center border border-secondary rounded-circle" style="width: 40px; height: 40px; margin-top: -10px; margin-right: 100px; float: right;">
          <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="rgb(255, 255, 255)" class="bi bi-gear-fill" viewBox="0 0 16 16">
            <path d="M9.405 1.05c-.413-1.4-2.397-1.4-2.81 0l-.1.34a1.464 1.464 0 0 1-2.105.872l-.31-.17c-1.283-.698-2.686.705-1.987 1.987l.169.311c.446.82.023 1.841-.872 2.105l-.34.1c-1.4.413-1.4 2.397 0 2.81l.34.1a1.464 1.464 0 0 1 .872 2.105l-.17.31c-.698 1.283.705 2.686 1.987 1.987l.311-.169a1.464 1.464 0 0 1 2.105.872l.1.34c.413 1.4 2.397 1.4 2.81 0l.1-.34a1.464 1.464 0 0 1 2.105-.872l.31.17c1.283.698 2.686-.705 1.987-1.987l-.169-.311a1.464 1.464 0 0 1 .872-2.105l.34-.1c1.4-.413 1.4-2.397 0-2.81l-.34-.1a1.464 1.464 0 0 1-.872-2.105l.17-.31c.698-1.283-.705-2.686-1.987-1.987l-.311.169a1.464 1.464 0 0 1-2.105-.872l-.1-.34zM8 10.93a2.929 2.929 0 1 1 0-5.86 2.929 2.929 0 0 1 0 5.858z"/>
          </svg>
        </div>
      </a>
     </div>
  </nav>

<main class="container align-items-center">

  <div class="p-3 bg-body rounded mx-auto" style="margin-top: 200px; width: 100%; height: 510px; overflow-y: auto;">
  
  	  <!-- task/history buttons -->
	  <div class="d-flex my-4 ms-5 justify-content-center">
	    <button class="btn btn-outline-warning rounded-pill" style="width: 150px; height: 40px; color: black; font-size: large;" data-bs-toggle="offcanvas"
	            data-bs-target="#offcanvasTaskList" aria-controls="offcanvasRight">Task</button>
	    <span style="width: 5px; margin-left: 30px;"></span>
	    <button class="btn btn-outline-warning rounded-pill" style="width: 150px; height: 40px; color: black; font-size: large;" data-bs-toggle="offcanvas"
	            data-bs-target="#offcanvasHistory" aria-controls="offcanvasRight">History</button>
	  </div>
	  
	  
	  <!-- Member List -->
	  <div class="align-self-center ms-5">
	
<%!
	/* Progress bar 색상 배열 선언 */
	String[] colors = { "c6b0f8", "b3c7ff", "A1A2D3", "f5b6c4" };
	int count = 0;
%>

	<c:set var="proId" value="${project.project_id}" />
	<c:forEach var="member" items="${memberList}">
		<c:set var="memId" value="${member.member_id}" />
		<c:set var="memProgress"  value="${taskManager.getMemberProgress(proId, memId)}" />
<% count++; %>

	    <div class="container row justify-content-center" style="vertical-align: middle;">
	      <div class="d-flex pt-4" style="width: 120px;">
	        <p class="pb-4 mb-0 fs-5 border-bottom">
	          <strong class="d-block">
	          <c:if test="${member.member_id == project.leader_id}">
	          	<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="rgb(240,150,0)" class="bi bi-star" viewBox="0 1 16 16" style="margin-left: -25px; margin-top: -20px" data-toggle="tooltip" data-bs-placement="left" title="팀장">
	              <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
	            </svg>&nbsp;</c:if>${member.name}</strong>
	        </p>
	      </div>
	      <div class="col-lg-8 align-self-center">
	        <a class="btn" href="#" style="width: 100%;" data-bs-toggle="offcanvas" data-bs-target="#offcanvas<%=count%>" >
	          <div class="progress" style="height: 35px; border: solid 1px #<%=colors[count % colors.length] %>;">
	            <div class="progress-bar progress-bar-striped" role="progressbar" style="width: ${memProgress}%; height: 35px; background-color: #<%=colors[count % 4] %>;"
	                aria-valuenow="${memProgress}" aria-valuemin="0" aria-valuemax="100">${memProgress}%</div>
	          </div>
	        </a>
	      </div>
	    </div>
	
		  <!-- toggle task by member -->
		  <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvas<%=count%>" aria-labelledby="offcanvasRightLabel" style="width: 550px;" data-bs-backdrop="false">
		    <div class="offcanvas-header" style="height: 70px;">
		      <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		      <div class="d-flex justify-content-center"><p class="my-4 fs-5">${member.name}</p></div>
		      <div></div>
		    </div>
		    <div class="offcanvas-body" id="task_member">
		      <!-- import taskView.jsp -->
		      <c:import url="../task/taskView.jsp">
		      	<c:param name="projectId" value="${proId}" />
		      	<c:param name="memberId" value="${memId}" />
		      </c:import>
		    </div>
		  </div>
	    
</c:forEach> 

	    <div style="height: 70px;"></div> 
  
	  </div>
  </div>
	
  	<!-- 하단바 -->
	<span class="d-flex justify-content-center" style="margin-top: 20px; color: lightgrey;">2022 DBP BAMANSAEJO</span>
	<nav class="navbar navbar-expand-lg navbar-light" style="margin-top: -35px;">
		<div class="container-fluid">
	     <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	       <li class="nav-item">
	       	<!-- onclink으로 구현 -->
	       	<!-- 팀장은 disabled 속성 주기 -->
	         <button class="btn btn-outline-danger">프로젝트 나가기</button>
	       </li>
	       <li class="nav-item" style="margin-left: 10px;">
	         <a class="nav-link active" aria-current="page" href="#" onclick="location.reload()">        
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-clockwise" viewBox="0 0 16 16">
				  <path fill-rule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z"/>
				  <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z"/>
				</svg>&nbsp;새로고침
			</a>
	       </li>
	     </ul>
	     <form class="d-flex">
	       	<!-- scroll link? 로 구현 -->
	       <input class="form-control me-2" type="search" placeholder="팀원 검색" aria-label="Search" style="width: 150px;">
	       <button class="btn btn-outline-success" type="submit">Search</button>
	     </form>
		</div>
	</nav>
	
	
  <!-- toggle task -->
  <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasTaskList" aria-labelledby="offcanvasRightLabel" style="width: 550px;">
    <div class="offcanvas-header" style="height: 70px;">
      <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      <div class="d-flex justify-content-center"><p class="my-4 fs-5">TASK</p></div>
      <div></div>
    </div>
    <div class="offcanvas-body" id="task">
      <!-- import taskList.jsp -->
      <c:import url="../task/taskList.jsp">
      	<c:param name="projectId" value="${proId}" />
      	<c:param name="taskManager" value="${taskManager}" />
      </c:import>
    </div>
  </div>
	
  <!-- toggle history -->
  <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasHistory" aria-labelledby="offcanvasRightLabel" style="width: 550px;">
    <div class="offcanvas-header" style="height: 70px;">
      <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      <div class="d-flex justify-content-center"><p class="my-4 fs-5">HISTORY</p></div>
      <div></div>
    </div>
    <div class="offcanvas-body" id="history">
      <!-- include history.jsp -->
      <jsp:include page="history.jsp" />
    </div>
  </div>
	

</main>

</body>
</html>
