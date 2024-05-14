<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Weather Search</title>
</head>
<body>
<style>
    table {
        border-collapse: collapse;
        border: 0;
    }
    th,
    td {
        border: 2px solid #aaa;
    }
    th {
        background-color: #f8f8f8;
    }
</style>
<h3>기상청 오픈 API를 활용한 날씨 검색결과</h3>
<a href="/weather">돌아가기</a>
<table>
    <thead>
    <tr>
        <th scope="col">날짜</th>
        <th scope="col">시간</th>
        <th scope="col">카테고리</th>
        <th scope="col">발표날짜</th>
        <th scope="col">발표시간</th>
        <th scope="col">발표값</th>
        <th scope="col">NX</th>
        <th scope="col">NY</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${weathers}" var="weather">
        <tr>
            <td><c:out value="${weather.baseDate}"/> </td>
            <td><c:out value="${weather.baseTime}"/> </td>
            <td><c:out value="${weather.category}"/> </td>
            <td><c:out value="${weather.fcstDate}"/> </td>
            <td><c:out value="${weather.fcstTime}"/> </td>
            <td><c:out value="${weather.fcstValue}"/> </td>
            <td><c:out value="${weather.nx}"/> </td>
            <td><c:out value="${weather.ny}"/> </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>