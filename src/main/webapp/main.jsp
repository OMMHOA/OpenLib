<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="head.jsp"/>
<h1>Welcome ${sessionScope.user.username} </h1>
<a href="upload.jsp">Upload a book</a>
<form action="logout" method="post">
    <input type="submit" value="log out">
</form>
<jsp:include page="nologin.jsp"/>
<jsp:include page="footer.jsp"/>