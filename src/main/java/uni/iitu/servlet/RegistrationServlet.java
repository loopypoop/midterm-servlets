package uni.iitu.servlet;

import uni.iitu.dao.UserDao;
import uni.iitu.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        boolean teacher = Boolean.parseBoolean(request.getParameter("teacher"));

        System.out.println(email + ' ' + password);
        UserDao dao = new UserDao();

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setTeacher(teacher);

        try {
            int res = dao.create(user);

            if(res != 0){
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
