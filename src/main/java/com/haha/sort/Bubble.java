package com.haha.sort;

/**
 * 冒泡排序
 * 循环N*（N-1）/2,因此时间复杂度为O(n^2)
 */
public class Bubble {

    // 对数组a中的元素进行排序
    public static void sort(Comparable[] a) {
        // size表示用于对比的第一个元素的取值范围
        for (int size = a.length; size > 0; size--) {
            for (int i = 0; i < size - 1; i++) {
                // 比较相邻数据
                if (greater(a[i], a[i + 1])) {
                    exch(a, i, i + 1);
                }
            }
        }
    }

    // 比较c1是否大于c2;
    private static boolean greater(Comparable c1, Comparable c2) {
        int result = c1.compareTo(c2);
        return result > 0;
    }

    // 交换下标i和j的元素
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
