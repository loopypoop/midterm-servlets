<%@ page import="uni.iitu.entity.User" %>
<%@ page import="uni.iitu.dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
</head>
<body>

    <%
    User user = (User) session.getAttribute("user");
    %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="home.jsp">Home</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <%--            <c:if test="${user != null}">--%>
            <% if (user != null) { %>
            <li class="nav-item">
                <a class="nav-link" href="profile.jsp">Profile</a>
            </li>
            <%--            <c:if test="${!user.teacher}">--%>
            <% if (!user.isTeacher()) { %>

            <li class="nav-item">
                <a class="nav-link" href="SubjectServlet">My grades</a>
            </li>
            <%--            </c:if>--%>
            <% } %>
            <%--            <c:if test="${user.teacher}">--%>
            <% if (user.isTeacher()) { %>
            <li class="nav-item">
                <a class="nav-link" href="GroupListServlet">Groups</a>
            </li>
            <% } %>
            <%--            </c:if>--%>
            <li class="nav-item">
                <a class="nav-link" href="LogoutServlet">Logout</a>
            </li>
            <%--            </c:if>--%>
            <% } %>
<%--            <c:if test="${user == null}">--%>
                <% if (user == null) { %>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Log in</a>
                </li>
                <% } %>
<%--            </c:if>--%>
        </ul>
    </div>

</nav>
