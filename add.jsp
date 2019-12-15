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
<% String product = request.getParameter("product"); %>
<% String product_Cost = request.getParameter("product_Cost"); %>
<% ArrayList<String> checkOut_Arr = (ArrayList)session.getAttribute("arr1"); %>
<% ArrayList<String> checkCost_Arr = (ArrayList)session.getAttribute("arr2"); %>
<% 
    if(checkOut_Arr==null) {
        checkOut_Arr = new ArrayList<String>();
        checkCost_Arr = new ArrayList<String>();
    }
    checkOut_Arr.add(product);
    checkCost_Arr.add(product_Cost);
%>
<% session.setAttribute("arr1", checkOut_Arr); %>
<% session.setAttribute("arr2", checkCost_Arr); %>
 
 
<script>alert("<%= product %>이(가) 추가되었습니다.<%=product_Cost%> "); history.back();</script>
</body>
</html>