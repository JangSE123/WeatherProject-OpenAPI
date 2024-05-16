<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Map Search Result</title>
</head>
<body>
<h1>Map Search Result</h1>
<c:if test="${not empty grid}">
    <p>Grid X: ${grid[0]}, Grid Y: ${grid[1]}</p>
</c:if>
</body>
</html>
