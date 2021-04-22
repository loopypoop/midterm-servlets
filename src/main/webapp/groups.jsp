<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Groups</title>
    <jsp:include page="header.jsp"/>

    <div class="container">


        <div align="center">
            <h2>List of Group</h2>
            <%--<table border="1" cellpadding="5">--%>
            <%--    <tr>--%>
            <%--        <th>ID</th>--%>
            <%--        <th>Group</th>--%>
            <%--    </tr>--%>
            <%--    <c:forEach var="group" items="${groupList}">--%>


            <%--        <tr>--%>
            <%--            <td><c:out value="${group.id}"/></td>--%>
            <%--            <td><a href="GroupServlet?groupId=${group.id}"><c:out value="${group.name}"/></a></td>--%>

            <%--        </tr>--%>
            <%--    </c:forEach>--%>
            <%--</table>--%>

            <table class="table" style="width: 20%">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Group</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="group" items="${groupList}">
                    <tr>
                        <th scope="row"><c:out value="${group.id}"/></th>
                        <td><a href="GroupServlet?groupId=${group.id}"><c:out value="${group.name}"/></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
    </body>
</html>
