<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${data.records}" var="news">
        <div><a href="${pageContext.request.contextPath}/admin/news/listContentById?newsId=${news.id}">${news.title}</a></div>
    </c:forEach>
</body>
</html>
