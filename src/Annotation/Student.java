package Annotation;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 20 : 38
 * @Description: todo
 */
@Table("tb_student")
public class Student {
    @Fields(columnName = "id",type = "int",length = 10)
    private int id;
    @Fields(columnName = "id",type = "varchar",length = 10)
    private String studentName;
    @Fields(columnName = "id",type = "int",length = 3)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
