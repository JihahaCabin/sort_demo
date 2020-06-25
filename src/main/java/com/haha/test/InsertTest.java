package com.haha.test;

import com.haha.sort.Insert;

import java.util.Arrays;

public class InsertTest {

    public static void main(String[] args) {
        Integer[] arr = {4, 5, 7, 2, 76, 98, 23, 456, 2};
        Insert.sort(arr);

        // 输出结果
        System.out.println(Arrays.toString(arr));
    }
}
