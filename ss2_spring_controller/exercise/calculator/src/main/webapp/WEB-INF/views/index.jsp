<%--
  Created by IntelliJ IDEA.
  User: QUOC NHAN
  Date: 11/21/2022
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="/calculator" method="post">
    <table>
      <tr>
        <td colspan="2"><input type="number" placeholder="First Operand" name="first_operand"></td>
        <td colspan="2"><input type="number" placeholder="Second Operand" name="second_operand"></td>
      </tr>
      <tr>
        <td><input type="submit" value="Addition(+)" name="operator"></td>
        <td><input type="submit" value="Subtraction(-)" name="operator"></td>
        <td><input type="submit" value="Multiplication(*)" name="operator"></td>
        <td><input type="submit" value="Division(/)" name="operator"></td>
      </tr>
    </table>
    <p>Hiển thị : ${result}</p>
  </form>
  </body>
</html>
