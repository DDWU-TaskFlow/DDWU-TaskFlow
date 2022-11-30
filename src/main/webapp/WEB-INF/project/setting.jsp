<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!doctype html>
<html lang="en">

<head>
  <meta charset="EUC-KR">
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
	
	  <div class="p-3 bg-body rounded mx-auto" style="margin-top: 200px; width: 100%; height: 510px; overflow-y: auto;">
	
		<div style="padding:80px;">
		<div>
			<form>
			<b>팀장 선택&nbsp;&nbsp;</b>
			      <select>
			        <option>이송희</option>
			        <option>서한나</option>
			        <option>심재현</option>
			        <option>정유영</option>
			      </select>
		    </form>
		</div>
		<br>
		<div>
			<b>초대링크&nbsp;&nbsp;</b>
				<span class="button gray medium"><a href="#" onclick="clip(); return false;"> 복사</a></span>
		</div>
		<br>
		<div class="input-group mb-3">
		  <b>공지 발송</b>
		  &nbsp;&nbsp;<textarea name="notion" cols="60" rows="2"></textarea>
		  <button type="button"><img src="./image/send.png" alt="전송버튼" style="width:30px; height:30px;"></img></button>
		  <p name="notion_cnt">(0 / 100)</p>
		  
		  <script>
		  $(document).ready(function() {
		      $('#notion').on('keyup', function() {
		          $('#notion_cnt').html("("+$(this).val().length+" / 100)");
		   
		          if($(this).val().length > 100) {
		              $(this).val($(this).val().substring(0, 100));
		              $('#notion_cnt').html("(100 / 100)");
		          }
		      });
		  });  
		  </script>
		</div>
		
		<div>
			<b>프로젝트</b>
			<span><a href="index.jsp">삭제</a></span>
		</div> 
		
		</div>
	
	</div>
	
  	<!-- 하단바 -->
	<span class="d-flex justify-content-center" style="margin-top: 20px; color: lightgrey;">2022 DBP BAMANSAEJO</span>


</main>

</body>
</html>