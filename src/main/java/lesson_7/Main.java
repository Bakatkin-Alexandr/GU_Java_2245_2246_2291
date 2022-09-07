package lesson_7;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
//        класс Class.
//        Cat cat = new Cat("Barsik", 10);
//        Class<Cat> catClass = Cat.class;

//        Class<Cat> catClass = (Class<Cat>) cat.getClass();

//        Class<?> cClass = Class.forName("java.lang.Byte");

//        System.out.println(catClass.getName());
//        System.out.println(catClass.getSimpleName());
//
//        int modifiers = catClass.getModifiers();
//        System.out.println(Modifier.isInterface(modifiers));
//
////        catClass.getSuperclass();
////        catClass.getInterfaces();
//
//        Method[] methods = catClass.getMethods();
//        Method[] declaredMethods = catClass.getDeclaredMethods();
//        catClass.getMethod("info", String.class, Integer.class);
//
//        Field[] fields = catClass.getFields();
//        Field[] declaredFields = catClass.getDeclaredFields();

//        Field[] declaredField = catClass.getDeclaredFields();
//
//        for (Field f :
//                declaredField) {
//            System.out.println(f);
//        }
//
//        Field age = catClass.getDeclaredField("age");
//        age.setAccessible(true);
//        age.set(cat, 13);
//
//        System.out.println(cat);
        //@Deprecated

        //Date date = new Date(2020, 10, 10);

        CatAnnotation catAnnotation = new CatAnnotation("Murzik", "black", 10, 10);
        Class<CatAnnotation> catAnnotationClass = CatAnnotation.class;

        for (Method method :
                catAnnotationClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)){
                if (method.getAnnotation(MyAnnotation.class).priority() > 6){
                    System.out.println(method.getAnnotation(MyAnnotation.class).priority());
                    method.invoke(catAnnotation);
                }
            }
        }
    }
}
