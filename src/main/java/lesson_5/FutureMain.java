package lesson_5;

import java.util.concurrent.*;

public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        int[] source = {1, 2, 3, 4};

        int[] res1 = new int[2];
        int[] res2 = new int[2];

        System.arraycopy(source, 0, res1, 0, res1.length);
        System.arraycopy(source, 2, res2, 0, res2.length);

        Callable<Integer> callable1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res = 0;

                for (int i = 0; i < res1.length; i++) {
                    res += res1[i];
                }

                Thread.sleep(5000);
                return res;
            }
        };

        Callable<Integer> callable2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res = 0;

                for (int i = 0; i < res2.length; i++) {
                    res += res2[i];
                }

                Thread.sleep(100);
                return res;
            }
        };

        Future<Integer> future1 = executorService.submit(callable1);
        Future<Integer> future2 = executorService.submit(callable2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!future1.isDone()){
                    System.out.println("Future 1 still working");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!future2.isDone()){
                    System.out.println("Future 2 still working");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        /*while (!future1.isDone() && !future2.isDone()){
            System.out.println("Still working...");
            Thread.sleep(100);
        }*/
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future1.get() + future2.get());


        executorService.shutdown();
    }
}
