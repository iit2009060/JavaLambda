package superiterable;

import java.util.List;

public class Student {

    private  int grade;
    private String name;
    List<String> courses;

    private Student(int grade, String name, List<String> courses) {
        this.courses = courses;
        this.name = name;
        this.grade = grade;
    }


    // LIST.OF is in java 9
    public static Student of(String name,int grade,String ... courses) {
        return new Student(grade,name,List.of(courses));
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
