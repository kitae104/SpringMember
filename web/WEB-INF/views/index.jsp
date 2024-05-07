<%--
  Created by IntelliJ IDEA.
  User: 김기태
  Date: 2024-02-11
  Time: 오후 7:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>시작 페이지</title>
    <link href="/resources/css/index.css" rel="stylesheet"/>
</head>
<body>
    <h2 class="index-title">Spring Framework 프로젝트</h2>
    <div class="menu">
        <ul class="menu-items">
            <li class="menu-item">
                <a href="/member/save">회원가입</a>
            </li>
            <li class="menu-item">
                <a href="/member/login">로그인</a>
            </li>
            <li class="menu-item">
                <a href="/member/list">회원목록 조회</a>
            </li>
            <li class="menu-item">
                <a href="/board/save">게시글 작성</a>
            </li>
            <li class="menu-item">
                <a href="/board/list">게시글 목록</a>
            </li>
            <li class="menu-item">
                <a href="/board/paging">페이징 목록</a>
            </li>
        </ul>
    </div>


</body>
</html>
