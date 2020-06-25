package com.haha.test;

import com.haha.serial.Teacher;

import java.io.*;

public class SerializeTest {

    public static void main(String[] args) throws Exception {
        serialize();
        deserialize();
    }

    public static void serialize() throws Exception {
        Teacher teacher = new Teacher("张三", 123);

        File file = new File("Teacher.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(teacher);
        objectOutputStream.close();

        System.out.println("序列化成功，生成Teacher.txt");

    }

    public static void deserialize() throws Exception {
        File file = new File("Teacher.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Teacher teacher = (Teacher) objectInputStream.readObject();
        System.out.println("反序列化结果");
        System.out.println(teacher.toString());
    }
}
