package uni.iitu.dao;

import java.sql.*;

import uni.iitu.entity.Group;
import uni.iitu.entity.User;

public class UserDao {

    DbConnection db = new DbConnection();
    public User checkLogin(String email, String password) throws SQLException,
            ClassNotFoundException {

        Connection connection = db.getConnection();
        String sql = "SELECT * FROM users WHERE email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        User user = null;

        if (result.next()) {
            user = new User();
            user.setId(result.getInt("id"));
            user.setName(result.getString("name"));
            user.setEmail(result.getString("email"));
            user.setTeacher(result.getBoolean("teacher"));
            Integer groupId = result.getInt("group_id");
            user.setGroupId(groupId);
        }

        result.close();
        statement.close();
        connection.close();

        return user;
    }

    public int create(User user) throws ClassNotFoundException {

        String sql = "INSERT INTO users (email, name, password, teacher) VALUES (?, ?, ?, ?)";


        int res = 0;

        try {

            Connection connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.setBoolean(4, user.isTeacher());

//        ResultSet result = statement.executeQuery();

            res = statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public Group getGroupByStudentGroupId(Integer groupId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM groups WHERE id = (SELECT group_id FROM users WHERE group_id = ?)";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, groupId);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        String name = resultSet.getString("name");
        Integer teacherId = resultSet.getInt("teacher_id");

        Group group = new Group(groupId, name, teacherId);

        resultSet.close();
        statement.close();
        connection.close();

        return group;
    }

    public User getUserById(Integer id)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users WHERE id = ? LIMIT 1";
        Connection connection = db.getConnection();

        User user = new User();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Integer groupId = resultSet.getInt("group_id");

        user.setName(resultSet.getString("name"));
        user.setId(id);
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));

        user.setGroupId(groupId);

        user.setTeacher(resultSet.getBoolean("teacher"));

        resultSet.close();
        statement.close();
        connection.close();

        return user;
    }
}
