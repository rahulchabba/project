package Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Transaction {
	private final Trader trader;
	private final int year;
	private final int value;

	public Transaction(Trader trader, int year, int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader() {
		return this.trader;
	}

	public int getYear() {
		return this.year;
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
	}

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Nangal");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2011, 19000),
				new Transaction(raoul, 2011, 40000),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
		System.out.println(transactions);

		System.out.println("1. Find all transactions in the year 2011 and sort them by value (small to high).");

		transactions.stream().filter((transaction) -> transaction.getYear() >= 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList())
				.forEach(System.out::println);
		;

		System.out.println("2. What are all the unique cities where the traders work? ");
		System.out.println();
		
		transactions.stream().map((transaction ) -> transaction.getTrader().getCity() ).distinct().forEach(System.out::println);
		System.out.print("2 "  );System.out.println(transactions.stream().map((transaction ) -> transaction.getTrader().getCity() ).distinct().collect(Collectors.toSet()));
		System.out.print("2 "  );System.out.println(transactions.stream().map((transaction ) -> transaction.getTrader()).distinct().sorted(Comparator.comparing(Trader::getName)) .collect(Collectors.toSet()));
		
		System.out.println();
		System.out.println("3. Find all traders from Cambridge and sort them by name.");
		System.out.print("3 "  );
		 transactions.stream()
				.map(Transaction::getTrader)
				.filter((trader) -> trader.getCity().equals("Cambridge"))
				.sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);
		 System.out.println();
		
		System.out.println("4. Return a string of all traders� names sorted alphabetically.");
		System.out.println("4 " +  
		transactions.stream().map(Transaction::getTrader).map(Trader::getName).sorted().distinct().sorted().reduce("", (a,b) -> a+b+"_"));
		System.out.println("4 " +  
				transactions.stream().map(Transaction::getTrader).map(Trader::getName).sorted().distinct().sorted().collect(Collectors.joining()));
				
		System.out.println();
		System.out.println("5. Are any traders based in Milan?");
		System.out.print("5 "  ); 
		transactions.stream()
			.map(Transaction::getTrader)
			.filter((trader) -> trader.getCity().equals("Milan")).distinct()
			.sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);
		
		System.out.println();
		System.out.println("6. Print all transactions� values from the traders living in Cambridge.");
		System.out.print("6. " );
	    transactions.stream().filter((trans) -> trans.getTrader().getCity().equals("Cambridge")).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println();
		System.out.println("7. What�s the highest value of all the transactions?");
		System.out.print("7. " );
	    Integer max = transactions.stream().map((trans) -> trans.getValue()).reduce(0, Integer::max);
	    double sum = transactions.stream().mapToDouble((trans) -> trans.getValue()).sum();
		System.out.println(max); 
		System.out.println("sum "+sum); 
		System.out.println();
		System.out.println("8. Find the transaction with the smallest value.");
		System.out.print("8. " ); 
		Optional<Transaction> min = transactions.stream().min(Comparator.comparing(Transaction::getValue));
			System.out.println(min.get().getValue()); 
		System.out.println();

	}
}
