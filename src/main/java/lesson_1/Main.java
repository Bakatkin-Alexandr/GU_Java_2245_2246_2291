package lesson_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
       /* AccountInt accountInt1 = new AccountInt(100);
        AccountInt accountInt2 = new AccountInt(200);

        System.out.println(accountInt1.getCount());
        System.out.println(accountInt2.getCount());*/

        /*AccountUniversal a1 = new AccountUniversal(100);
        AccountUniversal a2 = new AccountUniversal(200.0);
        AccountUniversal aString = new AccountUniversal("300");

        System.out.println(a2.getCount());

        int x = (Integer) a1.getCount();
        int y = (Integer) a2.getCount();*/

        /*Account<Integer> integerAccount = new Account<>(200);
        Account<Double> doubleAccount = new Account<>(300.0);*/
//        Account<int> doubleAccount = new Account<>(300.0);

        /*System.out.println(integerAccount.info());
        System.out.println(doubleAccount.info());

        Integer x = integerAccount.getCount();
        Double y = doubleAccount.getCount();

        List<String> list = new ArrayList<>();
        List<Integer> listInt = new ArrayList<>();

        *//*Object[] array = new Long[10];
        array[0] = "123";*//*

        list.add(String.valueOf(100L));
        Map<String, Integer> map = new HashMap<>();*/

        Stats<Double> stats1 = new Stats<>(new Double[]{1.0, 2.0, 3.0});
        Stats<Double> stats2 = new Stats<>(new Double[]{0.0, 2.0, 4.0});
//        System.out.println(stats1.sameAvg(stats2));

        Stats<Integer> integerStats = new Stats<>(new Integer[]{1, 2, 3});

//        Stats<String> strStats = new Stats<>(new String[]{"1", "2", "3"});

//        System.out.println(stats1.sameAvg(stats2));
        /*Object o = new Long(12);

        Object[] array = new String[10];
        array[0] = "123";

        List<Object> list = new ArrayList<Long>();
        list.add("");*/
    }
}
