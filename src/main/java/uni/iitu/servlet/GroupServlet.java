package uni.iitu.servlet;

import uni.iitu.dao.GroupDao;
import uni.iitu.entity.Group;
import uni.iitu.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet
public class GroupServlet extends HttpServlet {

    public GroupServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GroupDao groupDao = new GroupDao();

        Integer groupId = Integer.parseInt(request.getParameter("groupId"));


        try {
            HttpSession session = request.getSession(false);
            User user = null;
            String path = "home.jsp";

            if (session != null) {
                user = (User) session.getAttribute("user");
            }

            if (user != null) {
                if (user.isTeacher()) {
                    path = "specific-group.jsp";
                    List<User> group = groupDao.getStudents(groupId);
                    request.setAttribute("group", group);
                    session.setAttribute("group", group);
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher(path);
                dispatcher.forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
