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

    public static CriterionOfStudent getSmartCriterion() {
        return s -> s.getGrade() > 5;
    }
    public static void main(String[] args) {
        List<Student> roster = List.of(
                Student.of("Fred",78,"Math","Physics"),
                Student.of("Jim",58,"Art"),
                Student.of("Sheila",89,"Math","Physics","Astro Physics","Quantum mechanics")
        );

        // can leave off parens with single formal param,if no var and no type
        CriterionOfStudent midRange =  student -> {
            return student.getGrade() >  65;
        };
        Class<?> clas = midRange.getClass();
        Method[] methods = clas.getMethods();
        for(Method method: methods) {
            System.out.println(" >" + method);
        }
        showAll(getByCriterion(roster,midRange));

    }
}
// proof that is an object expression