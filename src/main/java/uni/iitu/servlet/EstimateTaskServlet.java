package uni.iitu.servlet;

import uni.iitu.dao.TaskDao;
import uni.iitu.entity.Task_user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/estimateTask")
public class EstimateTaskServlet extends HttpServlet {

    public EstimateTaskServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TaskDao taskDao = new TaskDao();

        try {
            Integer taskId = Integer.parseInt(request.getParameter("taskId"));
            Integer studentId = Integer.parseInt(request.getParameter("studentId"));
            Integer subjectId = Integer.parseInt(request.getParameter("subjectId"));
            Integer grade = Integer.parseInt(request.getParameter("grade"));

            Task_user task_user = taskDao.getTaskUserById(taskId, studentId);
            task_user.setGrade(grade);

            System.out.println(taskDao.estimateTask(task_user));
            RequestDispatcher dispatcher = request.getRequestDispatcher("TaskServlet");
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
