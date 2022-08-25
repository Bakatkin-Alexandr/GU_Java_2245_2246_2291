package lesson_3;

import java.io.*;

public class Student implements Serializable {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void info(){
        System.out.println(id + " " + name);
    }

}

class MainStudent {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Student student = new Student(10, "Bob");
//
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.serialize"));
//        objectOutputStream.writeObject(student);
//        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.serialize"));
        Student o = (Student) objectInputStream.readObject();
        objectInputStream.close();

        o.info();
    }
}