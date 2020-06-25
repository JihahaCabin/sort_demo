package com.haha.sort;

/**
 * 插入排序
 * 前面元素为有序，将后面的元素与之前的元素逐个比较大小，交换位置，直到元素找到其有序的位置
 * 时间复杂度为O(n^2)
 */
public class Insert {

    // 对数组a中的元素进行排序
    public static void sort(Comparable[] a) {
        //需要进行插入排序的起始位置
        for (int start = 1; start < a.length; start++) {
            //i表示需要排序的元素位置
            for (int i = start; i > 0; i--) {
                //如果排序元素小于之前的元素值，则该元素与排序元素交换位置
                if (greater(a[i - 1], a[i])) {
                    exch(a, i, i - 1);
                } else {
                    break;
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
