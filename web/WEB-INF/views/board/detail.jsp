<%--
  Created by IntelliJ IDEA.
  User: kitae
  Date: 2024-02-21
  Time: 오후 4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>detail.jsp</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <td>${board.id}</td>
    </tr>
    <tr>
        <th>writer</th>
        <td>${board.boardWriter}</td>
    </tr>
    <tr>
        <th>date</th>
        <td>${board.boardCreatedTime}</td>
    </tr>
    <tr>
        <th>hits</th>
        <td>${board.boardHits}</td>
    </tr>
    <tr>
        <th>title</th>
        <td>${board.boardTitle}</td>
    </tr>
    <tr>
        <th>contents</th>
        <td>${board.boardContents}</td>
    </tr>
</table>
<button onclick="listFn()">목록</button>
<button onclick="updateFn()">수정</button>
<button onclick="deleteFn()">삭제</button>

<!-- 댓글 처리하는 부분 -->
<div>
    <input type="text" id="commentWriter" placeholder="작성자">
    <input type="text" id="commentContents" placeholder="내용">
    <button id="comment-write-btn" onclick="commentWrite()">댓글작성</button>
</div>

<div id="comment-list">
    <table>
        <tr>
            <th>댓글번호</th>
            <th>작성자</th>
            <th>내용</th>
            <th>작성시간</th>
        </tr>
        <c:forEach items="${commentList}" var="comment">
            <tr>
                <td>${comment.id}</td>
                <td>${comment.commentWriter}</td>
                <td>${comment.commentContents}</td>
                <td>${comment.commentCreatedTime}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script>
    const listFn = () => {
        const page = '${page}';
        location.href = "/board/paging?page=" + page;
    }
    const updateFn = () => {
        const id = '${board.id}';
        location.href = "/board/update?id=" + id;
    }
    const deleteFn = () => {
        const id = '${board.id}';
        location.href = "/board/delete?id=" + id;
    }

    // 댓글 작성 기능
    const commentWrite = () => {
        const writer = document.getElementById("commentWriter").value;
        const contents = document.getElementById("commentContents").value;
        const boardId = '${board.id}';   //

        $.ajax({
            type: "post",
            url: "/comment/save",
            data: {
                commentWriter: writer,
                commentContents: contents,
                boardId: boardId
            },
            dataType: "json",
            success: function(commentList) {
                alert("작성성공");
                console.log(commentList);

                // 결과 출력을 위한 테이블 생성
                let output = "<table>";
                output += "<tr><th>댓글번호</th>";
                output += "<th>작성자</th>";
                output += "<th>내용</th>";
                output += "<th>작성시간</th></tr>";
                for(let i in commentList){
                    output += "<tr>";
                    output += "<td>"+commentList[i].id+"</td>";
                    output += "<td>"+commentList[i].commentWriter+"</td>";
                    output += "<td>"+commentList[i].commentContents+"</td>";
                    output += "<td>"+commentList[i].commentCreatedTime+"</td>";
                    output += "</tr>";
                }
                output += "</table>";
                document.getElementById('comment-list').innerHTML = output;
                document.getElementById('commentWriter').value='';
                document.getElementById('commentContents').value='';
            },
            error: function() {
                alert("댓글 등록 실패");
            }
        });
    }
</script>
</html>