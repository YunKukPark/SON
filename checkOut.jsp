<%@page import="com.DAO.memberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Son바구니</title>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body style="text-align: center;">


	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<%
		String name = (String) session.getAttribute("username");
	%>
	<%
		ArrayList<String> checkOut_Arr = (ArrayList) session.getAttribute("arr1");
		ArrayList<String> checkCost_Arr = (ArrayList) session.getAttribute("arr2");
	%>
	<%
		memberVO vo = (memberVO) session.getAttribute("vo");
		System.out.println("현재 로그인한 사람 : " + vo.getID());
		String MemberId = vo.getID();
	%>
	<%
		if (checkOut_Arr == null) {
	%>
	<script>
		alert("장바구니에 아무것도 담겨있지 않아요 ㅠㅠ");
		history.back();
	</script>
	<%} %>
		
	<script>
	function mySubmit(index){
		if(index == 1){
			document.myForm.action="InsertUserinfo.do";
		}
		if(index == 2){
			document.myForm.action="remove.jsp";
		}
		document.myForm.submit();
	}
	</script>
	<div id="wrapper">

		<header id="header" class="alt">
			<a href="index.html" class="logo"><strong>박윤국</strong></a>
			<nav>


				<a href="Just_Over_There.jsp">돌아가기</a>


			</nav>
		</header>
		<!-- Menu  -->
		<section id="one">
			<div class="inner">
				<div id="main" class="alt">
				<form name='myForm' method="post">
				<select name="Id"><option><%=vo.getID()%></option></select>
					<table>
						<h2>장바구니</h2>
						<tbody>
							<tr>
								<td>Contents</td>
								<td>가격</td>
								<td>삭제</td>
							</tr>
							<%
								for (int i = 0; i < checkOut_Arr.size(); i++) {
							%>
								<tr>
									
									<td><select name="addedproduct"><option><%=checkOut_Arr.get(i)%></option></select></td>
									<td><select name="menu_Item_Cost"><option><%=checkCost_Arr.get(i)%></option></select></td>
									<td><input type="button" onclick="mySubmit(2)" value="삭제"></td>
								</tr>

								<%
							
									}
									
								%>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="2"> 꼭 위에서부터 순서대로 삭제해주세요 for문 써서 삭제가 순서대로 됩니다.</td>
								<td><input type="button" onclick="mySubmit(1)" value="결제하기">
								</td>
								
							</tr>
						</tfoot>

					</table>
					</form>
				</div>
			</div>
		</section>
	</div>


</body>
</html>