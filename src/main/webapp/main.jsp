<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Open Library</title>
</head>
<body>
    <h1>Welcome ${sessionScope.user.username} </h1>
    <a href="upload.jsp">Upload a book</a>
    <br/>
    <table>
        <thead>
            <tr>
                <td>Author</td>
                <td>Title</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.author}</td>
                    <td>${book.title}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
