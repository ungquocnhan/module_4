<%--
  Created by IntelliJ IDEA.
  User: QUOC NHAN
  Date: 11/18/2022
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Convert</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="/convert" method="post">
    <pre>Nhập số tiền USD</pre>
    <input type="number" name="usd">
    <input type="submit" value="Convert">
</form>
<p>Kết quả trả về là: ${vnd}</p>
</body>
</html>
