package superiterable;

import java.util.Iterator;

public class SuperIterable<E> implements Iterable<E>{
    private Iterable<E> self;

    public SuperIterable(Iterable<E> self) {
        this.self = self;
    }

    @Override
    public Iterator<E> iterator() {
        return self.iterator();
    }
}
