package predicateAppple;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Stream;

import predicateAppple.Dish.Type;
public class Java8 {


	public static void main(String[] args) throws Exception {

		List<Dish> menu =  CreateDishes.enterData();

		System.out.println(" 1 Printing element with 300 cal and limit only 4 elements");
		List<String> meat=	menu.parallelStream().filter((a)-> a.getCalories()> 300).map(Dish::getName).limit(4).collect(toList());
		meat.forEach(System.out::println);
		System.out.println("-------------------");


		System.out.println("2 Printing All element with filter of 0  Calories");
		List<Dish> isVeg = menu.stream().filter((f) -> f.getCalories() > 0).collect( toList());
		isVeg.forEach(System.out::println);
		System.out.println("-------------------");

		System.out.println("3 printing all the elements ");
		List<String> allElements = menu.parallelStream().map((dish) -> dish.getName()).collect(toList());
		System.out.println(allElements);
		System.out.println("-------------------");

		System.out.println("4 Printing all elements by sorting according to calory and getCalories of size 300 above" );
		List<Dish> len = menu.stream().filter((d)-> d.getCalories() > 300 ).sorted(comparing(Dish::getCalories)) .distinct().collect(toList());
		len.forEach(d  ->  System.out.println(d.getCalories()+"--"+d.getName()) );
		System.out.println("-------------------");

		long howManyDishes = menu.stream().collect(counting());
		System.out.println("5 Counting how many dishes are there total in DIsh class"+howManyDishes);
		System.out.println("-------------------");

		System.out.println("6 Calories according to suming ");
		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println( totalCalories);
		System.out.println("-------------------");


		DoubleSummaryStatistics menuStatistics =menu.stream().collect(summarizingDouble(Dish::getCalories));
		System.out.println("7 Summary according to summarizingDouble "+menuStatistics);
		System.out.println("-------------------");

		System.out.println("8 Attaching joiner as # ");
		String shortmenu = menu.stream().map(Dish::getName).collect(joining("#"));
		System.out.println(shortmenu);
		System.out.println("-------------------");

		System.out.println("9 Dishes according to Grouping by using groupingBy function ");
		Map<Type, List<Dish>> dishesByType =menu.stream().collect(groupingBy(Dish::getType));
		System.out.println(dishesByType);
		System.out.println("-------------------");


		System.out.println("10 Dishes according to Grouping by using Calric level function ");
		Map<CaloricLevel, List<Dish>> dishesByCaloriA  =menu.stream().collect(groupingBy(dish-> {
			if (dish.getCalories() <= 400) return CaloricLevel.DIET;
			else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
			else return CaloricLevel.FAT;
		}));
		System.out.println( dishesByCaloriA);
		System.out.println("-------------------");

		System.out.println("11 Dishes according to Grouping by using TYPE function ");
		Map<Type, Map<CaloricLevel, List<Dish>>> dishesByCaloriAndGroupit =menu.stream().collect(groupingBy (Dish::getType , groupingBy(dish-> {
			if (dish.getCalories() <= 400) return CaloricLevel.DIET;
			else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
			else return CaloricLevel.FAT;
		})));
		System.out.println(dishesByCaloriAndGroupit);
		System.out.println("-------------------");

		System.out.println("12 Group by Type and count ");
		Map<Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
		System.out.println( typesCount);
		System.out.println("-------------------");

		System.out.println("13 Group by Veg and calory ");
		Map<Boolean, Map<Type, List<Dish>>> groupby= 	menu.stream().collect(partitioningBy(Dish::isVegetarian , groupingBy(Dish::getType)));
		System.out.println(groupby);
		System.out.println("-------------------");

		System.out.println("14 total Calories By Type ");
		Map<Type, Integer> totalCaloriesByType =menu.stream().collect(groupingBy(Dish::getType,summingInt(Dish::getCalories)));
		System.out.println( totalCaloriesByType);
		System.out.println("-------------------");

		System.out.println("15 total Boolean and list of  dish partitioningBy calories");
		Map<Boolean, Map<Boolean, List<Dish>>>  sum_of_Calories  = menu.stream().
				collect(partitioningBy(Dish::isVegetarian,	partitioningBy(d -> d.getCalories() > 500)));
		System.out.println(sum_of_Calories);
		System.out.println("-------------------");

		System.out.println("16 Syso by dishes By CaloricLevel called from method ");
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(Dish :: getCaloricLevel));
		System.out.println(dishesByCaloricLevel);
		System.out.println("-------------------");

		System.out.println("Sort with deafult method");

		Stream<Dish> dishstream= menu.stream().sorted(comparing(Dish::getCalories));
		System.out.println(dishstream);

		System.out.println();

		System.out.println(Instant.now());
		System.out.println("Starting Time API");
		Period tenDays = Period.between(LocalDate.of(8, 3, 8),
				LocalDate.of(2014, 3, 18));
		System.out.println(tenDays);
		Duration threeMinutes = Duration.ofMinutes(3);
		Duration threeMinute = Duration.of(3, ChronoUnit.MINUTES);
		Period tenDay = Period.ofDays(10);
		Period threeWeeks = Period.ofWeeks(3);
		Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
		System.out.print("Get next working day date::");
		LocalDate date =LocalDate.of(2018, 2, 23);
		date = date.with(temporal -> {
			DayOfWeek dow =
					DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
			int dayToAdd = 1;
			if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
			else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
			return temporal.plus(dayToAdd, ChronoUnit.DAYS);
		});

		System.out.println(date);

		DateTimeFormatter italianFormatterq = new DateTimeFormatterBuilder()
				.appendText(ChronoField.DAY_OF_MONTH)
				.appendLiteral(". ")
				.appendText(ChronoField.MONTH_OF_YEAR)
				.appendLiteral(" ")
				.appendText(ChronoField.YEAR)
				.parseCaseInsensitive().toFormatter(Locale.ITALIAN);
		DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
		LocalDate date1 = LocalDate.of(2014, 3, 18);
		String formattedDate = date.format(italianFormatter); // 18. marzo 2014
		LocalDate date2 = LocalDate.parse(formattedDate, italianFormatter);
		System.out.println(date2);

		ZoneId zoneId = TimeZone.getDefault().toZoneId();
		System.out.println(date);
		JapaneseDate japaneseDate = JapaneseDate.from(date);
		System.out.println(japaneseDate);

	}
}