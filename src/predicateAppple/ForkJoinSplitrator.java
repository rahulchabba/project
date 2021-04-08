package predicateAppple;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ForkJoinSplitrator {

	public static void main(String[] args) {
		String s = " my   name is rahul a a ";

		System.out.println(countwords(s) +" words.");
		
		Stream<Character> stream = IntStream.range(0, s.length()).mapToObj(s::charAt);
		System.out.println (ForkJoinSplitrator.countWordsa(stream) );
		
	}
	public static  int countWordsa(Stream<Character> stream) {
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true),WordCounter::accumulate,WordCounter::combine);
		return wordCounter.getCounter();
		}

	public static int countwords(String s) {

		int counter = 0;
		boolean lastspace = true;
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) {
				lastspace = true;;
			} else {
				if (lastspace)
					counter++;
				lastspace = false;
			}
		}
		return counter;
	}
}
