
package studentmanagementsystem;

public class Student {
    private String studentId;
    private String name;
    private int age;
    
    public Student(String studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }
    
    // Getters and setters with information hiding
    public String getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Age: " + age;
    }
}
