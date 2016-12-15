<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="head.jsp"/>

<h1>Modify book ${book.title} by ${book.author}</h1>
<br/>
<a href="delete?book=${book.id}">
    <button>
        Delete
    </button>
</a>

<jsp:include page="footer.jsp"/>