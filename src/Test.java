import java.util.Arrays;

class Parent {
    public int num = 1;

    Parent() {
        System.out.println("Parent class default constructor.");
    }

    Parent(String x) {
        System.out.println("Parent class parameterised constructor.");
    }

    public  void m1() {
        System.out.println("Parent class foo! Parent");
    }

    public  void m2() {
        System.out.println("Parent class foo!  Parent");
    }

}

class Child extends Parent {

    public int num = 2;

    public  void m1() {
        System.out.println("Parent class foo! child");
    }

    public  void m3() {
        System.out.println("Parent class foo! child");
    }


}

public class Test  {

    public static void main(String[] args) {
        String s = new String("rahul");
        String s1 = new String("rahul");
        String s2= "rahul";

        int a[] = new int[10];
        Arrays.asList(a);
        System.out.println(s==s1);


    }



}
