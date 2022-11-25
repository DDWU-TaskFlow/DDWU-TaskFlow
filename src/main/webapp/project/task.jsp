<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="EUC-KR">
        <title>task.jsp</title>
    </head>

    <body class="bg-light">

        <div class="ps-2 bg-body rounded shadow-sm">

            <!-- 상단바 -->
            <div style="float: left;">
                <a href="#" class="btn rounded-pill" style="width: 80px; background-color: #b3c7ff;">배정</a>&nbsp;
                <a href="#" class="btn rounded-pill" style="width: 80px; background-color: #b3c7ff;">미배정</a>
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
            <hr />

            <!-- DB에서 history 불러오도록 변경 -->
            <div class="d-flex pt-3">
               <!--  <p>
                    <span class="d-block rounded-pill text-center"
                        style="background-color: rgb(233, 231, 231); width: 485px;">2022/09/11 23:37</span>
                    <span class="d-block rounded-pill pt-3"><strong>&nbsp;정유영&nbsp;</strong></span>
                    <span class="d-block rounded-pill ps-3 pt-1">task_수행계획서 | thread 작성 | "아 왜 나만 일해 ~~"</span>
                </p> -->
            </div>
            <hr />

            <div class="d-flex pt-3">
                <!-- <p>
                    <span class="d-block rounded-pill text-center"
                        style="background-color: rgb(233, 231, 231); width: 485px;">2022/09/10 10:00</span>
                    <span class="d-block rounded-pill pt-3"><strong>&nbsp;이송희&nbsp;</strong></span>
                    <span class="d-block rounded-pill ps-3 pt-1">task_수행계획서 | 수행률 입력 | 75% (+15%)</span>
                </p> -->
            </div>
            <hr />

            <div class="d-flex pt-3">
               <!--  <p>
                    <span class="d-block rounded-pill text-center"
                        style="background-color: rgb(233, 231, 231); width: 485px;">2022/09/08 13:10</span>
                    <span class="d-block rounded-pill pt-3"><strong>&nbsp;서한나&nbsp;</strong></span>
                    <span class="d-block rounded-pill ps-3 pt-1">task_요구사항 | task 업로드 | task_MVC 설계</span>
                </p> -->
            </div>
            <hr />

            <div class="d-flex pt-3">
                <!-- <p>
                    <span class="d-block rounded-pill text-center"
                        style="background-color: rgb(233, 231, 231); width: 485px;">2022/09/01 10:00</span>
                    <span class="d-block rounded-pill pt-3"><strong>&nbsp;심재현&nbsp;</strong></span>
                    <span class="d-block rounded-pill ps-3 pt-1">task_UI 설계 | 업무 분담 | task_</span>
                </p> -->
            </div>
            <hr />

        </div>

    </body>

    </html>