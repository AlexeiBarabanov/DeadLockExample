package com.company;

public class Main {

    public static Object obj1 = new Object();
    public static Object obj2 = new Object();

    public static class ThreadOne extends Thread {

        public void run() {
            synchronized (obj1) {
                System.out.println("one: holding obj1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("one: holding obj2");
                }
            }
        }
    }

    public static class ThreadTwo extends Thread {

        public void run() {
            synchronized (obj2) {
                System.out.println("two: holding obj2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("two: holding obj1");
                }
            }
        }
    }

    public static void main(String[] args) {

        Thread t1 = new ThreadOne();
        Thread t2 = new ThreadTwo();
        t1.start();
        t2.start();
    }

}

