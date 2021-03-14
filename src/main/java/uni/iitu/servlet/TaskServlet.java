package uni.iitu.servlet;

import uni.iitu.dao.TaskDao;
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

@WebServlet("/task")
public class TaskServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TaskDao taskDao = new TaskDao();

        try {

            Integer subjectId = 0;
            Integer studentId = 0;

            if (request.getParameter("subjectId") != null) {
                subjectId = Integer.parseInt(request.getParameter("subjectId"));
            }
            if (request.getParameter("studentId") != null) {
                studentId = Integer.parseInt(request.getParameter("studentId"));
            }

            String path = "home.jsp";

            HttpSession session = request.getSession(false);
            User user = null;
            if (session != null) {
                user = (User) session.getAttribute("user");
            }

            if (user != null) {

                if (!user.isTeacher()) {
                    List<Task_user> tasks = taskDao.getTasks(subjectId, user.getId());
                    path = "tasks.jsp";
                    session.setAttribute("tasks", tasks);
                    request.setAttribute("tasks", tasks);
                } else if (studentId != 0 && user.isTeacher()) {
                    List<Task_user> tasks = taskDao.getTasks(subjectId, studentId);
                    path = "tasks.jsp";
                    session.setAttribute("tasks", tasks);
                    request.setAttribute("tasks", tasks);
                    request.setAttribute("subjectId", subjectId);
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher(path);
                dispatcher.forward(request, response);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
