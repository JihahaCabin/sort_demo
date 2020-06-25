package com.haha.sort;

/**
 * 归并排序
 * 分而治之,以空间换时间
 * 时间复杂度O(NlogN)
 */
public class Merge {

    // 归并所需要的辅助数组
    private static Comparable[] assist;

    /**
     * 对数组a中的元素进行排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        //1. 初始化辅助数组assist
        assist = new Comparable[a.length];
        //2. 定义一个lo变量，和hi变量，分别记录数组中最小的索引和最大的索引
        int lo = 0;
        int hi = a.length - 1;
        //3. 调用sort重载方法完成数组a中，从索引lo到索引hi间的元素排序
        sort(a, lo, hi);
    }

    /**
     * 对数组a中数据，从索引lo到索引hi之间的元素进行排序
     *
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        // 做安全性校验
        if (hi <= lo) {
            return;
        }
        // 对lo到hi之间的数据分成两个组
        int mid = lo + (hi - lo) / 2;

        // 分别对每一组的数据进行排序
        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        // 把两个组的数据进行归并
        merge(a, lo, mid, hi);
    }

    /**
     * 从索引lo到索引mid为一组，从索引mid+1到索引hi为另一个子组，把数组中的这两个子组的数据，合并成一个有序的大组(从索引lo到索引hi)
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        //定义三个执政
        int i = lo;
        int assistIndex = i;
        int j = mid + 1;
        // 移动i j指针，比较索引处的值，找出小的那个，放到辅助数组恶的对应索引处
        while (i <= mid && j <= hi) {
            if (less(a[i], a[j])) {
                assist[assistIndex] = a[i];
                i++;
            } else {
                assist[assistIndex] = a[j];
                j++;
            }
            assistIndex++;
        }
        // 如果i的指针未走完，那么移动剩下的数据到辅助数组
        while (i <= mid) {
            assist[assistIndex] = a[i];
            i++;
            assistIndex++;
        }
        // 如果j的指针未走完，那么移动剩下的数据到辅助数组
        while (j <= hi) {
            assist[assistIndex] = a[j];
            j++;
            assistIndex++;
        }
        //将辅助数组的元素拷贝到原数组中
        for (int s = lo; s <= hi; s++) {
            a[s] = assist[s];
        }
    }

    /**
     * 判断v是否小于w
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换下标i和j的元素
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
