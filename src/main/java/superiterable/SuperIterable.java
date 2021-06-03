package superiterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E>{
    private Iterable<E> self;

    public SuperIterable(Iterable<E> self) {
        this.self = self;
    }

    @Override
    public Iterator<E> iterator() {
        return self.iterator();
    }

    public  void forEvery(Consumer<E> op) {
        for( E s: self) {
          op.accept(s);
        }

    }

    // Functionaly this function depend on students , and criterion depend on student, can we make it generic
    public  SuperIterable<E> filter(Predicate<E> criterionOfStudent) {
        List<E> rv = new ArrayList<>();
        for(E s: self) {
            if( criterionOfStudent.test(s)) {
                rv.add(s);
            }
        }
        return new SuperIterable<>(rv);
    }

    // define map function which take E as a argument and return F;
    public  <F>  SuperIterable<F>  map( Function<E,F> criterion) {
        List<F> rv = new ArrayList<>();
        for(E s: self) {
            F f = criterion.apply(s);
            rv.add(f);
        }
        return new SuperIterable<>(rv);
    }

    // expect to get many and flatten in a single list
    public  <F>  SuperIterable<F>  flatmap( Function<E,SuperIterable<F>> criterion) {
        List<F> rv = new ArrayList<>();
        for(E s: self) {
            SuperIterable<F> manyf = criterion.apply(s);
            for(F f : manyf ) {
                rv.add(f);
            }
        }
        return new SuperIterable<>(rv);
    }

   /* public SuperIterable<E>  distinct() {

    }*/

}
