package com.sjq.demo01_myBatisHello;

public class pai {
    public static void quick(int[] a, int l, int h) {
        if (l >= h) {
            return;
        }
        int p = partition(a, l, h); // p 索引值
        quick(a, l, p - 1); // 左边分区的范围确定
        quick(a, p + 1, h); // 左边分区的范围确定
    }
    private static int partition(int[] a, int l, int h) {
        int pv = a[h]; // 基准点元素
        int i = l;
        for (int j = l; j < h; j++) {
            if (a[j] < pv) {
                if (i != j) {
                    swap(a, i, j);
                }
                i++;
            }
        }
        if (i != h) {
            swap(a, h, i);
        }
// 返回值代表了基准点元素所在的正确索引，用它确定下一轮分区的边界
        return i;
}
public static void swap(int[] a ,int i ,int j){
        int t = a[i];
                a[i]=a[j];
                a[j]=t;
    }
}
