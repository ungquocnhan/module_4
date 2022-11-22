<%--
  Created by IntelliJ IDEA.
  User: QUOC NHAN
  Date: 11/22/2022
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List Email Box</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body>
<h1 style="color: greenyellow">${message}</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Languages</th>
        <th scope="col">Page Size</th>
        <th scope="col">Spams Filter</th>
        <th scope="col">Signature</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="emailBox" items="${emailBoxList}" varStatus="status">
        <tr>
            <th scope="row">${status.count}</th>
            <td>${emailBox.languages}</td>
            <td>${emailBox.pageSize}</td>
            <td>${emailBox.spamsFilter}</td>
            <td>${emailBox.signature}</td>
            <td><a class="btn btn-sm btn-secondary" href="/email/updateForm?id=${emailBox.id}">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

</html>
