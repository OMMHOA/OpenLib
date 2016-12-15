<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
<title>Welcome to Open Library</title>
</head>
<body>
<h1>Register or sign in</h1>
<h2>Register</h2>
<form action="CreateAccount" method="post">
    <input type="text" name="name" placeholder="Username.." required />
    <input type="password" name="password" placeholder="Password.." required />
    <input type="submit" value="Register" />
</form>
${userAlreadyExists}
<h2>Sign in</h2>
<form action="Authenticate" method="post">
    <input type="text" name="name" placeholder="Username.." required />
    <input type="password" name="password" placeholder="Password.." required />
    <input type="submit" value="Sign in" />
</form>
${loginFailed}
<form action="guest" method="get">
    <input type="submit" value="Continue as guest">
</form>
</body>
</html>
