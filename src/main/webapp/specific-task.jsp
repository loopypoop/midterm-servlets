<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Task</title>
    <jsp:include page="header.jsp" />

    <div align="center">
        <h1>Task #<c:out value="${task.id}"/></h1>
        <br>
        <h3><b>Description</b></h3>
        <p><c:out value="${task.description}"/></p>
    </div>
</body>
</html>
