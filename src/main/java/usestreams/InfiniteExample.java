package usestreams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteExample {

    public static void main(String[] args) {
        IntStream.iterate(1, x -> x + 1)
                .mapToObj(s -> "Number is  " + s)
                .forEach(System.out::println);
    }
}
