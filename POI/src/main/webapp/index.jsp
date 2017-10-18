<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>你好</h1>
<form action="${pageContext.request.contextPath }/DownloadFile" method="post">
	<input type="submit" >
</form>
<a href="${pageContext.request.contextPath }/DownloadFile" >下载文件</a>
</body>
</html>