<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="EUC-KR">
<title>task by member</title>
</head>

<body class="bg-light">

	<div class="p-2 bg-body rounded shadow-sm">

		<!-- ��ܹ� -->
		<div style="float: left;">
			<a href="#" class="btn"
				style="width: 65px; background-color: #7c78c0; color: white;">��ư</a>&nbsp;
		</div>
		<!-- ���� (����, ���, �½�ũ) -->
		<div class="form-group d-flex flex-row-reverse">
		  <select class="form-select" id="exampleSelect1" style="width: 100px;">
		    <option selected>���Ѽ�</option>
		    <option>�����</option>
		  </select>
		</div>
		<hr />
		
		
		<!-- DB���� �ҷ������� ���� -->
		<div class="d-flex p-1 align-items-center justify-content-between" style="height: 100px;">
			<span class="d-flex justify-content-center" style="width: 160px;">
				<span class="d-block ps-3 pe-3 rounded-pill text-center"
					style="background-color: #fffacc;">
					<strong style="text-decoration: underline;">�䱸���� �м�</strong><br>by
					2022/11/27
				</span>
			</span>
			<span class="d-flex" style="width: 250px;">
				�䱸���� ���� �ۼ��ϰ� ��Ŭ������ �����ϱ�
			</span>
			<span class="d-flex justify-content-center" style="width: 80px;">
				<button class="d-flex btn btn-outline-warning" onclick="location.href='updateTask.jsp';">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
					  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
					</svg>
				</button>
			</span>
		</div>
		<hr />

		<div class="d-flex p-1 align-items-center justify-content-between" style="height: 100px;">
			<span class="d-flex justify-content-center" style="width: 160px;">
				<span class="d-block ps-3 pe-3 rounded-pill text-center"
					style="background-color: #fffacc;">
					<strong style="text-decoration: underline;">�����ͺ��̽� ����</strong><br>by
					2022/10/15
				</span>
			</span>
			<span class="d-flex" style="width: 250px;">
				ERWIN Physical �𵨸� �����ϰ� DDL ��ũ��Ʈ ������
			</span>
			<span class="d-flex justify-content-center" style="width: 80px;">
				<button class="d-flex btn btn-outline-warning" onclick="location.href='updateTask.jsp';">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
					  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
					</svg>
				</button>
			</span>
		</div>
		<hr />
		
		<div class="d-flex p-1 align-items-center justify-content-between" style="height: 100px;">
			<span class="d-flex justify-content-center" style="width: 160px;">
				<span class="d-block ps-3 pe-3 rounded-pill text-center"
					style="background-color: #fffacc;">
					<strong style="text-decoration: underline;">MVC ���� ����</strong><br>by
					2022/11/08
				</span>
			</span>
			<span class="d-flex" style="width: 250px;">
				�ڷ� �����ؼ� ���� ���� �ۼ��ϰ� ��ǿ� �����ϱ�
			</span>
			<span class="d-flex justify-content-center" style="width: 80px;">
				<button class="d-flex btn btn-outline-warning" onclick="location.href='updateTask.jsp';">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
					  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
					</svg>
				</button>
			</span>
		</div>
		<hr />

		<div class="d-flex p-1 align-items-center justify-content-between" style="height: 100px;">
			<span class="d-flex justify-content-center" style="width: 160px;">
				<span class="d-block ps-3 pe-3 rounded-pill text-center"
					style="background-color: #fffacc;">
					<strong style="text-decoration: underline;">UI ������</strong><br>by
					2022/12/05
				</span>
			</span>
			<span class="d-flex" style="width: 250px;">
				�ٽ� ������ UI �������ϰ� �Ϻ� �����ϱ�
			</span>
			<span class="d-flex justify-content-center" style="width: 80px;">
				<button class="d-flex btn btn-outline-warning" onclick="location.href='updateTask.jsp';">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
					  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
					</svg>
				</button>
			</span>
		</div>
		<hr />
			

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