<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Total Grade</title>
    <%@include file="header.jsp" %>

    <div>
        Student id: <p><c:out value="${studentId}"/></p>
        Subject id: <p><c:out value="${param.subjectId}"/></p>
    </div>
    <div align="center">
        <h2>Estimate total of student's subject </h2>
        <form action="estimateTotal" method="get">
            <input type="hidden" name="studentId" value="<c:out value="${studentId}"/>">
            <input type="hidden" name="subjectId" value="<c:out value="${param.subjectId}"/>">
            <label for="totalGrade" class="sr-only">Grade</label>
            <input name="totalGrade" type="text" id="totalGrade" placeholder="Grade" required="">
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
