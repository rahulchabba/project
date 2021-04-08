package Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import predicateAppple.WordCounter;

public class Dish {

	public static void main(String[] args) {
		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(1, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
						.mapToObj(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }));

		pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

		System.out.println("Is prime");
		int number = 10;
		boolean s = IntStream.range(2, 10).noneMatch((i) -> 10 % i == 0);

		Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
		List<Integer> numbers = stream.reduce(new ArrayList<Integer>(), (List<Integer> l, Integer e) -> {
			l.add(e);
			return l;
		}, (List<Integer> l1, List<Integer> l2) -> {
		 
			return l2;
		});

		System.out.println(numbers);

	}

}
