package com.haha.sort;

/**
 * 选择排序
 * 每次遍历，找到当前范围内的最小元素，将该元素放在"遍历范围"的第一个位置中,再缩小"遍历范围"，继续排序
 * 时间复杂度为O(n^2)，比冒泡排序好一点，不用每次都交换
 */
public class Selection {

    // 对数组a中的元素进行排序
    public static void sort(Comparable[] a) {
        //i表示需要被交换的数据所在下标
        for (int i = 0; i <= a.length - 2; i++) {
            //本次遍历，最小值所在的索引，默认为参与排序的第一个元素所在下标
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                // 比较大小，如果后面的数据，比原来最小值下标所在数据要小，则交换洗标
                if (greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            // 找到最小值下标，交换到本次循环范围的第一个数
            exch(a, i, minIndex);
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
