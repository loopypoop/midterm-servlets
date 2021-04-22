<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="user" class="uni.iitu.entity.User" scope="session"/>
<jsp:setProperty name="user" property="*"/>
<html>
<head>
    <title>Subjects</title>
    <jsp:include page="header.jsp"/>

    <div class="container">


        <div align="center">
            <h2>List of Subject</h2>

            <table class="table" style="width: 60%">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Grade</th>
                    <% if (user.isTeacher()) { %>
                    <th scope="col"> </th>
                    <% } %>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="subject" items="${subjectList}">
                    <tr>
                        <th scope="row"><c:out value="${subject.subjectId}"/></th>
                        <c:if test="${user.teacher}">
                            <td><a href="TaskServlet?subjectId=${subject.subjectId}&studentId=${studentId}"><c:out
                                    value="${subject.subjectName}"/></a></td>
                        </c:if>

                        <c:if test="${!user.teacher}">
                            <td><a href="TaskServlet?subjectId=${subject.subjectId}"><c:out
                                    value="${subject.subjectName}"/></a></td>
                        </c:if>

                        <td><c:out value="${subject.grade}"/></td>

                        <c:if test="${user.teacher}">
                            <td>
                                <a href="estimateTotal.jsp?subjectId=${subject.subjectId}&studentId=${studentId}">Estimate</a>
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
