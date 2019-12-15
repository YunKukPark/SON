<%@page import="org.apache.catalina.tribes.membership.MemberImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.MenuDAO"%>
<%@page import="com.sun.beans.util.Cache"%>
<%@page import="com.DAO.MenuVO"%>
<%@page import="com.DAO.memberVO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	function tabSetting() {
		// 탭 컨텐츠 hide 후 현재 탭메뉴 페이지만 show

		$('.tabPage').hide();
		$($('.current').find('a').attr('href')).show();

		// Tab 메뉴 클릭 이벤트 생성
		$('li').click(
				function(event) {
					var tagName = event.target.tagName; // 현재 선택된 태그네임
					var selectedLiTag = (tagName.toString() == 'A') ? $(
							event.target).parent('li') : $(event.target); // A태그일 경우 상위 Li태그 선택, Li태그일 경우 그대로 태그 객체
					var currentLiTag = $('li[class~=current]'); // 현재 current 클래그를 가진 탭
					var isCurrent = false;

					// 현재 클릭된 탭이 current를 가졌는지 확인
					isCurrent = $(selectedLiTag).hasClass('current');

					// current를 가지지 않았을 경우만 실행
					if (!isCurrent) {
						$($(currentLiTag).find('a').attr('href')).hide();
						$(currentLiTag).removeClass('current');

						$(selectedLiTag).addClass('current');
						$($(selectedLiTag).find('a').attr('href')).show();
					}

					return false;
				});
	}

	$(function() {
		// 탭 초기화 및 설정
		tabSetting();
	});
</script>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />

<style>
.tabWrap {
	-webkit-overflow-scrolling: touch;
	overflow-x: auto;
}

.tab_Menu {
	margin: 0px;
	padding: 0px;
	list-style: none;
	font-family: "Source Sans Pro", Helvetica, sans-serif;
}

.current {
	-moz-appearance: none;
	-webkit-appearance: none;
	-ms-appearance: none;
	appearance: none;
	-moz-transition: background-color 0.2s ease-in-out, box-shadow 0.2s
		ease-in-out, color 0.2s ease-in-out;
	-webkit-transition: background-color 0.2s ease-in-out, box-shadow 0.2s
		ease-in-out, color 0.2s ease-in-out;
	-ms-transition: background-color 0.2s ease-in-out, box-shadow 0.2s
		ease-in-out, color 0.2s ease-in-out;
	transition: background-color 0.2s ease-in-out, box-shadow 0.2s
		ease-in-out, color 0.2s ease-in-out;
	background-color: transparent;
	border: 0;
	border-radius: 0;
	box-shadow: inset 0 0 0 2px #ffffff;
	color: #ffffff;
	cursor: pointer;
	display: inline-block;
	font-size: 0.8em;
	font-weight: 600;
	height: 3.5em;
	letter-spacing: 0.25em;
	line-height: 3.5em;
	padding: 0 1.75em;
	text-align: center;
	text-decoration: none;
	text-transform: uppercase;
	white-space: nowrap;
	font-family: "Source Sans Pro", Helvetica, sans-serif;
}

.tabPage {
	width: 900px;
	height: 470px;
	float: left;
}

body {
	background-color: #242943;
	color: white;
}
</style>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">


<title>딱 저기네</title>
</head>



