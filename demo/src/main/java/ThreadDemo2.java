import com.example.demo.ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo2 {

    AtomicInteger startNo = new AtomicInteger();
    int endNo = 10;
    int noOfThreads = 3;
    public  void printNumbers() throws InterruptedException {
        while(startNo.get() <=endNo){

                System.out.println("startNo is "+ startNo + " with the thread Name is :" +Thread.currentThread().getName());
                Thread.sleep(100);
                startNo.getAndIncrement();
        }

    }
    public static void main(String[] args) {


        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    threadDemo2.printNumbers();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


    }
}
