package lesson_5.race;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        CountDownLatch cd1 = new CountDownLatch(CARS_COUNT);
        CountDownLatch cd2 = new CountDownLatch(CARS_COUNT);
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ConcurrentLinkedDeque<String> win = new ConcurrentLinkedDeque<>();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            Integer integer = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cars[integer] = new Car(race, 20 + (int) (Math.random() * 10));
                    cd1.countDown();
                }
            }).start();
        }
        try {
            cd1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        for (int i = 0; i < cars.length; i++) {
            Integer integer = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cars[integer].run();
                    cd2.countDown();
                    lock.writeLock().lock();
                    win.add(cars[integer].getName());
                    if (win.getFirst().equals(cars[integer].getName())){
                        System.out.println(cars[integer].getName() + " - WIN");
                    }
                    lock.writeLock().unlock();
                }
            }).start();
        }
        try {
            cd2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
