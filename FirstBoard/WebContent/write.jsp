<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="MyWrite" method="post">
		<table border="1" width="100%" height="100%">
			<tr>
				<td width="20%" align="center">제목</td>
				<td><input type="text" name="m_title" maxlength="100"
					size="80%"></td>
			</tr>
			<tr>
				<td width="20%" align="center">내용</td>
				<td><textArea name="m_content" rows="10" cols="80%"></textArea></td>
			</tr>
		</table>
		<input type="submit" value="Done">
	</form>
</body>
</html>