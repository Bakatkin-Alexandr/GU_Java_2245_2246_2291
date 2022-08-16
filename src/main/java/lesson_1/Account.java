package lesson_1;

public class Account <T> {
    private T count;

    public Account(T count) {
        this.count = count;
    }

    public T getCount() {
        return count;
    }

    public void setCount(T count) {
        this.count = count;
    }

    public String info(){
        return count.getClass().getName();
    }
}
