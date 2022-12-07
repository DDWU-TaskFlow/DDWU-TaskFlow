<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Hugo 0.84.0">

  <title>TASK 생성</title>

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
  
</head>


<body class="bg-light" >

  <!-- 상단바, project.name 변경 예정 (DB 연결) -->
  <!-- background-image: radial-gradient(circle at 15%, #A1A2D3 5%, #FFFFFF 20%, #A1A2D3); -->
  <nav class="navbar fixed-top navbar-dark border border-2 border-dark rounded mx-auto" aria-label="Main navigation" style="background-color: #A1A2D3; width: 90%; height: 120px; max-width: 1300px; margin-top: 50px;">
    <div class="container-fluid justify-content-between" style="margin-top: 10px;">
      <p style="text-shadow: 1px 1px 5px #000; margin-left: 10%;">
        <a class="navbar-brand fs-2" href="../index.jsp">Task Flow</a><br/>
        <a class="fs-5 ms-1" href="projectView.jsp" style="color: rgba(255, 255, 255, 0.863); text-decoration: none;">데베프 팀플</a>
      </p>
     </div>
  </nav>

<main class="container align-items-center">

  <div class="d-flex p-3 bg-body rounded mx-auto justify-content-center" style="margin-top: 200px; width: 100%; height: 510px;">
  
	  <!-- task 수정 -->
      <span class="p-4 mt-4" style="font-size: 20px; font-weight: bold;">TASK 수정</span>

      <form class="needs-validation m-4" novalidate>
          <div class="d-flex row mt-4 justify-content-center">
	  
			  <!-- Task Name -->
			  <div class="col-12">
		            <label for="task_name" class="form-label">Task명</label>
		            <input type="text" class="form-control" value="Task Name" style="width: 200px;">
		            <div class="invalid-feedback">
		                Please enter a valid email address for shipping updates.
		            </div>
		        </div>
			  
			  <!-- Task 배정 -->
			  <div class="col-12">
		        <label for="task_name" class="form-label">배정</label>
				<div class="input-group mb-3" style="width: 150px;">
				  <label class="input-group-text " for="inputGroupSelect01">담당</label>
				  <select class="form-select" id="inputGroupSelect01">
				    <option value="0" selected>미배정</option>
				    <option value="1">이송희</option>
				    <option value="2">심재현</option>
				    <option value="3">정유영</option>
				    <option value="4">서한나</option>
				  </select>
				</div>
			   </div>
				
		
			  <!-- Task 진행률 -->
			  <div class="col-12">
				  <label for="customRange2" class="form-label">진행률</label>
				  <div>
					  <input type="range" class="form-range" id="customRange2" style="width: 80%;"
								min="0" max="100" step="1" value="0"  oninput="document.getElementById('progressValue').innerHTML=this.value;">
					  <span id="progressValue"></span>
				  </div>
			  </div>
		
			  <!-- Task 기한 -->
			  <div class="col-12">
				  <label for="address2" class="form-label">기한</label>
				  <form>
				      <p><input type="date"></p>
			      </form>
			  </div>
			  
              <hr/>

              <div class="find-btn my-1">
                  <button class="btn btn-primary" type="submit" 
                  style="background-color: rgb(161, 162, 207); border: 0; outline: 0;">Update</button>
                  <button class="btn btn-outline-secondary" type="reset">Cancel</button>
              </div>
		
			</div>
		</form>


	    <div style="height: 70px;"></div>
	
	
		  
  
  </div>
	
  	<!-- 하단바 -->
	<span class="d-flex justify-content-center" style="margin-top: 20px; color: lightgrey;">2022 DBP BAMANSAEJO</span>


</main>

</body>
</html>
