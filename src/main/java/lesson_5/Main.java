package lesson_5;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*ExecutorService pool = Executors.newFixedThreadPool(4, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                System.out.println("New Thread");
                return new Thread(r);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(1);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(2);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(3);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(4);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(5);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(6);
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(7);
            }
        });

        pool.awaitTermination(5, TimeUnit.SECONDS);

        pool.shutdownNow();*/

//        ArrayList
        /*Vector<String> v = new Vector<>();
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();*/

        /*ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        Map<String, String> hm = Collections.synchronizedMap(new HashMap<>());*/

        /*Semaphore semaphore = new Semaphore(3);

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(1);
                        System.out.println(semaphore.getQueueLength());
                        Thread.sleep(5000);
                        semaphore.release();
                        System.out.println(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        service.shutdown();*/

        /*CountDownLatch latch = new CountDownLatch(5);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.printf("Поток %d начал работу %n", finalI);
                    try {
                        Thread.sleep((int) Math.random() * 2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.printf("Поток %d подошел к защелке %n", finalI);
                    latch.countDown();
                    System.out.printf("Поток %d продолжил работу %n", finalI);
                }
            }).start();
        }

        latch.await();*/

        /*CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        for (int i = 0; i < 30; i++) {
            int w = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("start");

                    try {
                        Thread.sleep((int) Math.random() * 10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Поток " + w + " ожидает");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("end");
                }
            }).start();
        }*/

        AtomicInteger atomicInteger = new AtomicInteger(0);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                atomicInteger.incrementAndGet();
                if (atomicInteger.get() == 1){
                    System.out.println("1 thread win");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.incrementAndGet();
                if (atomicInteger.get() == 1){
                    System.out.println("2 thread win");
                }
            }
        }).start();
    }
}
