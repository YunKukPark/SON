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
			// System.out.println("���� �α����� ��� : " + vo.getEmail());
		%>
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header" class="alt">
						<a href="index.html" class="logo"><strong>������</strong></a>
						<nav>
							<%if(vo==null) {%>
								<a href="#menu">�α���</a>
							<%} else { %>
								<a href="Logout.do">�α׾ƿ�</a>
								<a href="update.jsp">ȸ����������</a>
								<%if(vo.getID().equals("admin")) {%>
									<a href="selectMember.jsp">ȸ������������</a>
								<%} %>
							<%} %>							
							<!-- �α��� �� Logout.jsp�� �̵��� �� �ִ�'�α׾ƿ�'��ũ�� '������������'��ũ�� ����Ͻÿ�. -->
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">	
						<ul class="links">
							<li><h5>�α���</h5></li>
								<form action="Login.do" method="post">
									<li><input type="text" name="id" placeholder="ID�� �Է��ϼ���"></li>
									<li><input type="password" name="pw" placeholder="PW�� �Է��ϼ���"></li>
									<li><input type="submit" value="LogIn" class="button fit"></li>
								</form>
							
							
						</ul>
						<ul class="actions vertical">
							<li><h5>ȸ������</h5></li>
								<form action="Join.do" method="post">
									<li><input type="text" name="id" placeholder="ID�� �Է��ϼ���"></li>
									<li><input type="password" name="pw" placeholder="PW�� �Է��ϼ���"></li>
									<li><input type="text" name="age" placeholder="���̴븦 �Է��ϼ���"></li>
									<li><input type="text" name="sex" placeholder="������ �Է��ϼ���"></li>
									<li><input type="text" name="hp" placeholder="��ȭ��ȣ�� �Է��ϼ���"></li>
									<li><input type="text" name="alergy" placeholder="�˷��������� �Է��ϼ���"></li>
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
										<h1><%=vo.getID() %> ��<br>ȯ���մϴ�.</h1>
									<%} %>
								<!-- �α��� �� �α��� �� ������� ���Ǿ��̵�� �ٲٽÿ�.
									 ex)smart�� ȯ���մϴ� -->
							</header>
							<div class="content">
								<p>Son�� ���� ������ �Ұ��� ����<br></p>
								<ul class="actions">
									<li><a href="#menu" class="button fit">�����ϱ�</a></li>
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

