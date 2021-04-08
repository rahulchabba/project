package predicateAppple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApple {

	public static void main(String[] args) {
		Apple a = new Apple("red", 121);
		Apple a1 = new Apple("yellow", 2);
		Apple a4 = new Apple("yellow", 4);
		Apple a2 = new Apple("red", 11);
		Apple a3 = new Apple("red", 3111);
		ArrayList<Apple> listapple = new ArrayList<>();
		listapple.add(a);
		listapple.add(a1);
		listapple.add(a2);
		listapple.add(a4);
		listapple.add(a3);
		ArrayList<Apple> appleByWeight = (ArrayList<Apple>) sortdata(listapple, new AppleWeightPredicate());
		appleByWeight.stream()
				.forEach((weightApple) -> System.out.println(weightApple.name + "  " + weightApple.weight));
		ArrayList<Apple> yellowAppleList = (ArrayList<Apple>) sortdata(listapple, new PredicateYellowApple());
		yellowAppleList.stream().forEach(apple -> System.out.println(apple.name + apple.weight));
		System.out.println();

		ArrayList<Apple> appleByWeightAbsract = (ArrayList<Apple>) sortdata(listapple,
				(Apple apple) -> "pink".equals(apple.name));
		// appleByWeightAbsract.stream().forEach((t) ->
		// System.out.println(t.name));

		// listapple.stream().forEach((l) -> System.err.println(l.weight));
		// listapple.stream().filter((Apple apple) -> "pink".equals(apple.name))
		// ;
		// Collections.sort(listapple , (Apple e, Apple ee) -> {
		// return e.getWeight().compareTo(ee.getWeight());
		// }
		// );
		// System.out.println("test"+listapple);
		// listapple.stream().forEach((l) -> System.err.println(l.weight));
		//
		List<Integer> s = new ArrayList();
		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		for (int i = 0; i <= 100; i++)
			s.add(i);
		System.out.println(s.stream().collect(Collectors.summingInt(Integer::intValue)));
		System.out.println(s.stream().reduce(0, Integer::sum));
		Comparator<Apple> c = Comparator.comparing((Apple aa) -> aa.getName());
		Collections.sort(listapple, c);

		ArrayList<Apple> appllist2 = new ArrayList<>();
		appllist2.add(a);
		appllist2.add(a1);
		appllist2.add(a2);
		appllist2.add(a4);
		appllist2.add(a3);

		ArrayList<Integer> appllists = (ArrayList<Integer>) appllist2.stream().filter((apps) -> {
			System.out.println("Filtering " + apps.getName());
			return apps.getWeight() >= 1;
		}).map((m) -> {
			System.out.println("maping " + m.getName());
			return m.getWeight() * m.getWeight();
		}).distinct().collect(Collectors.toList());
		System.out.println("listtt -- " + appllists);

		HashMap<Integer, Integer> datemap = new HashMap<Integer, Integer>();
		datemap.put(1, 1300);
		datemap.put(2, 101);
		datemap.put(3, 10);
		datemap.put(4, 11);
		System.out.println(datemap);
		Integer d = datemap.values().stream().map((num) -> num).reduce(0, Integer::sum);

		System.out.println(d);
		System.out.println(datemap.values().stream().allMatch((x) -> x > 1));
		System.out.println(datemap);
		appllists.forEach(System.out::println);
		ArrayList<String> appllists1 = (ArrayList<String>) appllist2.stream().filter((apps) -> apps.getWeight() >= 100)
				.map(Apple::getName).collect(Collectors.toList());
		System.out.println("listtt1 -- " + appllists1);
		ArrayList<Apple> appllists2 = (ArrayList<Apple>) appllist2.stream().collect(Collectors.toList());
		System.out.println("listtt2 -- " + appllists2);
		ArrayList<String> appllists3 = (ArrayList<String>) appllist2.stream().map(Apple::getName)
				.collect(Collectors.toList());
		System.out.println("listtt3 -- " + appllists3);

		HashMap<String, Apple> map1 = new HashMap<>();
		map1.put("1", a);
		map1.put("1", a1);
		map1.put("1", a2);
		map1.put("1", a3);

		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(firstvalue -> IntStream.rangeClosed(1, 100)
						.filter(bsecondValue -> Math.sqrt(firstvalue * firstvalue + bsecondValue * bsecondValue) % 1 == 0)
						.mapToObj(secondValue -> new int[] { firstvalue, secondValue,
								(int) Math.sqrt(firstvalue * firstvalue + secondValue * secondValue) }));

		pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

		IntStream ones = IntStream.generate(() -> 1);
		 System.out.println(ones);
	}

	public static List<Apple> sortdata(ArrayList<Apple> l, ApplePredicate predicate) {
		List<Apple> appleList = new ArrayList<Apple>();
		for (Apple currentApple : l) {
			if (predicate.test(currentApple)) {
				appleList.add(currentApple);
			}
		}
		return appleList;
	}

}
