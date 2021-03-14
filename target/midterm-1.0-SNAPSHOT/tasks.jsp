<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Task List</title>
    <jsp:include page="header.jsp" />

    <div align="center">
        <h2>List of Task</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Topic</th>
                <th>Grade</th>
            </tr>
            <c:forEach var="task_user" items="${tasks}">

                <tr>
                    <td><a href="SpecificTaskServlet?taskId=${task_user.task.id}"><c:out value="${task_user.task.id}" /></a></td>

                    <td><c:out value="${task_user.topic}" /></td>

                    <td><c:out value="${task_user.grade}"/></td>

                    <c:if test="${user.teacher}">
                        <td><a href="estimateTask.jsp?taskId=${task_user.task.id}&studentId=${studentId}&subjectId=${subjectId}">Estimate</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
