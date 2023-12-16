<%--
  Created by IntelliJ IDEA.
  User: eblee
  Date: 2023-12-16
  Time: 오후 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h1>View Form</h1>
<p>Category: ${list.category}</p>
<p>Title: ${list.title}</p>
<p>Writer: ${list.writer}</p>
<p>Content: ${list.content}</p>
<button type="button" onclick="location.href='../list'">목록으로</button>
</body>
