<%--
  Created by IntelliJ IDEA.
  User: QUOC NHAN
  Date: 11/21/2022
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Display Seasoning With Sandwich</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="/sandwich" method="post">
    <input type="checkbox" name="condiment" value="Lettuce">
    <label>Lettuce</label>
    <input type="checkbox" name="condiment" value="Tomato">
    <label>Tomato</label>
    <input type="checkbox" name="condiment" value="Mustard">
    <label>Mustard</label>
    <input type="checkbox" name="condiment" value="Sprouts">
    <label>Sprouts</label>
    <br>
    <input type="submit" value="Submit">
  </form>

  <p>Result : ${result}</p>
  </body>
</html>
