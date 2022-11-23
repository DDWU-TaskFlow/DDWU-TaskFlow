# DDWU-TaskFlow

꼭 읽고 시작해주세요!!!!!!!!!!!!!!!!

1) git 활용법: <master-develop-feature 형상관리법 채택> ---- Git_Tutorial.pdf 참고 

              - 현재 상태 : 팀장 develop branch 생성 완료한 상태. (p.35 ~ p.62)
              - 여러분들은 작업 시작 전 이 페이지를 꼭꼭 읽으셔야 함 _ eclipse에서 git 사용 -> **(p.63 ~ p.73) 
              
2) first commit: [ Maven Project 생성 ] ---- 데베프 공지사항(Eclipse에서 Maven Web Project 생성 방법) 확인 

                 - controller 폴더 속 파일들 수정 필요: UserMan3 관련 ~controller.java file들이 들어있음. -> (Controller 정리 후에 즉시 수정할 예정)
                 - RequestMapping.java 수정 필요: RequestMapping#initMapping() 안의 URI-to-Controller mapping 관한 코드. -> (Controller 정리 후에 즉시 수정할 예정)
                 - DDL script 추가 필요: 추후 src/main/resources 밑에 DDL script 파일 저장해서 참고하면 좋음.
                 - ResourceFilter.java 수정 필요: src/main/webapp 밑에 생성할 폴더(css, js, fonts, images, ...) 
                 - controller의 처리 결과를 forwarding할 JSP의 경로가 /WEB-INF 로 시작해야 함
