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
    <title>사용자 저장 페이지</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
    <h2>사용자 정보 저장 페이지</h2>
    <form action="/member/save" method="post">
        <input type="text" name="memberEmail" placeholder="이메일" id="memberEmail" onblur="emailCheck()">
        <p id="check-result"></p>
        <input type="text" name="memberPassword" placeholder="비밀번호">
        <input type="text" name="memberName" placeholder="이름">
        <input type="text" name="memberAge" placeholder="나이">
        <input type="text" name="memberMobile" placeholder="전화번호">
        <input type="submit" value="회원가입">
    </form>
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
            success: function(res){
               console.log("요청 성공 : ", res);
               if(res == "YES"){
                   checkResult.style.color = "green";
                   checkResult.innerHTML = "사용가능한 메일";
               } else {
                   checkResult.style.color = "red";
                   checkResult.innerHTML = "이미 사용중인 메일";
               }
            },
            error: function(err){
               console.log("에러 발생", err);
            }
        });
    }
</script>

</html>
