package lesson_4;

public class TestS {

    public static void mstatic1(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void mstatic2(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class TestThreadStatic{
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                TestS.mstatic1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                TestS.mstatic2();
            }
        }).start();
    }
}