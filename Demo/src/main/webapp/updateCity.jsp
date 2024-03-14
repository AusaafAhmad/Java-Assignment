<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update city</title>
<link rel="stylesheet" type="text/css" href="Style1.css">
</head>
<body>
<div class="container">
<% String name = (String)request.getAttribute("name");%>
<% String user = (String)request.getAttribute("user");%>
<% 
       request.getSession().setAttribute("user_val", user); 
 %>
<h2>Welcome : <%= name %> </h2>
<h3>User ID : <%= user %> </h3>
<h3>Update your City </h3>
<form action="Update" method="POST">
  <input type="text" id="ll" name="city" placeholder="City Name"><br><br>
  <input type="submit" value="Submit">
</form>
</div>
</body>
</html>