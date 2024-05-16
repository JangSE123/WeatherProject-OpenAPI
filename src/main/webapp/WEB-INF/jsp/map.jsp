<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>주소 입력 페이지</title>
</head>
<body>
<h2>주소 입력 페이지</h2>
<form action="getGridXY" method="get">
    <label for="address">주소:</label>
    <input type="text" id="address" name="address" required>
    <button type="submit">그리드 XY 값 받아오기</button>
</form>
</body>
</html>
