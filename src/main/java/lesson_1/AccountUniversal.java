package lesson_1;

public class AccountUniversal {
    private Integer count;
    private Long countLong;

    public AccountUniversal(Object count) {
        if (count instanceof Integer) {
            this.count = (Integer) count;
        }
        if (count instanceof Long) {
            this.countLong = (Long) count;
        }
    }

    public Object getCount() {
        return count;
    }

    public void addCount(Object c) {
        if (c instanceof Integer) {
            count += (Integer) c;
        }
        if (c instanceof Long) {
            countLong += (Long) c;
        }
    }

}
