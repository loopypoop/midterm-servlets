package uni.iitu.servlet;

import uni.iitu.dao.UserDao;
import uni.iitu.entity.User;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        super();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();

        try {
            User user = userDao.checkLogin(email, password);

            if (user != null) {
                if (!user.isTeacher()) {
                    user.setGroup(userDao.getGroupByStudentGroupId(user.getGroupId()));
                }
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(30*60);

            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
