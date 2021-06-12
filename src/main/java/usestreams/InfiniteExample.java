package usestreams;

import java.util.stream.Stream;

public class InfiniteExample {

    public static void main(String[] args) {
        Stream.iterate(1,x -> x + 1)
                .forEach(System.out::println);
    }
}
