package com.haha.serial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Teacher implements Serializable {

    private static final long serialVersionUID = -7634103752302773313L;
    private String name;

    private Integer age;

    //因为序列化保存的是对象的状态而非类的状态，所以会忽略static静态域
    //被transient或static修饰的字段 不会被序列化
    private transient String password;


    public Teacher() {
    }

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //自行编写readObject()函数，用于对象的反序列化构造，从而提供约束性
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {

        // 调用默认的反序列化函数
        objectInputStream.defaultReadObject();

        // 手工检查反序列化后年龄的有效性，若发现有问题，即终止操作！
        if (0 > age || 100 < age) {
            throw new IllegalArgumentException("年龄只能在0到100之间！");
        }
    }

}
