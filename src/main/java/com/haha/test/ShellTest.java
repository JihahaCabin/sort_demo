package com.haha.test;


import com.haha.sort.Insert;
import com.haha.sort.Merge;
import com.haha.sort.Shell;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShellTest {

    public static void main(String[] args) throws IOException {

//        createFile();
        List<Integer> list = new ArrayList<Integer>();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ShellTest.class.getClassLoader().getResourceAsStream("reverse_arr.txt")));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            int i = Integer.parseInt(line);
            list.add(i);
        }
        bufferedReader.close();
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);

        //最坏情况测试
        //测试插入排序,10万条数据，使用时间 23146 ms
//        testInsertSort(arr);
        //测试希尔排序，10万条数据，使用时间 25ms
        testShellSort(arr);
        //测试归并排序，10万条数据，使用时间 80ms
//        testMergeSort(arr);
    }


    /**
     * 测试希尔排序
     *
     * @param arr
     */
    public static void testShellSort(Integer[] arr) {
        long start = System.currentTimeMillis();
        Shell.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("shell sort used time =" + (end - start));
    }

    /**
     * 测试插入排序
     *
     * @param arr
     */
    public static void testInsertSort(Integer[] arr) {
        long start = System.currentTimeMillis();
        Insert.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("insert sort used time =" + (end - start));
    }

    /**
     * 测试归并排序
     *
     * @param arr
     */
    public static void testMergeSort(Integer[] arr) {
        long start = System.currentTimeMillis();
        Merge.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("insert sort used time =" + (end - start));
    }

    /**
     * 生成测试txt
     *
     * @throws IOException
     */
    public static void createFile() throws IOException {

        File file = new File("./reverse_arr.txt");
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 100000; i > 0; i--) {
            stringBuffer.append(i + "\n");
        }
        fileOutputStream.write(stringBuffer.toString().getBytes());
        fileOutputStream.close();
    }
}
