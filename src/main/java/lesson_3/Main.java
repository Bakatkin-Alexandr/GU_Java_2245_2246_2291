package lesson_3;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
/*//        Есть таблица employees нужно написать запрос чтобы
//        получить все записи из таблицы в колонке last_name,
//        значения которые начинаются с A

//        SELECT LAST_NAME, FIRST_NAME FROM  EMPLOYEES WHERE LAST_NAME LIKE 'A%';

        *//*Напишите 1 запрос для обновления сразу двух
        колонок в таблице employees (столбцы name, surname)*//*

//        UPDATE EMPLOYEES SET NAME = 'ALEX', SURNAME = 'ALEX';

        *//*
        Получить данные по студенту сразу из двух таблиц (score, salary)
        1 таблица: поля --  id name score       -- table1
        2 таблица: поля --  id name salary      -- table2
        *//*
//        SELECT A1.SCORE, A2.SALARY FROM TABLE1 A1 LEFT JOIN TABLE2 A2 ON A1.NAME = A2.NAME;

        *//*Посчитать сколько студентов учатся на факультетах
        (1 студент может учиться сразу на нескольких факультетах)*//*

//        SELECT COUNT(STUDENTS) FROM TABLE GROUP BY FACULTET;*/

//        InputStream
//        OutputStream
//        InputStreamReader
//        OutputStreamWriter
//        File dir = new File("dirs");
        /*File file = new File("dirs/somefile.txt");
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        /*File file = new File("dir");
        String[] list = file.list();
        for (String n :
                list) {
            System.out.println(n);
        }*/

//        File file = new File("dir/123444111.txt");
        /*String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith("1");
            }
        });

        for (String n :
                list) {

            System.out.println(n);
        }*/

        /*File file = new File("dir/123444111.txt");
        System.out.println(file.renameTo(new File("dir/abc.txt")));*/

//        InputStream inputStream = new FileInputStream("dir/file.txt");

        /*InputStream url = new URL("http://google.com").openStream();

        InputStream array = new ByteArrayInputStream(new byte[]{90, 52, 73, 75, 81, 90});
        byte[] buffer = new byte[5];*/

        /*long l = System.currentTimeMillis();
        byte[] buffer = new byte[500];
        while (true){
            int read = inputStream.read(buffer);

            if (read != -1) {
                System.out.print(new String(buffer, 0, read, StandardCharsets.UTF_8));
            } else break;
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(System.currentTimeMillis() - l); //2239
        System.out.println(System.currentTimeMillis() - l); //34*/

        /*BufferedReader bufferedReader = null;
        FileReader fr = null;

        fr = new FileReader("dir/file.txt");
        bufferedReader = new BufferedReader(fr);

        String currentLine;

        while ((currentLine = bufferedReader.readLine()) != null){
            System.out.println(currentLine);
        }

        bufferedReader.close();
        fr.close();*/

        /*RandomAccessFile randomAccessFile = new RandomAccessFile("dir/file.txt", "rw");
        randomAccessFile.seek(100);
        System.out.println((char) randomAccessFile.read());*/

        ArrayList<InputStream> inputStreamArrayList = new ArrayList<>();
        inputStreamArrayList.add(new FileInputStream("dir/abc.txt"));
        inputStreamArrayList.add(new FileInputStream("dir/789.txt"));

        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(inputStreamArrayList));
        int x;

        while ((x = sequenceInputStream.read()) != -1){
            System.out.print((char) x);
        }

        sequenceInputStream.close();

    }
}
