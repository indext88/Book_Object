<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="../UploadSeverlet?opt=upload" method="post" enctype="multipart/form-data">
    上传者：<input type="text" name="name">
    上传文件：<input type="file" name="myfile">
    <input type="submit" value="上传">
    </form>
</body>
</html>