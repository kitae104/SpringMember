<%--
  Created by IntelliJ IDEA.
  User: 김기태
  Date: 2024-02-11
  Time: 오후 7:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 가입 페이지</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link href="/resources/css/member.css" rel="stylesheet"/>
</head>
<body>
<div class="member-save">
    <h2 class="member-title">회원 가입 페이지</h2>
    <form action="/member/save" method="post" class="member-form">
        <div>
            <label for="email">이메일</label>
            <input type="text" name="memberEmail" placeholder="이메일" id="memberEmail" onblur="emailCheck()">
        </div>
        <%--<p id="check-result"></p>--%>
        <label for="email">비밀번호</label>
        <input type="text" name="memberPassword" placeholder="비밀번호">
        <label for="email">이름</label>
        <input type="text" name="memberName" placeholder="이름">
        <label for="email">나이</label>
        <input type="text" name="memberAge" placeholder="나이">
        <label for="email">전화번호</label>
        <input type="text" name="memberMobile" placeholder="전화번호">
        <input class="button" type="submit" value="회원가입">
    </form>
</div>
</body>

<script>
    const emailCheck = () => {
        const email = document.querySelector("#memberEmail").value;
        const checkResult = document.querySelector("#check-result");
        $.ajax({
            type: "post",
            url: "/member/email-check",
            data: {
                "memberEmail": email
            },
            success: function (res) {
                console.log("요청 성공 : ", res);
                if (res == "YES") {
                    checkResult.style.color = "green";
                    checkResult.innerHTML = "사용가능한 메일";
                } else {
                    checkResult.style.color = "red";
                    checkResult.innerHTML = "이미 사용중인 메일";
                }
            },
            error: function (err) {
                console.log("에러 발생", err);
            }
        });
    }
</script>

</html>
