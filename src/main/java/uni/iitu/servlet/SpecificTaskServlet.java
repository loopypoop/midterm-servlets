package uni.iitu.servlet;

import uni.iitu.dao.TaskDao;
import uni.iitu.entity.Task;
import uni.iitu.entity.Task_user;
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
public class SpecificTaskServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer taskId = Integer.parseInt(request.getParameter("taskId"));

        TaskDao taskDao = new TaskDao();

        try {

            HttpSession session = request.getSession(false);
            User user = null;
            if (session != null) {
                user = (User) session.getAttribute("user");
            }

            if (user != null) {
                if (!user.isTeacher()) {
                    Task task = taskDao.getTaskById(taskId);

                    session.setAttribute("task", task);
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("specific-task.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
