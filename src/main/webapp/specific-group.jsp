<%@ page import="uni.iitu.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Group</title>
    <%@include file="header.jsp" %>

        <%
    List<User> group = (List<User>) request.getAttribute("group");
    %>
    <div class="container">


        <div align="center">
            <h2>List of Students</h2>
<%--            <table border="1" cellpadding="5">--%>
<%--                <tr>--%>
<%--                    <th>ID</th>--%>
<%--                    <th>Name</th>--%>
<%--                </tr>--%>
<%--                <% for (User student : group) { %>--%>

<%--                <tr>--%>
<%--                    <td><%= user.getId() %>--%>
<%--                    </td>--%>
<%--                    <td><a href="SubjectServlet?studentId=<%= student.getId() %>"><%= student.getName() %>--%>
<%--                    </a></td>--%>
<%--                </tr>--%>
<%--                <% } %>--%>
<%--            </table>--%>

            <table class="table" style="width: 20%">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                </tr>
                </thead>
                <tbody>
                <% for (User student : group) { %>
                <tr>
                    <th scope="row"><%= user.getId() %></th>
                    <td><a href="SubjectServlet?studentId=<%= student.getId() %>"><%= student.getName() %>
                    </a></td>
                </tr>
                <% } %>
                </tbody>
            </table>

        </div>
    </div>
    </body>
</html>
