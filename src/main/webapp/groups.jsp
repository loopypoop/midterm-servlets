<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Groups</title>
    <jsp:include page="header.jsp" />

    <div align="center">
        <h2>List of Group</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Group</th>
            </tr>
            <c:forEach var="group" items="${groupList}">

                <tr>
                    <td><c:out value="${group.id}" /></td>
                    <td><a href="GroupServlet?groupId=${group.id}"><c:out value="${group.name}" /></a></td>

                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
