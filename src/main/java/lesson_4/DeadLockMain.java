package lesson_4;

public class DeadLockMain {
    static Object lock1 = new Object();

    public static void main(String[] args) {
        DeadLockOne one = new DeadLockOne();
        one.start();
        DeadLockTwo two = new DeadLockTwo();
        two.start();
    }

    static class DeadLockOne extends Thread{
        @Override
        public void run(){
            synchronized (lock1){
                System.out.println("Thread 1 держить Lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread1 ждет Lock2");
                synchronized (lock1){
                    System.out.println("Thread 1 держит Lock 1 и Lock2");
                }
            }
        }
    }

    static class DeadLockTwo extends Thread{
        @Override
        public void run(){
            synchronized (lock1){
                System.out.println("Thread 2 держить Lock 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread 2 ждет Lock 1");
                synchronized (lock1){
                    System.out.println("Thread 2 держит Lock 1 и Lock2");
                }
            }
        }
    }
}
