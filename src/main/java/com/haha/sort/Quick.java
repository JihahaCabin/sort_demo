package com.haha.sort;

/**
 * 快速排序
 * 平均时间复杂度 nlogn，最坏情况为O(n^2)
 */
public class Quick {

    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    // 对数组a 从索引lo到索引hi进行排序
    private static void sort(Comparable[] a, int lo, int hi) {
        //安全性检查
        if (hi <= lo) {
            return;
        }
        // 需要对数组lo索引到hi索引处的元素进行分组，（左子组和右子组）
        int partition = partition(a, lo, hi);//返回的是分组的分界值所在的索引，分界值位置变换后的索引
        //让左子组有序
        sort(a, lo, partition - 1);

        //让右子组有序
        sort(a, partition + 1, hi);
    }

    // 对索引lo到索引hi之间的元素进行分组，并返回分组界限所对应的索引
    private static int partition(Comparable[] a, int lo, int hi) {
        // 确定分界值
        Comparable key = a[lo];
        // 定义两个指针，分别指向待切分元素的最小索引处和最大索引处
        int left = lo + 1;
        int right = hi;
        //切分
        while (true) {
            //先从右到左扫描，移动right指针，找到一个比分界值小的元素，停止
            while (less(key, a[right]) && right > left) {
                right--;
            }
            //先从左到右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (less(a[left], key) && left < right) {
                left++;
            }
            //判断left>=right,如果是，元素扫描完毕，结束循环，如果不是，交换元素
            if (left >= right) {
                break;
            } else {
                exch(a, left, right);
            }
        }
        //交换分界值
        exch(a, lo, right);

        return right;
    }

    // 判断 v是否小于w
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // 交换a数组中，索引i和j处的值
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
