<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Address Search</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        #searching {
            margin-top: 100px;
            font-size: 50px;
            color: #333;
        }
        #search-wrapper {
            margin-top: 20px;
        }
        input[type="text"] {
            padding: 10px;
            border: 2px solid #ccc;
            border-radius: 10px;
            border-color: black;
            font-size: 16px;
            width: 300px;
            font-family: 'Source Sans Pro', sans-serif;
            font-weight: bold;
            text-align: center;
        }
        button[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.5s ease;
        }
        /* Placeholder 스타일 */
        input[type="text"]::placeholder {
            color: #ccc; /* placeholder의 색상을 회색 또는 원하는 색상으로 지정 */
        }
        button[type="submit"]:hover {
            background-color: #205e20;
        }
        #error {
            color: red;
            margin-top: 10px;
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

        #result-container {
            margin-top: 50px;
            border: 2px solid #ccc;
            width: 60%;
            height: 400px;
            margin-left: auto;
            margin-right: auto;
            overflow: hidden;
        }

    </style>
</head>
<body>
<h2 id="searching">날씨 검색</h2>
<div id="search-wrapper">
    <form action="/search" method="post">
        <input type="text" name="address" placeholder="검색할 주소를 입력하세요">
        <button type="submit">검색</button>
    </form>
    <c:out value="${error}" id="error"/>
</div>
<div id = 'result-container'>

</div>

</body>
<footer>
    &copy; 2024 Weather Search
</footer>
</html>