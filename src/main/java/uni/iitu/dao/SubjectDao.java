package uni.iitu.dao;

import uni.iitu.entity.Subject;
import uni.iitu.entity.Subject_user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {

    DbConnection db = new DbConnection();

    public List<Subject_user> getSubjects(Integer userId) throws SQLException, ClassNotFoundException {
        List<Subject_user> subjectList = new ArrayList<>();

        String sql = "SELECT * FROM subjects_students WHERE user_id = ?";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            Integer user_id = resultSet.getInt("user_id");
            Integer subjectId = resultSet.getInt("subject_id");
            String subjectName = resultSet.getString("subject_name");
            Integer grade = resultSet.getInt("grade");

            Subject_user subject = new Subject_user(id, user_id, subjectId, subjectName, grade);

            subjectList.add(subject);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return subjectList;
    }

    public Subject getSubjectById(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM subjects WHERE id = ? LIMIT 1";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        String name = resultSet.getString("name");

        Subject subject = new Subject(id, name);

        resultSet.close();
        statement.close();
        connection.close();

        return subject;
    }

    public Subject_user getSubjectUserById(Integer subjectId, Integer userId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM subjects_students WHERE subject_id = ? AND user_id = ?LIMIT 1";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, subjectId);
        statement.setInt(2, userId);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        String name = resultSet.getString("subject_name");
        Integer id = resultSet.getInt("id");
        Integer grade = resultSet.getInt("grade");

        Subject_user subject_user = new Subject_user(id, userId, subjectId, name, grade);

        resultSet.close();
        statement.close();
        connection.close();

        return subject_user;
    }

    public boolean estimateTotal(Subject_user subject_user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE subjects_students SET grade = ? WHERE id = ?";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, subject_user.getGrade());
        statement.setInt(2, subject_user.getId());

        boolean graded = statement.executeUpdate() > 0;
        statement.close();
        connection.close();

        return graded;
    }

    public List<Subject> getSubjectsByGroupId(Integer groupId)
            throws SQLException, ClassNotFoundException {
        List<Subject> subjectList = new ArrayList<>();

        String sql = "SELECT * FROM subjects WHERE group_id = ?";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, groupId);

        ResultSet resultSet = statement.executeQuery();


        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            Subject subject = new Subject(id, name);

            subjectList.add(subject);
        }


        resultSet.close();
        statement.close();
        connection.close();

        return subjectList;
    }
}
