<%--
  Created by IntelliJ IDEA.
  User: 김기태
  Date: 2024-02-17
  Time: 오전 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- 부트스트랩 추가 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <title>list</title>
    <style>
        table {
            text-align: center;
            font-family: "Montserrat", sans-serif;
            font-size: 1rem;
        }
        .td-left {
            text-align: left;
        }
    </style>
</head>
<body>
<table class="table table-hover" style="width: 80%; margin: 20px auto 0 auto">
    <thead class="table-dark">
        <tr>
            <th scope="col">id</th>
            <th scope="col">email</th>
            <th scope="col">password</th>
            <th scope="col">name</th>
            <th scope="col">age</th>
            <th scope="col">mobile</th>
            <th scope="col">조회</th>
            <th scope="col">삭제</th>
        </tr>
    </thead>
    <c:forEach items="${memberList}" var="member">
        <tr>
            <td>${member.id}</td>
            <td class="td-left">
                <%-- 쿼리 스트링 형태 사용--%>
                <a href="/member/detail?id=${member.id}">${member.memberEmail}</a>
            </td>
            <td>${member.memberPassword}</td>
            <td>${member.memberName}</td>
            <td>${member.memberAge}</td>
            <td class="td-left">${member.memberMobile}</td>
            <td>
                <%--<a href="/member/detail?id=${member.id}">조회</a>--%>
                <button type="button" class="btn btn-success" onclick="location.href='/member/detail?id=${member.id}' ">조회</button>
            </td>
            <td>
                <button class="btn btn-primary" onclick="deleteMember('${member.id}')">삭제</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<script>
    const deleteMember = (id) => {
        console.log(id);
        location.href = "/member/delete?id="+id;
    }
</script>
</html>