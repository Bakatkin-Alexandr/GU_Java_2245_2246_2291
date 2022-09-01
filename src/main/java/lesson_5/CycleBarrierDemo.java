package lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycleBarrierDemo {
    private static class Task implements Runnable {

        private final CyclicBarrier barrier;

        private Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(CycleBarrierDemo.class.getName() + "is waiting on barrier");
                barrier.await();
                System.out.println(CycleBarrierDemo.class.getName() + " has crossed the barrier");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("All Threads arrived at the barrier");
            }
        });

        Thread t1 = new Thread(new Task(cb), "Thread 1");
        Thread t2 = new Thread(new Task(cb), "Thread 2");
        Thread t3 = new Thread(new Task(cb), "Thread 3");
        Thread t4 = new Thread(new Task(cb), "Thread 3");
        Thread t5 = new Thread(new Task(cb), "Thread 3");
        Thread t6 = new Thread(new Task(cb), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
