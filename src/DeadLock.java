public class DeadLock extends Thread{
    /**
     * Both method are now requesting lock in same order, * first Integer and then String. * You could have also done reverse e.g. first String and then Integer, * both will solve the problem, as long as both method are requesting lock * in consistent order.
     */
    public void method1() {
        synchronized (Integer.class) {
            System.out.println("Aquired lock on Integer.class object");
            synchronized (String.class) {
                System.out.println("Aquired lock on String.class object");
            }
        }
    }

    public void method2() {
        synchronized (Integer.class) {
            System.out.println("Aquired lock on Integer.class object");
            synchronized (String.class) {
                System.out.println("Aquired lock on String.class object");
            }
        }
    }

    @Override
    public void run() {
        method1();
        method2();
    }

    public static void main(String[] args) {
        DeadLock d = new DeadLock();
        d.start();
        d.start();
    }
}
