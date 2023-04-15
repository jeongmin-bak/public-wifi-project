<%@page import="db.wifiData"%>
<%@page import="db.wifiService"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>와이파이 정보 구하기</h1>
<a href="#">홈</a> | <a href="#">위치 히스토리 목록</a>
| <a href="#">Open API 와이파이 정보 가져오기</a> | <a href="#">즐겨 찾기 그룹 관리</a>
<br/>

<p> LAT: <input type="text"> , LNT: <input type="text">
<button> 내 위치 가져오기 </button>
<button> 근처 WIPI 정보 보기</button>
</p>

<%
        wifiService test = new wifiService();
        wifiData data = test.findWifi("37.4811992", "126.8955438");
%>

<table>
    <thead>
        <tr>
            <th>x좌표</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <% data.getX(); %>
            <% data.getTest(); %>
            <% test.test(); %>
        </tr>
    </tbody>
</table>
</body>
</html>