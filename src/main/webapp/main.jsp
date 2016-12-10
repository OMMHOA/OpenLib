<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Open Library</title>
</head>
<body>
    <h1>Welcome ${username} </h1>
    <h2>You are ${sessionScope.user.username}</h2>
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
