<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:actionerror/>
<s:fielderror/>
<h1>批量上传</h1>
<form action="${pageContext.request.contextPath }/mutiupload.action" method="post" enctype="multipart/form-data" >
文件上传<input type="file" name="upload">
文件上传<input type="file" name="upload">
文件上传<input type="file" name="upload">
<input type="submit" value="上传">
</form>
</body>
</html>