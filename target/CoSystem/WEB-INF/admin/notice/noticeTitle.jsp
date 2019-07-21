<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${data.records}" var="notice">
        <div><a href="${pageContext.request.contextPath}/admin/notice/listContentById?noticeId=${notice.id}">${notice.title}</a></div>
    </c:forEach>
</body>
</html>
