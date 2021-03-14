<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Profile</title>
    <jsp:include page="header.jsp" />
    <div align="center">
        <img src="https://dl.iitu.edu.kz/theme/image.php/classic/core/1615577403/u/f1" alt=""><br>
        <h3><c:out value="${user.name}" /></h3>
        <h4>Email: <c:out value="${user.email}"/> </h4>
    </div>
</body>
</html>
