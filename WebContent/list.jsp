<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.javaex.guestVO.GuestBookVO"%>
<%@page import="com.javaex.guestDAO.GuestBookDAO"%>
<%@page import="java.util.List"%>


<%
	List<GuestBookVO> list = (List<GuestBookVO>) request.getAttribute("list");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		for (GuestBookVO vo : list) {
	%>
	<form action="gc" method="get">
		<input type="hidden" name="a" value=delete>
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%=vo.getName()%>"></td>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="content" cols=60 rows=5><%=vo.getContent()%></textarea></td>
			</tr>

		</table>

		<br />
		<table width=510 border=1>
			<tr>
				<td><a href="gc?a=deleteform&no=<%=vo.getNo()%>">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4></td>
			</tr>
		</table>
		<br />
	</form>
	<%
		}
	%>
</body>
</html>