package com.test.javarnd;

public class MyTread extends Thread{
 
    Thread t;
    MyTread() {
        t=new Thread(this,"my");
        t.setDaemon(false);
        t.start();
        t.setDaemon(true);

    }

    public void run() {
        try {
            //t.join();
            System.out.println(t.getName());
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        
        new MyTread();
    }
}
