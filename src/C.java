import java.util.HashMap;
import java.util.Optional;

import javax.management.openmbean.OpenDataException;

interface A{
	
	default void test(){
		System.out.println("a");
	}
	
}
interface B{
	
	default void test(){
		System.out.println("B");
	}
	
}

class D implements A,B{

	@Override
	public void test() {
		System.out.println("D");
	}
	
	
}


public  class C  implements A 	{
 
 public static void main(String[] args) {
	C c = new C();
	c.test();
	HashMap map = new HashMap<>();
	Object a = map.get("key");
	
	Optional<Object> value = Optional.ofNullable(map.get("key"));
	System.out.println(value.toString());
}
	 
}
 
