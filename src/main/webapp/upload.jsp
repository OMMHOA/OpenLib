<%--
  Created by IntelliJ IDEA.
  User: OMMHOA
  Date: 2016. 12. 12.
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<form action="upload" method="post">
    <label><h2>Upload a book</h2></label>
    <br/>
    <input type="text" name="title" placeholder="Book title..">
    <br/>
    <input type="text" name="author" placeholder="Author..">
    <br/>
    <label>
        Genre:
    </label>
    <br/>
    <select name="genre" >
        <option value="classic">Classic</option>
        <option value="not_classic">Not Classic</option>
    </select>
    <br/>
    <input type="SUBMIT" value="Upload">
</form>
</body>
</html>
