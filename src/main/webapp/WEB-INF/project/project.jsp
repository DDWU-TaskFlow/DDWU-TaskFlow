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

  <!-- 추후에 Project.name 으로 변경 -->
  <title>데베프 팀플</title>

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


<body class="bg-light">
    
  <!-- 상단바, project.name 변경 예정 (DB 연결) -->
  <!-- background-image: radial-gradient(circle at 15%, #A1A2D3 5%, #FFFFFF 20%, #A1A2D3); -->
  <nav class="navbar navbar-expand-lg fixed-top navbar-dark border-bottom border-3 border-dark rounded" aria-label="Main navigation" style="background-color: #A1A2D3; height: 120px;">
    <div class="container-fluid" style="margin-top: 10px; margin-left: 100px;">
      <p style="text-shadow: 1px 1px 5px #000;">
        <a class="navbar-brand fs-2" href="../index.jsp">Task Flow</a><br/>
        <a class="fs-5 ms-1" href="project.jsp" style="color: rgba(255, 255, 255, 0.863); text-decoration: none;">데베프 팀플</a>
      </p>
      <a href="settings.html" style="float: right;">
        <div class="d-flex justify-content-center align-items-center border border-secondary rounded-circle" style="width: 40px; height: 40px; margin-right: 100px; float: right;">
          <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="rgb(255, 255, 255)" class="bi bi-gear-fill" viewBox="0 0 16 16">
            <path d="M9.405 1.05c-.413-1.4-2.397-1.4-2.81 0l-.1.34a1.464 1.464 0 0 1-2.105.872l-.31-.17c-1.283-.698-2.686.705-1.987 1.987l.169.311c.446.82.023 1.841-.872 2.105l-.34.1c-1.4.413-1.4 2.397 0 2.81l.34.1a1.464 1.464 0 0 1 .872 2.105l-.17.31c-.698 1.283.705 2.686 1.987 1.987l.311-.169a1.464 1.464 0 0 1 2.105.872l.1.34c.413 1.4 2.397 1.4 2.81 0l.1-.34a1.464 1.464 0 0 1 2.105-.872l.31.17c1.283.698 2.686-.705 1.987-1.987l-.169-.311a1.464 1.464 0 0 1 .872-2.105l.34-.1c1.4-.413 1.4-2.397 0-2.81l-.34-.1a1.464 1.464 0 0 1-.872-2.105l.17-.31c.698-1.283-.705-2.686-1.987-1.987l-.311.169a1.464 1.464 0 0 1-2.105-.872l-.1-.34zM8 10.93a2.929 2.929 0 1 1 0-5.86 2.929 2.929 0 0 1 0 5.858z"/>
          </svg>
        </div>
      </a>
    </div>
  </nav>

<main class="container align-items-center">

  <div class="p-3 bg-body rounded" style="margin-top: 150px;">
  <div class="align-self-center" style="margin-left: 15%;">

    <div class="row" style="height: 70px;">
      <div class="my-4 col-lg-6 mx-auto">
        <button class="btn btn-outline-warning rounded-pill" style="width: 150px; color: black; font-size: large;" data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasTask" aria-controls="offcanvasRight">Task</button>
        <span style="width: 5px; margin-left: 30px;"></span>
        <button class="btn btn-outline-secondary rounded-pill" style="width: 150px; color: black; font-size: large;" data-bs-toggle="offcanvas"
                data-bs-target="#offcanvasHistory" aria-controls="offcanvasRight">History</button>
      </div>
    </div>
    <br/>

    <!-- DB에서 member list를 받아오는 걸로 변경 -->
    <div class="container row" style="vertical-align: middle;">
      <div class="d-flex pt-4" style="width: 120px;">
        <p class="pb-4 mb-0 fs-5 border-bottom">
          <strong class="d-block">이송희</strong>
        </p>
      </div>
      <div class="col-lg-8 align-self-center">
        <a class="btn" href="#" style="width: 100%;" data-bs-toggle="offcanvas" data-bs-target="#offcanvasTask" >
          <div class="progress" style="height: 35px; border: solid 1px #b3c7ff;">
            <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 65%; height: 35px; background-color: #b3c7ff;"
                aria-valuenow="65" aria-valuemin="0" aria-valuemax="100">65%</div>
          </div>
        </a>
      </div>
    </div>

    <div class="container row" style="vertical-align: middle;">
      <div class="d-flex pt-4" style="width: 120px;">
        <p class="pb-4 mb-0 fs-5 border-bottom">
          <strong class="d-block">심재현</strong>
        </p>
      </div>
      <div class="col-lg-8 align-self-center">
        <a class="btn" href="#" style="width: 100%;" data-bs-toggle="offcanvas" data-bs-target="#offcanvasTask" >
          <div class="progress" style="height: 35px; border: solid 1px #A1A2D3;">
            <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 75%; height: 35px; background-color: #A1A2D3;"
                aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">75%</div>
          </div>
        </a>
      </div>
    </div>

    <div class="container row" style="vertical-align: middle;">
      <div class="d-flex pt-4" style="width: 120px;">
        <p class="pb-4 mb-0 fs-5 border-bottom">
          <strong class="d-block">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="rgb(240,150,0)" class="bi bi-star" viewBox="0 1 16 16" style="margin-left: -25px; margin-top: -20px" data-toggle="tooltip" data-bs-placement="left" title="팀장">
              <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.565.565 0 0 0-.163-.505L1.71 6.745l4.052-.576a.525.525 0 0 0 .393-.288L8 2.223l1.847 3.658a.525.525 0 0 0 .393.288l4.052.575-2.906 2.77a.565.565 0 0 0-.163.506l.694 3.957-3.686-1.894a.503.503 0 0 0-.461 0z"/>
            </svg>&nbsp;정유영
          </strong>
        </p>
      </div>
      <div class="col-lg-8 align-self-center">
        <a class="btn" href="#" style="width: 100%;" data-bs-toggle="offcanvas" data-bs-target="#offcanvasTask" >
          <div class="progress" style="height: 35px; border: solid 1px #f5b6c4;">
            <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 50%; height: 35px; background-color: #f5b6c4;"
                aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">50%</div>
          </div>
        </a>
      </div>
    </div>

    <div class="container row" style="vertical-align: middle;">
      <div class="d-flex pt-4" style="width: 120px;">
          <p class="pb-4 mb-0 fs-5 border-bottom">
              <strong class="d-block">서한나</strong>
          </p>
      </div>
      <div class="col-lg-8 align-self-center">
        <a class="btn" href="#" style="width: 100%;" data-bs-toggle="offcanvas" data-bs-target="#offcanvasTask" >
          <div class="progress" style="height: 35px; border: solid 1px #c6b0f8;">
            <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 90%; height: 35px; background-color: #c6b0f8;"
                aria-valuenow="90" aria-valuemin="0" aria-valuemax="100">90%</div>
          </div>
        </a>
      </div>
    </div>

    <br/><br/>

  </div>
  </div>

  <!-- toggle task -->
  <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasTask" aria-labelledby="offcanvasRightLabel" style="width: 550px;">
    <div class="offcanvas-header" style="height: 70px;">
      <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      <div class="d-flex justify-content-center"><p class="my-4 fs-5">TASK</p></div>
      <div></div>
    </div>
    <div class="offcanvas-body" id="task">
      <!-- include task.jsp -->
      <jsp:include page="task.jsp" />
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

  <!-- toggle task by member -->
  <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasTask" aria-labelledby="offcanvasRightLabel" style="width: 550px;" data-bs-backdrop="false">
    <div class="offcanvas-header" style="height: 70px;">
      <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      <div class="d-flex justify-content-center"><p class="my-4 fs-5">TASK</p></div>
      <div></div>
    </div>
    <div class="offcanvas-body" id="task_member">
      <!-- include task.jsp -->
      <jsp:include page="task.jsp" />
    </div>
  </div>


</main>

</body>
</html>
