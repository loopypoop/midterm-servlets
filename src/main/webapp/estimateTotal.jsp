<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Total Grade</title>
    <%@include file="header.jsp" %>

    <div align="center">
        <h2>Estimate total of student's subject </h2>
        <form action="estimateTotal" method="get">
            <input type="hidden" name="studentId" value="<c:out value="${studentId}"/>">
            <input type="hidden" name="subjectId" value="<c:out value="${param.subjectId}"/>">
            <label for="totalGrade" class="sr-only">Grade</label>
            <select class="form-select" name="totalGrade" id="totalGrade" aria-label="Grade select" required=""
                    style="width: 120px; height: 30px">
                <option selected>Grade</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>

<%--            <input name="totalGrade" type="text" id="totalGrade" placeholder="Grade" required="">--%>
            <button class="btn btn-dark" type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
