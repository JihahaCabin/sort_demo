package com.haha.sort;

/**
 * 希尔排序
 * 选定一个增长量，按照增长量对数据分组
 * 对分好组的每一组数据进行插入排序
 * 减少增长量(最小减为1)，重复上一步骤
 * <p>
 * 增长量确定规则，目前没有说最好的增长量要是多少好，个说个话
 * int h=1;
 * for(h<arr.length){
 * h=2*h+1;
 * }
 * 增长量减小规则
 * h = h/2
 */
public class Shell {

    // 对数组a中的元素进行排序
    public static void sort(Comparable[] a) {
        //确定增长量
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }
        // 当增长量小于1时，排序结束
        while (h >= 1) {
            //找到待插入的元素
            for (int i = h; i < a.length; i++) {
                // 将待插入的元素插入到有序数列中
                for (int j = i; j >= h; j -= h) {
                    // 待插入的元素是a[j],比较a[j]和a[j-h]
                    if (greater(a[j - h], a[j])) {
                        //交换元素
                        exch(a, j - h, j);
                    } else {
                        //如果不大于，则待插入元素已找到合适位置
                        break;
                    }
                }
            }
            h = h / 2;
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
