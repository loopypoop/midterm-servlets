<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12.03.2021
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="registration.css">
    <jsp:include page="header.jsp" />

    <div class="text-center">
        <form class="form-signin" action="registration" method="post">
            <img src="https://scalebranding.com/wp-content/uploads/2020/06/a-j-letter-logo-scaled.jpg" alt="" width="140" height="140">
            <h1 class="h3 mb-3 font-weight-normal">Please sign up</h1>
            <label for="email" class="sr-only">Email address</label>
            <input name="email" type="email" id="email" class="form-control" placeholder="Email address" required="" autofocus="">

            <label for="password" class="sr-only">Password</label>
            <input name="password" type="password" id="password" class="form-control" placeholder="Password" required="">

            <label for="name" class="sr-only">Name</label>
            <input name="name" type="text" id="name" class="form-control" placeholder="Name" required="">

            <div class="form-group form-check">
                <input name="teacher" type="checkbox" class="form-check-input" id="teacher" value="true">
                <label class="form-check-label" for="teacher">Teacher</label>
            </div>

            <a href="login.jsp">Log in</a>

            <button class="btn btn-lg btn-dark btn-block mt-3" type="submit">Sign Up</button>
            <p class="mt-3 mb-3 text-muted">© 2021</p>
        </form>
    </div>
</body>
</html>
