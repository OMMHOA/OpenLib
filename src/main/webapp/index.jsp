<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
<title>Welcome to Open Library</title>
</head>
<body>
<h2>Register or sign in</h2>
<form action="CreateAccount" method="post">
    <input type="text" name="name" placeholder="Username.." required />
    <input type="password" name="password" placeholder="Password.." required />
    <input type="submit" value="Register" />
</form>
${userAlreadyExists}
<form action="main" method="post">
    <input type="text" name="name" placeholder="Username.." required />
    <input type="password" name="password" placeholder="Password.." required />
    <input type="submit" value="Sign in" />
</form>
${loginFailed}
</body>
</html>
