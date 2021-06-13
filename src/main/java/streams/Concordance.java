package streams;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {

    private static final Pattern WORD_BOUNDARY = Pattern.compile("\\W+");
    public static void main(String[] args) {
        try(Stream<String> in = Files.lines(Path.of("PrideandPrejudice.txt"))) {

            in.flatMap(line -> WORD_BOUNDARY.splitAsStream(line))
                    .filter(s -> s.length() > 0)
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(Function.identity() , Collectors.counting()))
                            .entrySet().stream()
                    .sorted((e1,e2) -> Long.compare(e2.getValue(),e1.getValue()))
                    .limit(200)
                    .map(e -> String.format("%20s : %5d",e.getKey(),e.getValue()))
        .forEach(System.out::println);
        };
    }
}
