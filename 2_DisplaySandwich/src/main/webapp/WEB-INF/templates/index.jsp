<%--
  Created by IntelliJ IDEA.
  User: ThanhDQ
  Date: 6/14/2021
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>

  <form action="/sandwich/save" method="post">
    <input type="checkbox" name="condiment" value="lettuce">
    <label>Lettuce</label><br>
    <input type="checkbox" name="condiment" value="tomato">
    <label>Tomato</label><br>
    <input type="checkbox" name="condiment" value="mustard">
    <label>Mustard</label><br>
    <input type="checkbox" name="condiment" value="sprouts">
    <label>Sprouts</label><br><br>
    <input type="submit" value="Submit">
  </form>

  </body>
</html>
