<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Task Grade</title>
    <jsp:include page="header.jsp" />

    <div align="center">
        <h2>Estimate student's task</h2>
        <form action="estimateTask" method="get">
            <input type="hidden" name="studentId" value="<c:out value="${studentId}"/>">
            <input type="hidden" name="taskId" value="<c:out value="${param.taskId}"/>">
            <input type="hidden" name="subjectId" value="<c:out value="${param.subjectId}"/>">
            <label for="grade" class="sr-only">Grade</label>
            <input name="grade" type="text" id="grade" placeholder="Grade" required="">
            <button type="submit">Submit</button>
        </form>
    </div>

</body>
</html>
