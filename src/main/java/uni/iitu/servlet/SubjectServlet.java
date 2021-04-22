package uni.iitu.servlet;

import uni.iitu.dao.SubjectDao;
import uni.iitu.dao.UserDao;
import uni.iitu.entity.Subject_user;
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

@WebServlet("/subject")
public class SubjectServlet extends HttpServlet {

    public SubjectServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SubjectDao subjectDao = new SubjectDao();
        UserDao userDao = new UserDao();

        try {

            Integer studentId = 0;
            if (request.getParameter("studentId") != null) {
                studentId = Integer.parseInt(request.getParameter("studentId"));
                System.out.println(studentId);
                User student = userDao.getUserById(studentId);
            }

            HttpSession session = request.getSession(false);
            User user = null;

            if (session != null) {
                user = (User) session.getAttribute("user");
            }

            if (user != null) {
                if (!user.isTeacher()) {
                    List<Subject_user> subjectList = subjectDao.getSubjects(user.getId());
                    request.setAttribute("subjectList", subjectList);
                    session.setAttribute("subjectList", subjectList);
                } else if (studentId != 0 && user.isTeacher()) {

                    List<Subject_user> subjectList = subjectDao.getSubjects(studentId);
                    request.setAttribute("subjectList", subjectList);
                    session.setAttribute("subjectList", subjectList);
                    session.setAttribute("studentId", studentId);
                    
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("subject-list.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

}
