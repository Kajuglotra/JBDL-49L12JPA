package com.example.demo;

public class ThreadDemo {
    int startNo = 0;
    int endNo =10;


    public void printEven() throws InterruptedException {
        System.out.println("in even function startNo is "+startNo );
        while(startNo < endNo){
            if(startNo %2 == 0){
                System.out.println("Thread nane :  " +Thread.currentThread().getName()+ "in printEven with the startNo :"+ startNo);
                startNo++;
                Thread.sleep(1000);
            }
        }
    }
    public void printOdd() throws InterruptedException {
        System.out.println("in odd function startNo is "+startNo );
        while (startNo < endNo) {
            if (startNo % 2 != 0) {
                System.out.println("Thread nane :  " +Thread.currentThread().getName()+ " in printOdd with the startNo :"+ startNo);
                Thread.sleep(1000);
                startNo++;
            }
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadDemo.printEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadDemo.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread2.start();
    }
}
