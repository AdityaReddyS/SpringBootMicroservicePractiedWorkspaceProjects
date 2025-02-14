<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Page</title>
</head>
<body>
<h1 style='color:red;text-align:center'>Check Balance </h1>
<b>your Balance amount is::<%=new Random().nextInt(1000000) %></b><br><br>
<a href="./">Home</a><br>
                       <a href="signout">Logout</a>

</body>
</html>