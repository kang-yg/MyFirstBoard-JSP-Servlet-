<%@page import="com.mydto.FirstBoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mydao.FirstBoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!	
		FirstBoardDAO boardDAO = null;	
		ArrayList<FirstBoardDTO> writeList;
	%>
	<%
		boardDAO = new FirstBoardDAO();
		writeList = (ArrayList<FirstBoardDTO>)request.getAttribute("writeList");
	%>

	<form action="write.jsp" method="post">
		<table border="1" width="100%" height="100%">
			<tr>
				<td width="10%" align="center">��ȣ</td>
				<td width="70%" align="center">����</td>
				<td width="10%" align="center">��¥</td>
				<td width="10%" align="center">�۾���</td>
			</tr>
			<%
				for (int i = 0; i < writeList.size(); i++) {
			%>
			<tr>
				<td width="10%" align="center"><%= writeList.get(i).getNo()%></td>
				<td width="70%" align="center"><%= writeList.get(i).getTitle()%></td>
				<td width="10%" align="center"><%= writeList.get(i).getDate()%></td>
				<td width="10%" align="center"><%= writeList.get(i).getWriter()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<input type="submit" value="�۾���">
	</form>
</body>
</html>