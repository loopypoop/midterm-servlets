<%@ page import="uni.iitu.entity.Group" %>
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
    <div align="center">
        <h2>List of Students</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
<%--            <c:forEach var="student" items="${group}">--%>
            <% for (User user: group) { %>

                <tr>
<%--                    <td><c:out value="${student.id}" /></td>--%>
                    <td><%= user.getId() %></td>
                    <td><a href="SubjectServlet?studentId=<%= user.getId() %>"><%= user.getName() %>"/></a></td>
                </tr>
                <% } %>
<%--            </c:forEach>--%>
        </table>
    </div>
</body>
</html>
