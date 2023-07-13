# 인천환경교육 가이드북 웹페이지 전환화 프로젝트

* 🔊 프로젝트 소개
  * 인천광역시 환경교육센터에서 매년 출간하는 가이드북의 내용을 웹 게시판으로 볼 수 있게 관리하는 프로젝트 
  * 디자인과 퍼블리싱을 제외한 DB설계, 백엔드, 프론트엔드까지 모두 혼자 작업하였습니다.
  * 백엔드는 Restful-API를 개발하고, 프론트엔드는 Ajax로 API를 호출하는 방식으로 개발되었습니다.

* 🏗️개발 기간 및 인원 
  * 2022.08 ~ 2022.10
  * 풀스택 1명, 디자인 퍼블리셔 1명 총 2명 중 풀스택 담당

* 🛠️사용 기술
  * Back-End: Spring Boot, Java, JPA, MySql
  * Front-End: JavaScript, jQuery


* 📅 DB
  * 테이블 정의서 : [https://docs.google.com/document/d/1st21qukFUlUPDubiymRQGz0GIPatiGZo/edit](https://docs.google.com/spreadsheets/d/1-_iHWzXOA6m7cEjLshhxAC5MkVqAh-e4/edit#gid=277208722)
  * ERD
  ![ecoEducation_erd](https://github.com/maroowj/ecoEdu/assets/77284101/86dccc83-4423-48fb-92cf-10e183bbf4df)


* ✏️ 시나리오
  * 관리자
    * 관리자는 단체, 프로그램, 카테고리를 등록 관리하고, 이용자의 수정 요청 내용을 확인하여 응답할 수 있다.
      
  * 사용자
    * 사용자는 관리자가 등록한 가이드북의 내용을 지역, 단체, 프로그램, 체험유형 등으로 색인하여 열람하고 잘못된 내용에 대해 수정 요청을 할 수 있다.

   
* 💻구동 화면
  * 사용자
![user_index](https://github.com/maroowj/ecoEdu/assets/77284101/719a0782-a732-4398-9570-b96801f8bf3f)
![user_area_search](https://github.com/maroowj/ecoEdu/assets/77284101/4cad2201-8bf1-4fea-bbc7-33bd2b638aea)
![user_program_list](https://github.com/maroowj/ecoEdu/assets/77284101/e766adc9-80d9-4876-8c25-c7f82fee1fc5)
![user_program_details](https://github.com/maroowj/ecoEdu/assets/77284101/3ecabf07-eac2-4270-95d5-f36dfd07622b)

  * 관리자
![admin_login](https://github.com/maroowj/ecoEdu/assets/77284101/7b63c6b2-ffac-409f-9fa0-b633ed52ffbe)
![admin_index](https://github.com/maroowj/ecoEdu/assets/77284101/8ed7b7d0-6e2b-48e1-90a8-6f0d906fd6ad)
![admin_program_list](https://github.com/maroowj/ecoEdu/assets/77284101/bc68aa40-a4ec-483b-a0e6-5023ef2864c3)
![admin_program_details](https://github.com/maroowj/ecoEdu/assets/77284101/3137f86f-9fe4-4d0a-9c27-9ba664821b65)


* 💡부가기능
  * JWT를 사용한 로그인 체계 구축 시도 (관리자 페이지)
  * 모바일-웹 전환시 UI 반응형으로 제작
  * AJAX를 이용한 비동기식 화면 전환
