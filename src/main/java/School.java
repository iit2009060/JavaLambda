import java.util.ArrayList;
import java.util.List;

public class School {


    public static void showAllSmart(List<Student> students) {
        for(Student s: students) {
            if( s.getGrade() > 75) {
                System.out.println(s);
            }
        }

        System.out.println("----------------");

    }

    public static List<Student> getSmart(List<Student> students, int threshold) {
        List<Student> rv = new ArrayList<>();
        for(Student s: students) {
            if( s.getGrade() > threshold) {
                rv.add(s);
            }
        }
        return rv;
    }

    public static List<Student> getEnthusiastic(List<Student> students, int threshold) {
        List<Student> rv = new ArrayList<>();
        for(Student s: students) {
            if( s.getCourses().size() > threshold) {
                rv.add(s);
            }
        }
        return rv;
    }
    public static void main(String[] args) {
        List<Student> roster = List.of(
                Student.of("Fred",78,"Math","Physics"),
                Student.of("Jim",58,"Art"),
                Student.of("Sheila",89,"Math","Physics","Astro Physics","Quantum mechanics")
        );
        showAllSmart( getSmart(roster,65));
        showAllSmart(getEnthusiastic(roster,2));
    }
}
