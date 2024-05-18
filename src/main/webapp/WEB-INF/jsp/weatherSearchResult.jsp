<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.example.project.model.ChangeValueVO" %>
<%@ page import="com.example.project.model.WeatherInfoVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Weather Search</title>
    </head>
    <body>
    <%
        ChangeValueVO changeValue = new ChangeValueVO();
        List<WeatherInfoVO> weathers = (List<WeatherInfoVO>) request.getAttribute("weathers");
    %>
    <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                text-align: center;
            }
            table {
                border-collapse: collapse;
                width: 70%;
                margin-top: 20px;
            }
            th, td {
                border: 2px solid #aaa;
                padding: 8px;
                text-align: center;
            }
            th {
                background-color: #f8f8f8;
            }
            a {
                text-decoration: none;
                color: #333;
                font-weight: bold;
            }
            #searching-result {
                margin-top: 100px;
                font-size: 50px;
                color: #333;
            }
            /* 푸터 스타일 */
            footer {
                background-color: #333;
                color: #fff;
                padding: 20px 0;
                position: fixed;
                bottom: 0;
                width: 100%;
            }
            /* 링크 스타일 */
            a {
                display: inline-block;
                padding: 10px 20px;
                background-color: #242924;
                color: white;
                border-radius: 20px;
                text-decoration: none;
                font-size: 16px;
                transition: background-color 0.5s ease;
            }
            a:hover {
                background-color: #205e20;
            }
        </style>
        <h3 id ="searching-result">기상청 오픈 API를 활용한 날씨 검색결과</h3>
        <a href="/weather">다른 주소 검색하기</a>

        <table>
            <thead>
                <tr>
                    <th>시간</th>
                    <th>온도</th>
                    <th>하늘상태</th>
                    <th>습도122</th>
                    <th>강수량<span style="font-size: 80%;">(h)</span></th>
                    <th>강수형태</th>
                    <th>풍향</th>
                </tr>
<%--                <tr>--%>
<%--                    <th>발표시간</th>--%>
<%--            &lt;%&ndash;        <th><c:out value="${weathers[0].category}"/>낙뢰</th>&ndash;%&gt;--%>
<%--                    <th><c:out value="${weathers[6].category}"/>강수형태</th>--%>
<%--                    <th><c:out value="${weathers[12].category}"/>1시간 강수량</th>--%>
<%--                    <th><c:out value="${weathers[18].category}"/>하늘상태</th>--%>
<%--                    <th><c:out value="${weathers[24].category}"/>°C</th>--%>
<%--                    <th><c:out value="${weathers[30].category}"/>습도</th>--%>
<%--            &lt;%&ndash;        <th><c:out value="${weathers[36].category}"/>(%)</th>&ndash;%&gt;--%>
<%--            &lt;%&ndash;        <th><c:out value="${weathers[42].category}"/></th>&ndash;%&gt;--%>
<%--                    <th><c:out value="${weathers[48].category}"/>풍향</th>--%>
<%--                </tr>--%>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < 6; i++) {
                    out.println("<tr>");
                    out.println("<td>" + changeValue.formatTime(weathers.get(i).getFcstTime()) + "</td>");
                    out.println("<td>" + weathers.get(i + 24).getFcstValue() + "°C</td>");
                    out.println("<td>" + changeValue.changeSKYValue(weathers.get(i + 18).getFcstValue()) + "</td>");
                    out.println("<td>" + weathers.get(i + 30).getFcstValue() + "%</td>");
                    out.println("<td>" + weathers.get(i + 12).getFcstValue() + "<span style=\"font-size: 80%;\">(mm)</span></td>");
                    out.println("<td>" + changeValue.changePTYValue(weathers.get(i + 6).getFcstValue()) + "</td>");
                    out.println("<td>" + changeValue.changeWSDValue(weathers.get(i + 48).getFcstValue()) + "</td>");
                    out.println("</tr>");
                }
            %>
            </tbody>
        </table>
    </body>
    <footer>
        &copy; 2024 Weather Search
    </footer>
</html>


<%--<table>--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th scope="col">날짜</th>--%>
<%--        <th scope="col">시간</th>--%>
<%--        <th scope="col">카테고리</th>--%>
<%--        <th scope="col">발표날짜</th>--%>
<%--        <th scope="col">발표시간</th>--%>
<%--        <th scope="col">발표값</th>--%>
<%--        <th scope="col">NX</th>--%>
<%--        <th scope="col">NY</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach items="${weathers}" var="weather">--%>
<%--        <tr>--%>
<%--            <td><c:out value="${weather.baseDate}"/> </td>--%>
<%--            <td><c:out value="${weather.baseTime}"/> </td>--%>
<%--            <td><c:out value="${weather.category}"/> </td>--%>
<%--            <td><c:out value="${weather.fcstDate}"/> </td>--%>
<%--            <td><c:out value="${weather.fcstTime}"/> </td>--%>
<%--            <td><c:out value="${weather.fcstValue}"/> </td>--%>
<%--            <td><c:out value="${weather.nx}"/> </td>--%>
<%--            <td><c:out value="${weather.ny}"/> </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>

