package lesson_4.shop;

public class Store {

    private int product = 0;

    public synchronized void get(){
        while (product < 1){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        product--;
        System.out.println("Покупатель купиль один товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    public synchronized void put(){
        while (product >= 3){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        product++;
        System.out.println("Производитель добавил один товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
}
