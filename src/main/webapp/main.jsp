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
    <form action="logout" method="post">
        <input type="submit" value="log out">
    </form>
    <form action="Main" method="post">
        <label><h2>Find books owned by: </h2></label>
        <select name="owner">
            <c:forEach items="${users}" var="user">
                <option value="${user.username}">${user.username}</option>
            </c:forEach>
        </select>
        <input type="submit" value="List">
    </form>
    <br/>
    <table>
        <thead>
            <tr>
                <td>Author</td>
                <td>Title</td>
                <td>Genre</td>
                <td>Owner</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.author}</td>
                    <td>${book.title}</td>
                    <td>${book.genre}</td>
                    <td>${book.owner.username}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
