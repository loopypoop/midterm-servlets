package uni.iitu.entity;

public class Subject_user {
    private Integer id;
    private Integer userId;
    private Integer subjectId;
    private String subjectName;
    private Integer grade;

    public Subject_user(Integer id, Integer userId, Integer subjectId, String subjectName, Integer grade) {
        this.id = id;
        this.userId = userId;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
