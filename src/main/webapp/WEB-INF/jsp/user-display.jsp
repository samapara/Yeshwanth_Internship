<%@ page import="com.shubham.Model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Details</title>
</head>
<body>

<%
    if (request.getAttribute("user") != null) {
        User user = (User) request.getAttribute("user");
%>
<h1>User Record</h1>
<div>Email: <%= user.getEmail()%>
</div>
<div>Name: <%= user.getName()%>
</div>

<%
} else {
%>

<h1>No User Record found.</h1>

}<% }%>
</body>

</body>
</html>
