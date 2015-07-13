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

//        Runnable useCounterRunable = new Runnable() {
//
//            void increment(){
//
//                synchronized (this) {
//                    Counter.count++;
//                    System.out.print(Counter.count + " ");
//                }
//            }
//
//            @Override
//            public void run() {
//                increment();
//                increment();
//                increment();
//            }
//        };
//
//        Thread t1 = new Thread(useCounterRunable);
//        Thread t2 = new Thread(useCounterRunable);
//        Thread t3 = new Thread(useCounterRunable);
//        t1.setName("t1");
//        t2.setName("t2");
//        t3.setName("t3");
//        t1.start();
//        t2.start();
//        t3.start();
//
//        try {
//            t1.join();
//            t2.join();
//            t3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("the final count is: " + Counter.count);
//    }

        final int[] numbers = {1,2,3,4,8,6,7,5,19,36,54,85,-32,54,18,6,4,5};



        FindMaxThread t = new FindMaxThread(numbers, 0, 19);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getMaxNum());




        final int[] maxNumbers = new int[2];
        final Counter counter = new Counter();
        FindMaxThread2.FindMaxThreadListener listener = new FindMaxThread2.FindMaxThreadListener() {
            @Override
            public void maxFound(int max, int id) {
                maxNumbers[id] = max;
                boolean isLast = false;
                synchronized (counter){
                    counter.counter++;
                    if (counter.counter == 2)
                        isLast = true;
                }
                if (isLast){
                    FindMaxThread2 lastFindMaxThread = new FindMaxThread2(maxNumbers, 0, maxNumbers.length, new FindMaxThread2.FindMaxThreadListener() {
                        @Override
                        public void maxFound(int max, int id) {
                            System.out.println("max is: " + max);
                        }
                    }, 0);
                    lastFindMaxThread.start();
                }
            }
        };


        FindMaxThread2 findMaxThread = new FindMaxThread2(numbers, 0, numbers.length/2, listener, 0);
        findMaxThread.start();

        FindMaxThread2 findMaxThread2 = new FindMaxThread2(numbers, numbers.length/2, numbers.length, listener, 1);
        findMaxThread2.start();


        }
    }


class Counter {
    public static int count = 0;
    int counter = 0;
}

class FindMaxThread extends Thread {

    private int[] numbers;
    private int from, to, maxNum;
    static boolean isFirstThread = true;

    public FindMaxThread(int[] numbers, int from, int to) {
        this.numbers = numbers;
        setFrom(from);
        setTo(to);
        isFirstThread = false;
    }

    public void setFrom(int from) {
        if (isFirstThread)
            this.from = 0;
        else
            this.from = from;
    }

    public void setTo(int to) {
        if (to>numbers.length)
            this.to = numbers.length;
        else
            this.to = to;
    }

    public int getMaxNum() {
        return maxNum;
    }

    @Override
    public void run() {
        if (from == numbers.length){
            maxNum = Integer.MIN_VALUE;
        }else {
            FindMaxThread continuingThread;
            if (from + to > numbers.length) {
                continuingThread = new FindMaxThread(numbers, to, numbers.length);
            } else {
                continuingThread = new FindMaxThread(numbers, to, from + to);
            }
            continuingThread.start();
            maxNum = numbers[from];
            for (int i = from; i < to; i++) {
                if (numbers[i] > maxNum)
                    maxNum = numbers[i];
            }
            try {
                continuingThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (continuingThread.maxNum > this.maxNum)
                maxNum = continuingThread.maxNum;
        }
    }
}

//teacher solution
class FindMaxThread2 extends Thread {

    private int[] numbers;
    private int from, to;
    private FindMaxThreadListener listener;
    private int id;

    public FindMaxThread2(int[] numbers, int from, int to, FindMaxThreadListener listener, int id) {
        this.numbers = numbers;
        this.from = from;
        this.to = to;
        this.listener = listener;
        this.id = id;
    }

    @Override
    public void run() {
        if (from<0 || from>to || to>numbers.length || numbers == null || numbers.length == 0)
            return;
        int max = numbers[from];
        for (int i = from+1; i < to; i++) {
            if (numbers[i] > max)
                max = numbers[i];
        }
        if (listener != null)
            listener.maxFound(max, id);
    }

    static  interface FindMaxThreadListener{
        void maxFound(int max, int id);
    }
}





