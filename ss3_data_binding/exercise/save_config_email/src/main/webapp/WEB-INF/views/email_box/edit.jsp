<%--
  Created by IntelliJ IDEA.
  User: QUOC NHAN
  Date: 11/22/2022
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Email Box</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/email/update" method="post" modelAttribute="emailBox">
    <form:hidden path="id"/>

    <form:label path="languages">Languages :</form:label>
    <form:select path="languages" items="${languagesList}"></form:select>
    <br>
    <form:label path="pageSize">Page Size :</form:label>
    Show <form:select path="pageSize" items="${pageSizeList}"></form:select> emails per page
    <br>
    <form:label path="spamsFilter">Spams Filter :</form:label>
    <form:checkbox path="spamsFilter"></form:checkbox>
    <br>
    <form:label path="signature">Signature</form:label>
    <form:textarea path="signature"/>
    <br>
    <input type="submit" value="Update">
    <button><a href="/email" style="text-decoration: none">Cancel</a></button>
</form:form>
</body>
</html>
