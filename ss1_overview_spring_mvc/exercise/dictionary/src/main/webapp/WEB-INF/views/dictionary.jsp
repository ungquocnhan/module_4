<%--
  Created by IntelliJ IDEA.
  User: QUOC NHAN
  Date: 11/18/2022
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="/dictionary" method="post">
    <input type="text" name="translate" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Translate"/>
</form>
<p>Kết quả là : ${result}</p>
</body>
</html>
