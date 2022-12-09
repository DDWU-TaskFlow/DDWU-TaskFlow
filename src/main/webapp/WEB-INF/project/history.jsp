<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.84.0">
  <title>history.jsp</title>

</head>


<body class="bg-light">

	<div class="ps-2 bg-body rounded shadow-sm">

    <!-- 상단바 -->
    <div style="float: left;">
      <a href="#" class="btn rounded-pill" style="width: 80px; background-color: #b3c7ff;">진행률</a>&nbsp;
      <a href="#" class="btn rounded-pill" style="width: 80px; background-color: #b3c7ff;">스레드</a>
    </div>
    <div class="form-group d-flex flex-row-reverse">
      <select class="form-select" id="exampleSelect1" style="width: 100px;">
        <option selected>전체</option>
        <option>이송희</option>
        <option>심재현</option>
        <option>정유영</option>
        <option>서한나</option>
      </select>
    </div>
    <hr/>
	
	<c:set var="proId" value="${param.projectId}" />
	<c:set var="historyList" value="${historyManager.findHistoryByProjectId(proId)}" />
	
	<!-- 히스토리가 없을 경우 -->
	<c:if test="${empty historyList}">
		<div class="d-flex p-1 align-items-center justify-content-center" style="height: 70px;">
			<span class="d-block text-center">
				 히스토리가 없습니다. 활동을 시작해보세요.
			</span>
		</div>
	</c:if>
	
	<c:forEach var="history" items="${historyList}">
		<c:set var="hisId" value="${history.historyId}" />
	    <div class="d-flex pt-3">
	      <p>
	        <span class="d-block rounded-pill text-center" style="background-color: rgb(233, 231, 231); width: 485px;">
	        	<fmt:formatDate value="${history.recordedDate}" type="both" pattern="YYYY/MM/dd HH:mm" />
	        </span>
	        <span class="d-block rounded-pill ps-3 pt-3"><strong>&nbsp;${historyManager.findMemberNameByHistoryId(hisId)}&nbsp;</strong></span>
	        <span class="d-block rounded-pill ps-3 pt-1">${history.content}</span>
	      </p>
	    </div>
	    <hr/>
	</c:forEach>
    
	<div style="height: 20px;"></div>
	
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
