<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
<title>Welcome to Open Library</title>
</head>
<body>
<h2>Register or sign in</h2>
<form action="CreateAccount" method="post">
    <input type="text" name="name" placeholder="Username.." required="true" />
    <input type="password" name="password" placeholder="Password.." required="true"/>
    <input type="submit" value="Register" />
</form>
${userAlreadyExists}
<form action="Authenticate" method="post">
    <input type="text" name="name" placeholder="Username.." required="true" />
    <input type="password" name="password" placeholder="Password.." required="true"/>
    <input type="submit" value="Sign in" />
</form>
</body>
</html>
