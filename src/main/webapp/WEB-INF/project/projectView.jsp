<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>
<!doctype html>
<html lang="en">

<head>
  <meta charset="UTF-8">
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
  
  <script>
  function searchMem() {
  	$('[id^=key]').css(
			{'background-color':'rgba(161,162,211,0.0)', 'transition':'0.5s'}
  	);
  	var memName = document.getElementById("keyword").value;
	$('[id*='+memName+']').css(
			{'background-color':'rgba(161,162,211,0.5)', 'transition':'0.3s'}
  	);
	
  	if (document.getElementById("key" + memName) != null) {
  		document.getElementById("searchBtn").href="#key"+memName;
  	}
  }
  </script>
  
  <script>
  <%String msg_success = request.getParameter("msg");
  	String is_insert = request.getParameter("is_insert");
   	if(msg_success != null && is_insert != null) {
   		int msg = Integer.parseInt(msg_success);
   		int insert = Integer.parseInt(is_insert);%>
		const params = new URL(location.href).searchParams;
		const project_id = params.get('projectId');
		const url = location.pathname + "?step=1&&projectId="+project_id;
		<%if (msg == 1 && insert == 1) {%>
   	   		alert("메세지가 추가됐습니다.");
   		<%}
   		else if (msg == 1 && insert == 0) {%>
   			alert("메세지가 삭제됐습니다.");
   		<%}%>
		history.replaceState({}, '', url);
	<%}%>
  </script>

</head>


