package uni.iitu.entity;

public class Task_user {
    private Integer id;
    private Integer userId;
    private Integer subjectId;
    private String topic;
    private Task task;
    private Integer grade;

    public Task_user(Integer id, Integer userId, Integer subjectId, String topic, Task task, Integer grade) {
        this.id = id;
        this.userId = userId;
        this.subjectId = subjectId;
        this.topic = topic;
        this.task = task;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
