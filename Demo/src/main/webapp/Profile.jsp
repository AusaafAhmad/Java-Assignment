<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile page</title>
<link rel="stylesheet" type="text/css" href="Style1.css">
</head>
<body>
<div class="container">
<% String name = (String)request.getAttribute("name");%>
<% String city = (String)request.getAttribute("city");%>
<% String user = (String)request.getAttribute("user");%>
<% 
       request.getSession().setAttribute("user_val", user); 
	request.getSession().setAttribute("name_val", name); 
 %>

<h3>Welcome : <%= name %> </h3><br>
<h3>You're from : <%= city %> </h3>
<br>
<form action="Update" method="GET">
<button type="submit">Update city</button>
</form>
<br>
<form action="Delete" method="POST" class=del>
<button type="submit" onclick="check()">Delete User</button>
</form>
 <script>
        function check() {
            let result = confirm("You sure you want to delete this account?");
            if (result) {
            	window.alert("Account Deleted");
            } 
        }
    </script>
   </div>
</body>
</html>