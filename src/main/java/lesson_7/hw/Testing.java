package lesson_7.hw;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Testing {
    public static void main(String[] args) throws BeforeAfterNotUniqeException, InvocationTargetException, IllegalAccessException {
        Class<Tests> tests = Tests.class;
        Tests test = new Tests();

        Method[] methods = tests.getDeclaredMethods();
        ArrayList<Method> methodsBefore = new ArrayList<>();
        ArrayList<Method> methodsAfter = new ArrayList<>();

        //Проверяем уникальность методов с аннотациями @BeforeSuite и @AfterSuite
        for (Method o: methods
        ) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (methodsBefore.isEmpty()) {
                    methodsBefore.add(o);
                } else {
                    throw new BeforeAfterNotUniqeException("BeforeSuite");
                }
            }

            if (o.isAnnotationPresent(AfterSuite.class)){
                if(methodsAfter.isEmpty()){
                    methodsAfter.add(o);
                } else {
                    throw new BeforeAfterNotUniqeException("AfterSuite");
                }
            }
        }

        //Запускаем метод с аннотацией @BeforeSuite
        methodsBefore.get(0).invoke(test);

        //Запускаем методы с аннотацией @Start в зависимости от приоритета
        for (int i = 1; i <= 10; i++) {
            for (Method method : methods) {
                if(method.isAnnotationPresent(Test.class)){
                    if(method.getAnnotation(Test.class).priority() == i){
                        method.invoke(test);
                    }
                }
            }
        }

        //Запускаем метод с аннотацией @AfterSuite
        methodsAfter.get(0).invoke(test);
    }
}