<body class="is-preload">

	<%
		memberVO vo = (memberVO) session.getAttribute("vo");
		
		MenuVO menuvo = (MenuVO) session.getAttribute("menuvo");
	
		MenuDAO dao = new MenuDAO();
	%>
	<%
		if (vo == null) {
	%>
	<script>
		var result = confirm("로그인을 위해 메인페이지로 이동합니다.");

		if (result) {
			window.location.href = "main.jsp";
		}
	</script>
	
	<%
		}else{
	%>
	<%
	System.out.println("여기 잘 들어 오나요 ?? ");
	System.out.println("접속한 ID 는 " + vo.getID());
	%>
	
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header" class="alt">
			<a href="Just_Over_There.jsp" class="logo"><strong>S O N</strong>
			</a>
			<form action="recommand.do" method="post">
		<%-- 	<!-- <select name="Id"><option><%=vo.getID() %></option></select> --> --%>
			</form>
			<h3 style="align-content: center;">딱 저기네</h3>
			<nav>
				<form name="go" action="checkOut.jsp" method="post">
					<input type="submit" value="장바구니">
				</form>
			</nav>
		</header>
<% 
 %> 

		<!-- Main -->
		<section id="one">
			<div class="inner">
				<div id="main" class="alt">

					<!-- Table -->
					<h3>Menu</h3>

					<div class="tabWrap">
						<!--  -->
						<ul class="actions">
							<li class="tabMenu current"><a href="#tabContent01">추천
							</a></li>
							<li class="tabMenu"><a href="#tabContent02">덮밥</a></li>
							<li class="tabMenu"><a href="#tabContent03">라멘</a></li>
						</ul>
						
						<hr>


						<%
							System.out.print("접속아이디 : ");
							System.out.println(vo.getID());
							ArrayList<MenuVO> recArr = dao.recommenationMenuSelect(vo.getID());

							System.out.println("recarr 이 return 받았음");
						%>
						
						
						<div id="tabContent01" class="table-wrapper">

							<table>
								<thead>
									<tr>
										<th>메뉴</th>
										<th>가격</th>
									</tr>
								</thead>
								<tbody>
								<tbody>
									<%
										for (int i = 0; i < recArr.size(); i++) {
									%>
									<form name="set" action="add.jsp" method="post">
										<tr>
											<td><select name="product"><option><%=recArr.get(i).getMenu_Code()%></option></select></td>
											<%
												//System.out.println("getmenucode 받음");
											%>
											<td><select name="product_Cost"><option><%=recArr.get(i).getMenu_Item_Cost()%></option></select>
												<%
													//System.out.println("getmenucost 받음");
												%> <input
												type="submit" value="담기"></td>
										</tr>
									</form>

									<%
										}
									%>
								</tbody>

								</tbody>
								<tfoot>
								</tfoot>
							</table>

						</div>

						<%
							ArrayList<MenuVO> arr = dao.menuSelect("111-222-3333");

							System.out.println("arr 이 return 받았음");
						%>
						<div id="tabContent02" class="table-wrapper">
							<table>
								<thead>
									<tr>
										<th>메뉴</th>
										<th>가격</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < 4; i++) {
									%>
									<form name="set" action="add.jsp" method="post">
										<tr>
											<td><select name="product"><option><%=arr.get(i).getMenu_Code()%></option></select></td>
											<%
												//System.out.println("getmenucode 받음");
											%>
											<td><select name="product_Cost"><option><%=arr.get(i).getMenu_Item_Cost()%></option></select>
												<%
													//System.out.println("getmenucost 받음");
												%> <input
												type="submit" value="담기"></td>
										</tr>
									</form>

									<%
										}
									%>
								</tbody>
								<tfoot>
								</tfoot>
							</table>

						</div>





						<div id="tabContent03" class="table-wrapper">
							<table>
								<thead>
									<tr>
										<th>메뉴</th>
										<th>가격</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 4; i < 8; i++) {
									%>
									<form name="set" action="add.jsp" method="post">
										<tr>
											<td><select name="product"><option><%=arr.get(i).getMenu_Code()%></option></select></td>
											<%
												//System.out.println("getmenucode 받음");
											%>
											<td><select name="product_Cost"><option><%=arr.get(i).getMenu_Item_Cost()%></option></select>
												<%
												//	System.out.println("getmenucost 받음");
												%> <input
												type="submit" value="담기"></td>
										</tr>
									</form>

									<%
										}
									%>



								</tbody>
								<tfoot>
								</tfoot>
							</table>
						</div>

					</div>
				</div>

			</div>
	</div>
	<%} %>
	</section>
</body>
</html>