<body class="bg-light" style="overflow-y: hidden;">
  <!-- 상단바(DB 연결) -->
  <!-- background-image: radial-gradient(circle at 15%, #A1A2D3 5%, #FFFFFF 20%, #A1A2D3); -->
  <nav class="navbar fixed-top navbar-dark border border-1 border-dark rounded mx-auto" aria-label="Main navigation" style="background-color: ${project.color}; width: 90%; height: 120px; max-width: 1300px; margin-top: 50px;">
      	<div class="container-fluid justify-content-between" style="margin-top: 10px;">

      <p style="text-shadow: 1px 1px 5px #000; margin-left: 10%;">
        <a class="navbar-brand fs-2" href="../index.jsp">Task Flow</a><br/>
        <a class="fs-5 ms-1" href="#" onclick="location.reload()" style="color: rgba(255, 255, 255, 0.863); text-decoration: none;">${project.name}</a>
      </p>
      <c:if test="${userId == project.leader_id}">
	      <a href="<c:url value='/project/update'>
		      		 <c:param name="userId" value="${userId}" />
		      		 <c:param name="projectId" value="${project.project_id}"/>
	      		   </c:url>" style="float: right;">
	        <div class="d-flex justify-content-center align-items-center border border-secondary rounded-circle" style="width: 40px; height: 40px; margin-top: -10px; margin-right: 100px; float: right;">
	          <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="rgb(255, 255, 255)" class="bi bi-gear-fill" viewBox="0 0 16 16">
	            <path d="M9.405 1.05c-.413-1.4-2.397-1.4-2.81 0l-.1.34a1.464 1.464 0 0 1-2.105.872l-.31-.17c-1.283-.698-2.686.705-1.987 1.987l.169.311c.446.82.023 1.841-.872 2.105l-.34.1c-1.4.413-1.4 2.397 0 2.81l.34.1a1.464 1.464 0 0 1 .872 2.105l-.17.31c-.698 1.283.705 2.686 1.987 1.987l.311-.169a1.464 1.464 0 0 1 2.105.872l.1.34c.413 1.4 2.397 1.4 2.81 0l.1-.34a1.464 1.464 0 0 1 2.105-.872l.31.17c1.283.698 2.686-.705 1.987-1.987l-.169-.311a1.464 1.464 0 0 1 .872-2.105l.34-.1c1.4-.413 1.4-2.397 0-2.81l-.34-.1a1.464 1.464 0 0 1-.872-2.105l.17-.31c.698-1.283-.705-2.686-1.987-1.987l-.311.169a1.464 1.464 0 0 1-2.105-.872l-.1-.34zM8 10.93a2.929 2.929 0 1 1 0-5.86 2.929 2.929 0 0 1 0 5.858z"/>
	          </svg>
	        </div>
	      </a>
      </c:if>
      </div>
  </nav>
<main class="container align-items-center">


  <div class="p-3 bg-body rounded mx-auto" style="margin-top: 200px; width: 100%; height: 510px; overflow-y: auto;">
  
  	  <!-- task/history buttons -->
	  <div class="d-flex my-4 ms-5 justify-content-center">
	    <button class="btn btn-outline-warning rounded-pill" style="width: 150px; height: 40px; color: black; font-size: large;" data-bs-toggle="offcanvas"
	            id="taskListBtn" value="${project.project_id}" data-bs-target="#offcanvasTaskList" aria-controls="offcanvasRight">Task</button>
	    <span style="width: 5px; margin-left: 30px;"></span>
	    <button class="btn btn-outline-warning rounded-pill" style="width: 150px; height: 40px; color: black; font-size: large;" data-bs-toggle="offcanvas"
	            id="historyBtn" data-bs-target="#offcanvasHistory" aria-controls="offcanvasRight">History</button>
	  </div>
	  
	  
	  <!-- Member List -->
	  <div class="align-self-center ms-5">
	
<%!
	/* Progress bar 색상 배열 선언 */
	String[] colors = { "f5b6c4", "c6b0f8", "b3c7ff", "A1A2D3" };
	int count = 1;
%>

	<c:set var="proId" value="${project.project_id}" />
	<c:forEach var="member" items="${memberList}">
		<c:set var="memId" value="${member.member_id}" />
		<c:set var="memProgress"  value="${taskManager.getMemberProgress(proId, memId)}" />
<% count++; %>

	    <div class="container row justify-content-center" style="vertical-align: middle;">
	      <div class="d-flex pt-4" style="width: 120px;">
	        <p class="pb-4 mb-0 fs-5 border-bottom">
	          <strong class="d-block" id="key${member.name}">
	          <c:if test="${member.member_id == project.leader_id}">
	          	<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="rgb(240,150,0)" class="bi bi-star" viewBox="0 1 16 16" style="margin-left: -25px; margin-top: -20px" 
	          		data-toggle="tooltip" data-bs-placement="left" title="팀장<c:if test="${not empty project.notice}">의 공지 : ${project.notice}</c:if>">
	              <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
	            </svg>&nbsp;</c:if>${member.name}</strong>
	        </p>
	      </div>
	      <div class="col-lg-8 align-self-center">
	        <button class="btn" style="width: 100%;" data-bs-toggle="offcanvas" data-bs-target="#offcanvas<%=count%>">
	          <div class="progress" style="height: 35px; border: solid 1px #<%=colors[count % colors.length] %>;">
	            <div class="progress-bar progress-bar-striped" role="progressbar" style="width: ${memProgress}%; height: 35px; background-color: #<%=colors[count % 4] %>;"
	                aria-valuenow="${memProgress}" aria-valuemin="0" aria-valuemax="100">${memProgress}%</div>
	          </div>
	        </button>
	      </div>
	    </div>
	
		  <!-- toggle task by member -->
		  <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvas<%=count%>" aria-labelledby="offcanvasRightLabel" style="width: 550px;" data-bs-backdrop="false">
		    <div class="offcanvas-header" style="height: 70px;">
		      <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		      <div class="d-flex justify-content-center"><p class="my-4 fs-5">TASK with COMMENTs</p></div>
		      <div></div>
		    </div>
			<!-- 상단바 -->
			<div class="ps-4 pe-4 pt-2">
				<div style="float: left;">
					<a href="<c:url value="/task/create" >
								<c:param name="projectId" value="${proId}" />
							</c:url>" class="btn" style="width: 65px; background-color: #7c78c0; color: white;">추가</a>&nbsp;
				</div>
				<!-- 정렬 -->
				<div class="form-group d-flex flex-row-reverse">
				  <select class="form-select" style="width: 100px;">
				        <option value="${member.member_id}" selected>${member.name}</option>
			      </select>
				</div>
			</div>
			<hr />
		    <div class="offcanvas-body" id="task_member">
		      <!-- import taskView.jsp -->
		      <c:import url="../task/taskView.jsp">
		      	<c:param name="project" value="${project}" />
		      	<c:param name="memberId" value="${memId}" />
      			<c:param name="taskManager" value="${taskManager}" />
      			<c:param name="commentManager" value="${commentManager}" />
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
	     <c:if test="${userId != project.leader_id}">
	       <li class="nav-item">
	         <button class="btn btn-outline-danger" onClick='location.href="<c:url value='/project/out'> <c:param name="userId" value="${userId}" /><c:param name="project_id" value="${project.project_id}" /></c:url>"' >프로젝트 나가기</button>
	       </li>
	     </c:if>
	       <li class="nav-item" style="margin-left: 10px;">
	         <a class="nav-link active" aria-current="page" href="#" onclick="location.reload()">        
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-clockwise" viewBox="0 0 16 16">
				  <path fill-rule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z"/>
				  <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z"/>
				</svg>&nbsp;새로고침
			</a>
	       </li>
	     </ul>
	     <form class="d-flex" onsubmit="return false;">
	       <input class="me-2" id="keyword" type="text" placeholder=" 팀원 검색 " style="width: 150px;">
	       <a class="btn btn-outline-success" id="searchBtn" onClick="searchMem();">Search</a>
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
		<!-- 상단바 -->
		<div class="ps-4 pe-4 pt-2">
			<div style="float: left;">
				<a href="<c:url value="/task/create" >
							<c:param name="projectId" value="${proId}" />
						</c:url>" class="btn" style="width: 65px; background-color: #7c78c0; color: white;">추가</a>&nbsp;
			</div>
			<!-- 정렬 -->
			<div class="form-group d-flex flex-row-reverse">
			  <select class="form-select" id="sortListSelect" style="width: 100px;">
			    <option value="nam" selected>이름순</option>
			    <option value="dead">기한순</option>
			    <option value="mem">팀원별</option>
			    <option value="prog">진행순</option>
			  </select>
			</div>
		</div>
		<hr />
		<!-- 로딩중 -->
		<div class="d-flex justify-content-center" style="display: none;">
		  <div class="spinner-border m-5" role="status" id="spinnerTask">
		    <span></span>
		  </div>
		</div>
    <div class="offcanvas-body" id="task">
      <!-- import taskList.jsp -> AJAX로 처리!! -->
      <%-- <c:import url="../task/taskList.jsp">
      	<c:param name="projectId" value="${proId}" />
      	<c:param name="taskManager" value="${taskManager}" />
      </c:import> --%>
    </div>
  </div>
	
  <!-- toggle history -->
  <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasHistory" aria-labelledby="offcanvasRightLabel" style="width: 550px;">
    <div class="offcanvas-header" style="height: 70px;">
      <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      <div class="d-flex justify-content-center"><p class="my-4 fs-5">HISTORY</p></div>
      <div></div>
    </div>
    <!-- 상단바 -->
	<div class="ps-4 pe-4 pt-2">
	    <div style="float: left;">
	     <!--  <a href="#" class="btn rounded-pill" style="width: 80px; background-color: #b3c7ff;">진행률</a>&nbsp;
	      <a href="#" class="btn rounded-pill" style="width: 80px; background-color: #b3c7ff;">스레드</a> -->
	    </div>
	    <div class="form-group d-flex flex-row-reverse">
	      <select class="form-select" id="sortHistorySelect" style="width: 100px;">
	        <option value="all" selected>전체</option>
			<c:forEach var="member" items="${memberList}">
		        <option value="${member.member_id}">${member.name}</option>
		    </c:forEach>
	      </select>
	    </div>
    </div>
    <hr/>
	<!-- 로딩중 -->
	<div class="d-flex justify-content-center" style="display: none;">
	  <div class="spinner-border m-5" role="status" id="spinnerHistory">
	  </div>
	</div>
    <div class="offcanvas-body" id="history">
      <!-- import history.jsp -> AJAX로 처리!! -->
     <%--   <c:import url="./history.jsp">
       	 <c:param name="projectId" value="${proId}" />
      	 <c:param name="memberList" value="${memberList}" />
      	 <c:param name="historyManager" value="${historyManager}" />
      </c:import> --%>
    </div>
  </div>

</main>

<script type="text/javascript">
  $(document).on('click', "#taskListBtn", function(){
	  var proId = $("#taskListBtn").val();
      $.ajax({
          type : "get",
          url : "/taskflow/task/list?option=nam",
          dataType : "html",
          data : { "projectId" : proId },
          error : function(){
              alert("taskList 불러오기를 실패했습니다.");
          },
          complete : function(){
        	  $("#spinnerTask").css("display", "none");  
          },
          success : function(Parse_data){
              $("#task").html(Parse_data);
          }
      });
  });

  $(document).on('click', "#historyBtn", function(){
	  var proId = $("#taskListBtn").val();
      $.ajax({
          type : "get",
          url : "/taskflow/history/list?option=all",
          dataType : "html",
          data : { "projectId" : proId },
          error : function(){
              alert("history 불러오기를 실패했습니다.");
          },
          complete : function(){
        	  $("#spinnerHistory").css("display", "none");  
          },
          success : function(Parse_data){
              $("#history").html(Parse_data);
          }
      });
  });

   $(document).on('change', "#sortListSelect", function() {
   	 var opt = $("#sortListSelect option:selected").val();
  	 	 var proId = $("#taskListBtn").val();
   	 $.ajax({
            type : "get",
            url : "/taskflow/task/list?option="+opt,
            dataType : "html",
            data : { "projectId" : proId },
            error : function(){
                alert("taskList 불러오기를 실패했습니다.");
            },
            complete : function(){
          	  $("#spinnerTask").css("display", "none");  
            },
            success : function(Parse_data){
                $("#task").html(Parse_data);
            }
        });
	});
   
   $(document).on('change', "#sortHistorySelect", function() {
   	 var opt = $("#sortHistorySelect option:selected").val();
  	 	 var proId = $("#taskListBtn").val();
   	 $.ajax({
            type : "get",
            url : "/taskflow/history/list?option="+opt,
            dataType : "html",
            data : { "projectId" : proId },
            error : function(){
                alert("history 불러오기를 실패했습니다.");
            },
            complete : function(){
          	  $("#spinnerHistory").css("display", "none");  
            },
            success : function(Parse_data){
                $("#history").html(Parse_data);
            }
        });
	});
</script>

</body>

</html>
