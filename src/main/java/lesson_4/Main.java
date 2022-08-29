package lesson_4;

public class Main {
    public static void main(String[] args) {
        /*MyThreadClass t1 = new MyThreadClass();
        t1.start();

        Thread t2 = new Thread(new MyRunnableClass());
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        Thread r3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(i);
                }
            }
        });

        r3.start();

        while (true){
            if (!r3.isAlive()){
                break;
            }
        }

        System.out.println("END");
    }
}

class MyThreadClass extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}

class MyRunnableClass implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}