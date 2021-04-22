package uni.iitu.servlet;

import uni.iitu.dao.SubjectDao;
import uni.iitu.entity.Subject_user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/estimateTotal")
public class EstimateTotalServlet extends HttpServlet {

    public EstimateTotalServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SubjectDao subjectDao = new SubjectDao();

        try {

            Integer subjectId = Integer.parseInt(request.getParameter("subjectId"));
            Integer studentId = Integer.parseInt(request.getParameter("studentId"));
            Integer grade = Integer.parseInt(request.getParameter("totalGrade"));

            Subject_user subject_user = subjectDao.getSubjectUserById(subjectId, studentId);
            subject_user.setGrade(grade);

            System.out.println(subjectDao.estimateTotal(subject_user));
            RequestDispatcher dispatcher = request.getRequestDispatcher("SubjectServlet");
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
