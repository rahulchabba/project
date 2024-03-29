
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Java8WordFrequencyCount {

    public static void main(String[] args) {



        String wordsList = "my name is rahul my  is name is anmol";

        List<String> list = Stream.of(wordsList).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
                .collect(Collectors.toList());
        Optional<String> firstelement = Stream.of(wordsList).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
                .findFirst();


        Map<String, Long> collect =
                list.stream().collect(groupingBy(Function.identity(), counting()));
        System.out.println(collect);
        Map<String, Integer> collectqqq=
                list.stream().collect(groupingBy(Function.identity(), summingInt(e -> 1)));
        System.out.println(collectqqq);

        Map<String, Integer> wordCounter = list.stream()
                .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));

        System.out.println(wordCounter);

    }

}
