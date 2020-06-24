package com.haha.test;


import com.haha.sort.Student;


public class TestComparable {


    public static void main(String[] args) {
        Student student1 = new Student("张三", 18);
        Student student2 = new Student("李四", 23);

        System.out.println(getMax(student1, student2));
    }

    public static Comparable getMax(Comparable c1, Comparable c2) {
        int result = c1.compareTo(c2);
        //如果result<0,c1小于c2
        //如果result>0,c1大于c2
        //如果result=0,c1和c2一样大
        if (result >= 0) {
            return c1;
        } else {
            return c2;
        }
    }
}
