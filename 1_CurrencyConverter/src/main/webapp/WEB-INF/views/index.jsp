<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<form action="/converter" method="post">
    <label>USD Amount:</label>
    <input type="text" name="usdAmount" value="${usdAmount}"><br>
    <label>Rate: 20,000</label><br>
    <label>VND Amount: </label>
    <input readonly type="text" value="${result}"><br>
    <input type="submit">
</form>
</body>
</html>
