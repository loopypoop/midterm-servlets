<%@ page import="uni.iitu.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <%@include file="header.jsp" %>

    <%
        User user = (User) session.getAttribute("user");
    %>

    <div align="center">
        <img src="https://dl.iitu.edu.kz/theme/image.php/classic/core/1615577403/u/f1" alt=""><br>
        <h3><%= user.getName() %></h3>
        <h4>Email: <%= user.getEmail() %></h4>
    </div>
</body>
</html>
