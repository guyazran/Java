package com.company;

public class Main {

    public static void main(String[] args) {
//        Thread t1, t2;
//
//        Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println("first loop i =" + i);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        //runnable.run();
//
//        Runnable runnable2 = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println("second loop i =" + i);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//
//        t1 = new Thread(runnable1);
//        t1.start();
//
//        t2 = new Thread(runnable2);
//        t2.start();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("in main thread");

//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//
//        MyThread myThread = new MyThread();
//        myThread.start();


//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    System.out.println("in catch of sleep");
//                }
//                System.out.println("in run() of t");
//            }
//        });
//        t.setPriority(9);
//        t.setName("the cool thread");
//        System.out.println(t);
//        t.start();
//        t.interrupt();
//
//
//
//        Thread currentThread = Thread.currentThread();
//        System.out.println(currentThread);

        Runnable useCounterRunable = new Runnable() {

            void increment(){

                synchronized (this) {
                    Counter.count++;
                    System.out.print(Counter.count + " ");
                }
            }

            @Override
            public void run() {
                increment();
                increment();
                increment();
            }
        };

        Thread t1 = new Thread(useCounterRunable);
        Thread t2 = new Thread(useCounterRunable);
        Thread t3 = new Thread(useCounterRunable);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("the final count is: " + Counter.count);
    }
}

class Counter {
    public static int count = 0;
}
