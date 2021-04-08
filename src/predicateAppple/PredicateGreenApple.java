package predicateAppple;

public class PredicateGreenApple implements ApplePredicate{

	@Override
	public boolean test(Apple apple) {
		// TODO Auto-generated method stub
		return "yellow".equalsIgnoreCase(apple.getName());
	}

}
