<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="login.css">
    <%@include file="header.jsp" %>

    <div class="text-center">
        <form class="form-signin" action="login" method="post">
            <img src="https://scalebranding.com/wp-content/uploads/2020/06/a-j-letter-logo-scaled.jpg" alt="" width="140" height="140">
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <label for="email" class="sr-only">Email address</label>
            <input name="email" type="email" id="email" class="form-control" placeholder="Email address" required="" autofocus="">
            <label for="password" class="sr-only">Password</label>
            <input name="password" type="password" id="password" class="form-control mb-2" placeholder="Password" required="">
            <a href="registration.jsp">Registration</a>

            <button class="btn btn-lg btn-dark btn-block mt-3" type="submit">Sign in</button>
            <p class="mt-3 mb-3 text-muted">© 2021</p>
        </form>
    </div>
</body>

<script type="text/javascript">

    $(document).ready(function () {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },

                password: "required",
            },

            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },

                password: "Please enter password"
            }
        });

    });
</script>

</html>
