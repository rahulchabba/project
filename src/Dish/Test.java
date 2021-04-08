package Dish;

public class Test {
	static String str;
	Test(){
		System.out.println("In counstrtor");
		str="Hello World";
	}
	
	public static void main(String[] args) {
		Test t=new Test();
		System.out.println(str);
	}
	/*
	static final Integer i1=1;
	 final Integer i2=2;
	 Integer i3=3;
	public static void main(String[] args) {
		
		
		try{
			badMethod();
			System.out.println("A");
		}catch(Exception ex){
			System.out.println("B");
		}finally{
			System.out.println("C");
		}
		
		
		int mark=0x000F;
		int  value=0x2222;
		System.out.println(value&mark);
		 final Integer i4=4;
		 Integer i5=5;
		 class Inner{
			 final Integer i6=6;
			 Integer i7=7;
			 Inner(){
				 System.out.println(i6+i7);
			 }
		 }
	}
	private static void badMethod() {
		throw new RuntimeException();
		
	}
*/}
