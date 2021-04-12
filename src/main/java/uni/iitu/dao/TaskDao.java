package uni.iitu.dao;


import uni.iitu.entity.Task;
import uni.iitu.entity.Task_user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {

    DbConnection db = new DbConnection();

    public List<Task_user> getTasks(Integer subjectId, Integer userId) throws SQLException, ClassNotFoundException {
        List<Task_user> tasks = new ArrayList<>();

        String sql = "SELECT * FROM tasks_students WHERE subject_id = ? AND user_id = ?";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, subjectId);
        statement.setInt(2, userId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String topic = resultSet.getString("task_topic");
            Integer taskId = resultSet.getInt("task_id");
            Integer grade = resultSet.getInt("grade");
            Task task = this.getTaskById(taskId);

            Task_user task_user = new Task_user(id, userId, subjectId, topic, task, grade);

            tasks.add(task_user);
        }

        return tasks;
    }

    public Task getTaskById(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tasks WHERE id = ? LIMIT 1";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        String name = resultSet.getString("topic");
        String description = resultSet.getString("description");

        Task task = new Task(id, name, description);

        resultSet.close();
        statement.close();
        connection.close();

        return task;
    }

    public Task_user getTaskUserById(Integer taskId, Integer userId)
            throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tasks_students WHERE task_id = ? AND user_id = ?";
        Connection connection = db.getConnection();


        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, taskId);
        statement.setInt(2, userId);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        Integer id = resultSet.getInt("id");
        Integer subjectId = resultSet.getInt("subject_id");
        String topic = resultSet.getString("task_topic");
        Integer grade = resultSet.getInt("grade");
        Task task = this.getTaskById(taskId);

        Task_user task_user = new Task_user(id, userId, subjectId, topic, task, grade);

        resultSet.close();
        statement.close();
        connection.close();

        return task_user;
    }

    public boolean estimateTask(Task_user task_user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE tasks_students SET grade = ? WHERE id = ?";
        Connection connection = db.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, task_user.getGrade());
        statement.setInt(2, task_user.getId());

        boolean graded = statement.executeUpdate() > 0;
        statement.close();
        connection.close();

        return graded;
    }
}
