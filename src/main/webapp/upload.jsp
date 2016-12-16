<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<h1>Upload a book</h1>
<a href="Authenticate">Back</a>

<form action="upload" method="post">
    <br/>
    <input type="text" name="newBookTitle" placeholder="Book title..">
    <br/>
    <input type="text" name="newBookAuthor" placeholder="Author..">
    <br/>
    <label>
        Genre:
    </label>
    <br/>
    <select name="newBookGenre" >
        <option value="classic">Classic</option>
        <option value="not_classic">Not Classic</option>
    </select>
    <br/>
    <input type="SUBMIT" value="Upload">
</form>
</body>
</html>
