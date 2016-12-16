<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="head.jsp"/>

<h1>Modify book ${book.title} by ${book.author}</h1>
<br/>
<a href="delete?book=${book.id}">
    <button>
        Delete
    </button>
</a>
<br/>
<form action="modify" method="post">
    <label>Modify book no </label>
    <input type="text" name="book" value="${book.id}" readonly>
    <br/>
    <label>Title: </label>
    <input type="text" name="modifyBookTitle" value="${book.title}">
    <br/>
    <label>Author: </label>
    <input type="text" name="modifyBookAuthor" value="${book.author}">
    <br/>
    <label>Genre: </label>
    <select name="modifyBookGenre" >
        <option value="classic">Classic</option>
        <option value="not_classic">Not Classic</option>
    </select>
    <label>Current genre is: ${book.genre}</label>
    <br/>
    <input type="submit" value="Modify">
</form>

<jsp:include page="footer.jsp"/>