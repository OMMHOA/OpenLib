<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Open Library</title>
</head>
<body>
    <h1>Welcome ${username} </h1>
    <form action="upload" method="post">
        <label>Upload a book</label>
        <br/>
        <input type="text" name="title" placeholder="Book title..">
        <br/>
        <input type="text" name="author" placeholder="Author..">
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
