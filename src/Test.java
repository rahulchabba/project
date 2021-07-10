class Parent {
    private final int num = 1;

    Parent() {
        System.out.println("Parent class default constructor.");
    }

    Parent(String x) {
        System.out.println("Parent class parameterised constructor.");
    }

    public static void foo() {
        System.out.println("Parent class foo!");
    }
}

class Child extends Parent {

    public static void foo() {

    }


}

public class Test extends Parent {

    public Test() {
        super();
    }


    public static void main(String[] args) {
        Test t = new Test();


    }

}
