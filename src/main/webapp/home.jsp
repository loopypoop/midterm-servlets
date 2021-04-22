<jsp:useBean id="user" class="uni.iitu.entity.User" scope="session"/>
<jsp:setProperty name="user" property="*"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <jsp:include page="header.jsp"/>
    <div class="container">


        <div style="text-align: center">
            <h1>Welcome to Adil's Online School</h1>x
            <b>
                <jsp:getProperty name="user" property="name"/>
                (
                <jsp:getProperty name="user" property="email"/>
                )</b>

            <br><br>
            <img src="https://www.ihm.edu.au/blog/wp-content/uploads/2020/04/study-online-1-732x447.jpg" alt="">
        </div>
    </div>
    </body>
</html>
