<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Subjects</title>
    <jsp:include page="header.jsp" />

<div align="center">
    <h2>List of Subject</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Grade</th>
        </tr>
        <c:forEach var="subject" items="${subjectList}">

            <tr>
                <td><c:out value="${subject.subjectId}" /></td>

                <c:if test="${user.teacher}">
                    <td><a href="TaskServlet?subjectId=${subject.subjectId}&studentId=${studentId}"><c:out value="${subject.subjectName}" /></a></td>
                </c:if>

                <c:if test="${!user.teacher}">
                    <td><a href="TaskServlet?subjectId=${subject.subjectId}"><c:out value="${subject.subjectName}" /></a></td>
                </c:if>

                <td><c:out value="${subject.grade}"/></td>

                <c:if test="${user.teacher}">
                    <td><a href="estimateTotal.jsp?subjectId=${subject.subjectId}&studentId=${studentId}">Estimate</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
