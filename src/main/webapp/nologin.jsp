<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<a href="/openlib">Back</a>
<form action="Main" method="post">
    <select name="owner">
        <option value="all">List all books</option>
        <c:forEach items="${sessionScope.users}" var="user">
            <option value="${user.username}">${user.username}</option>
        </c:forEach>
    </select>
    <input type="submit" value="List">
</form>
<br/>
<form action="Main" method="post">
    <input type="text" name="title" placeholder="Search by title..">
    <input type="submit" value="Search">
</form>
<form action="Main" method="post">
    <input type="text" name="author" placeholder="Search by author..">
    <input type="submit" value="Search">
</form>
<table>
    <thead>
    <tr>
        <td>Author</td>
        <td>Title</td>
        <td>Genre</td>
        <td>Owner</td>
        <c:if test="${sessionScope.user != null}"> <td>Options</td> </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.books}" var="book">
        <tr>
            <td>${book.author}</td>
            <td>${book.title}</td>
            <td>${book.genre}</td>
            <td>${book.owner.username}</td>
            <c:if test="${sessionScope.user != null &&
             book.owner.username == sessionScope.user.username}">
                <td>
                    <a href="modify?book=${book.id}">Modify</a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>