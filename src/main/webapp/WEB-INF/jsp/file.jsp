<%--
  Created by IntelliJ IDEA.
  User: 86131
  Date: 2020/6/6
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品图片上传</title>
</head>
<body>
<form action="/fileUpload" method="post" enctype="multipart/form-data">
    <input type="hidden" value="${id}" name="id">
    <label>上传图片</label><input type="file" name="file"/><input type="submit" value="上传"/>
</form>
</body>
</html>