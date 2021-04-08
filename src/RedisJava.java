import java.util.List;
import java.util.stream.Collectors;

import predicateAppple.CreateDishes;
import predicateAppple.Dish;

public class RedisJava { 

	 
	public static void main(String[] args) throws Exception {
	
		List<Dish> menu =  CreateDishes.enterData();
		
	List<String> meat=	menu.parallelStream().filter((a)-> a.getCalories()> 300)
							.map(Dish::getName).limit(4).collect(Collectors.toList());	 	
	
	   meat.forEach(System.out::println);
	   
	   
	 List<Dish> isVeg = menu.stream().filter(Dish::isVegetarian).filter((f) -> f.getCalories() > 0) .collect(Collectors.toList());
	 System.out.println(isVeg);
	 
	   
	}
}