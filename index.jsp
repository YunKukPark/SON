<%@page import="com.DAO.messageVO"%>
<%@page import="com.DAO.webMessageDAO"%>
<%@page import="com.DAO.memberVO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>SON</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
		<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>
		<% 
			memberVO vo = (memberVO) session.getAttribute("vo");
			// System.out.println("현재 로그인한 사람 : " + vo.getEmail());
		%>
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header" class="alt">
						<a href="index.html" class="logo"><strong>박윤국</strong></a>
						<nav>
							<%if(vo==null) {%>
								<a href="#menu">로그인</a>
							<%} else { %>
								<a href="Logout.do">로그아웃</a>
								<a href="update.jsp">회원정보수정</a>
								<%if(vo.getID().equals("admin")) {%>
									<a href="selectMember.jsp">회원관리페이지</a>
								<%} %>
							<%} %>							
							<!-- 로그인 후 Logout.jsp로 이동할 수 있는'로그아웃'링크와 '개인정보수정'링크를 출력하시오. -->
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">	
						<ul class="links">
							<li><h5>로그인</h5></li>
								<form action="Login.do" method="post">
									<li><input type="text" name="id" placeholder="ID를 입력하세요"></li>
									<li><input type="password" name="pw" placeholder="PW를 입력하세요"></li>
									<li><input type="submit" value="LogIn" class="button fit"></li>
								</form>
							
							
						</ul>
						<ul class="actions vertical">
							<li><h5>회원가입</h5></li>
								<form action="Join.do" method="post">
									<li><input type="text" name="id" placeholder="ID를 입력하세요"></li>
									<li><input type="password" name="pw" placeholder="PW를 입력하세요"></li>
									<li><input type="text" name="age" placeholder="나이대를 입력하세요"></li>
									<li><input type="text" name="sex" placeholder="성별을 입력하세요"></li>
									<li><input type="text" name="hp" placeholder="전화번호를 입력하세요"></li>
									<li><input type="text" name="alergy" placeholder="알러지정보를 입력하세요"></li>
									<li><input type="submit" value="JoinUs" class="button fit"></li>
								</form>
						</ul>
					</nav>			
				<!-- Banner -->
					<section id="banner" class="major">
						<div class="inner">
							<header class="major">
									<%if(vo==null) { %>
										<h1>New Smart Ordering System SON</h1>
									<%} else { %>
										<h1><%=vo.getID() %> 님<br>환영합니다.</h1>
									<%} %>
								<!-- 로그인 후 로그인 한 사용자의 세션아이디로 바꾸시오.
									 ex)smart님 환영합니다 -->
							</header>
							<div class="content">
								<p>Son에 대한 간략한 소개글 쓰기<br></p>
								<ul class="actions">
									<li><a href="#menu" class="button fit">시작하기</a></li>
								</ul>
							</div>
						</div>
					</section>


				<!-- Footer -->
					<footer id="footer">
						<div class="inner">
							<ul class="icons">
								<li><a href="#" class="icon alt fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon alt fa-facebook"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon alt fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon alt fa-github"><span class="label">GitHub</span></a></li>
								<li><a href="#" class="icon alt fa-linkedin"><span class="label">LinkedIn</span></a></li>
							</ul>
						</div>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>

