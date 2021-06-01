import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// this annotation throw error if we define more than one abstract methods.
@FunctionalInterface
interface CriterionOfStudent {
    boolean test(Student student);
}

class SmartStudent implements CriterionOfStudent {
    private int threshold;

    public SmartStudent(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean test(Student student) {
        return student.getGrade() > threshold;
    }
}

class EnthusiasticStudent implements CriterionOfStudent {
    @Override
    public boolean test(Student student) {
        return student.getCourses().size() > 3;
    }
}

public class School {


    public static void showAll(List<Student> students) {
        for(Student s: students) {
            if( s.getGrade() > 75) {
                System.out.println(s);
            }
        }

        System.out.println("----------------");

    }


    public static List<Student> getByCriterion(List<Student> students, CriterionOfStudent criterionOfStudent) {
        List<Student> rv = new ArrayList<>();
        for(Student s: students) {
            if( criterionOfStudent.test(s)) {
                rv.add(s);
            }
        }
        return rv;
    }
// what is the lifetime of this variable threshold
    // this variable should break as threshold scope would be till this function executed.
    // this is called closure,
    //If this "threshold parameter is immutable then it is safe to pass threshold in lambda expression
    // If you are going to capture local parameter into the lambda expressiond declared
    // inside that method , the method local variable must not change
    public static CriterionOfStudent getSmartCriterion(int threshold) {
        threshold++;
        return s -> s.getGrade() > threshold;
    }
    public static void main(String[] args) {
        List<Student> roster = List.of(
                Student.of("Fred",78,"Math","Physics"),
                Student.of("Jim",58,"Art"),
                Student.of("Sheila",89,"Math","Physics","Astro Physics","Quantum mechanics")
        );


        CriterionOfStudent midRange =  student -> student.getGrade() >  65;
        // "expression lambda (If curlies then its a block lambda )
        showAll(getByCriterion(roster,s -> s.getGrade() >  65));

    }
}
// proof that is an object expression