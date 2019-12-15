<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<% String addedproduct = request.getParameter("addedproduct"); %>


<% ArrayList<String> checkOut_Arr = (ArrayList)session.getAttribute("arr1");
ArrayList<String> checkCost_Arr = (ArrayList)session.getAttribute("arr1");%>
<% 
   
    checkOut_Arr.remove(addedproduct);
	checkCost_Arr.remove(addedproduct);
%>
<% session.setAttribute("arr", checkOut_Arr);%>
 
 
<script>alert("<%= addedproduct %>이(가) 삭제되었습니다"); location.href=document.referrer;</script>
</body>
</html>