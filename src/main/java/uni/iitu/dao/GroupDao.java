package uni.iitu.dao;

import uni.iitu.entity.Group;
import uni.iitu.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDao {

    DbConnection db = new DbConnection();

    public List<Group> getGroups(Integer teacherId)
            throws SQLException, ClassNotFoundException {
        List<Group> groups = new ArrayList<>();

        String sql = "SELECT * FROM groups WHERE teacher_id = ?";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, teacherId);
        ResultSet resultSet = statement.executeQuery();


        while (resultSet.next()) {
            Integer groupId = resultSet.getInt("id");
            String name = resultSet.getString("name");

            Group group = new Group(groupId, name, teacherId);

            groups.add(group);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return groups;
    }

    public List<User> getStudents(Integer groupId)
            throws SQLException, ClassNotFoundException {
        List<User> students = new ArrayList<>();

        String sql = "SELECT * FROM users WHERE group_id = ?";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, groupId);
        ResultSet resultSet = statement.executeQuery();

        User user;


        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setTeacher(resultSet.getBoolean("teacher"));
            user.setGroupId(resultSet.getInt("group_id"));

            students.add(user);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return students;
    }

    public Group getGroupById(Integer id)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM groups WHERE id = ? LIMIT 1";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        String name = resultSet.getString("name");
        Integer teacherId = resultSet.getInt("teacher_id");

        Group group = new Group(id, name, teacherId);

        resultSet.close();
        statement.close();
        connection.close();

        return group;
    }
}
