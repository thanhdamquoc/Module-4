<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
${message}

<c:forEach items="${condiment}" var="c">
    ${c}
</c:forEach>
</body>
</html>
