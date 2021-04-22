<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="user" class="uni.iitu.entity.User" scope="session"/>
<jsp:setProperty name="user" property="*"/>
<html>
<head>
    <title>Task List</title>
    <jsp:include page="header.jsp"/>

    <div class="container">


        <div align="center">
            <h2>List of Task</h2>

            <table class="table" style="width: 60%">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Topic</th>
                    <th scope="col">Grade</th>
                    <% if (user.isTeacher()) { %>
                    <th scope="col"> </th>
                    <% } %>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="task_user" items="${tasks}">
                    <tr>
                        <th scope="row"><a href="SpecificTaskServlet?taskId=${task_user.task.id}"><c:out
                                value="${task_user.task.id}"/></a></th>
                        <td><c:out value="${task_user.topic}"/></td>

                        <td><c:out value="${task_user.grade}"/></td>

                        <c:if test="${user.teacher}">
                            <td>
                                <a href="estimateTask.jsp?taskId=${task_user.task.id}&studentId=${studentId}&subjectId=${subjectId}">Estimate</a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
    </body>
</html>
