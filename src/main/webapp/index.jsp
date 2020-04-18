<%@ page import="com.shubham.utils.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-grid.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container login-container">
    <div class="overlap"> OR</div>
    <div class="row">
        <div class="col-md-6 login-form-1">
            <h3>Sign In</h3>
            <form method="post" action="/login">
                <div class="form-group">
                    <input type="email" class="form-control" name="email" placeholder="Your Email *" value="" required/>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="Your Password *" value=""
                           required/>
                </div>
                <div class="form-group text-center">
                    <input type="submit" class="btnSubmit" value="Sign In"/>
                </div>
                <div class="form-group">
                    <a href="#" class="ForgetPwd">Forgot Password?</a>
                </div>
            </form>
        </div>
        <div class="col-md-6 login-form-2">
            <h3>Sign Up</h3>
            <form action="/signup" method="post">
                <div class="form-group">
                    <input type="text" name="name" class="form-control" placeholder="Your Name *" value="" required/>
                </div>
                <div class="form-group">
                    <input type="email" name="email" class="form-control" placeholder="Your Email *" value="" required/>
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="Your Password *" value=""
                           required/>
                </div>
                <div class="form-group text-center">
                    <input type="submit" class="btnSubmit" value="Sign Up"/>
                </div>

                <% if (request.getAttribute("status") != null) {
                    String status = (String) request.getAttribute("status");
                    System.out.println(status);
                    if (status.equals("Success")) {
                %>
                <p class="text-success"> User Registered Successful, Login to continue. </p>
                <% } else if (status.equals(Constants.USERALREADYEXISTS)) { %>
                <p class="text-danger">* User Already Registered </p>
                <% } else {%>
                <p class="text-warning"> Unknown error occurred. Try Again. </p>
                <% } } %>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.bundle.js"></script>
</body>
</html>
