<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Weather Search</title>
</head>
<body>
<style>
    input {
        margin: 2px;
    }
</style>
<h3>기상청 오픈 API를 활용한 단기 날씨 현황 검색 하기 </h3>
<table>
    <form action="/weathersearch">
        현재 날짜  : <input name='baseDate' type='text' required/>
        현재 시간  : <input name='baseTime' type='text' required/>
        그리드 X  : <input name='Nx' type='text' required/>
        그리드 Y  : <input name='Ny' type='text' required/>
        <input type="submit" value="검색하기">
    </form>
</table>

</body>
</html>