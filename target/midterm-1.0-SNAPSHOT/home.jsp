<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11.03.2021
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <jsp:include page="header.jsp" />

    <div style="text-align: center">
        <h1>Welcome to Adil's Web School</h1>
        <b>${user.name} (${user.email})</b>
    </div>
</body>
</html>
