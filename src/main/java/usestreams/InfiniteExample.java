package usestreams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteExample {

    public static void main(String[] args) {
        /*IntStream.iterate(1, x -> x + 1)
                .limit(1000)
                .mapToObj(s -> "Number is  " + s)
                .forEach(System.out::println);*/

// reduce operation take two arguments of same stream type and return an optional
        IntStream.iterate(1, x -> x + 1)
                .limit(0)
                .reduce((a,b) -> a +b)
                .ifPresent( x -> System.out.println("Sum is " + x));

        // What happen if we shareded the data to multiple computers

    }
}
