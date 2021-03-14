<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Group</title>
    <jsp:include page="header.jsp" />

    <div align="center">
        <h2>List of Students</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
            <c:forEach var="student" items="${group}">

                <tr>
                    <td><c:out value="${student.id}" /></td>
                    <td><a href="SubjectServlet?studentId=${student.id}"><c:out value="${student.name}" /></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
