<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="/calculator" method="post">
    <label>Number 1</label>
    <input type="text" placeholder="Number 1" name="num1" value="${num1}"><br>
    <label>Number 2</label>
    <input type="text" placeholder="Number 2" name="num2" value="${num2}"><br>
    <label>Result</label>
    <input type="text" readonly value="${result}" placeholder="Result"><br>
    <input type="submit" name="operator" value="Add">
    <input type="submit" name="operator" value="Subtract">
    <input type="submit" name="operator" value="Multiply">
    <input type="submit" name="operator" value="Divide">
  </form>
  </body>
</html>
