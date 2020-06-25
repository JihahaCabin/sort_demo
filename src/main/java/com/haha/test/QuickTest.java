package com.haha.test;


import com.haha.sort.Quick;

import java.util.Arrays;

public class QuickTest {

    public static void main(String[] args) {
        Integer[] arr = {6, 7, 9, 3, 5, 2, 1};
        Quick.sort(arr);

        // 输出结果
        System.out.println(Arrays.toString(arr));
    }
}
