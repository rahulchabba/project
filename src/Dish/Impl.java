package Dish;


public class Impl implements Runnable{
	Thread t;
	String name;
	Impl(String name){
		this.name=name;
	}
	
	public void run(){
		while(true)
			System.out.println(name);
	}
	
	public void start(){
		if(t==null){
			t=new Thread(this,name);
			t.start();
		}
	}
	
	public static void main(String[] args) {
		Impl i=new Impl("A");
		Impl j=new Impl("B");
		j.start();
		i.start();
	}
	

}
