<!DOCTYPE HTML>
<%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<html>
<head>
<title>index</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
	response.setIntHeader("refresh", 1);
	out.println("Date and Time :" + new Date());
 %>
</body>
</html>