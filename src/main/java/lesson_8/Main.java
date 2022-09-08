package lesson_8;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*String str1 = "1"; // -- помещает в Pool строк
        String str2 = "1"; // -- ищеть в Pool строк, если находит, то возвращает
        String str3 = new String("1"); // -- не ищет в Pool строк, а создает новый объект
        String str4 = "1";
        String intern = str3.intern();

        System.out.println(str4 == str1);
        System.out.println(str4 == str3);
        System.out.println(str4 == intern);
        System.out.println(str4 == str1);
        System.out.println(intern == str1);
        System.out.println(str4 == str3);*/

//        Integer i1 = 1;
//        Integer i2 = 1;
//        Integer i3 = 200;
//        Integer i4 = 200;
//
//        System.out.println(i1 == i2);// попали в пул Integer
//        System.out.println(i3 == i4);//не попали в пул Integer

//        Long l1 = 2L;
//        Long l2 = 2L;
////
//        Long l3 = -129L;
//        Long l4 = -129L;

//        System.out.println(l1 == l2);
//        System.out.println(l3 == l4);

//        Cat cat = new Cat();
//        System.out.println(cat);
//
//        StringBuilder names = cat.getNames();
//        names.append("new Barsik");
//
//        System.out.println(cat);
//
//        Map<String, String> map = new HashMap<>(8, 0.75f);
//
//        try{
//            throw new ...
//        } catch (){
//            throw new ...
//        } finally {
//            return 20;
//        }

        /*try (InputStream in) {

        } catch (...){

        } finally {
            in.close();
        }*/

        Test test = new Test();

        try {
            test.test();
        } catch (Exception e) {
            try {
                int i = 10/0;
            } catch (ArithmeticException ex){
                System.out.println("Отработал блок catch внутреннего уровня");
                ex.printStackTrace();
            } finally {
                System.out.println("Отработал блок final внутреннего уровня");
            }
        } finally {
            System.out.println("Отработал блок final верхнего уровня");
        }
    }
}
