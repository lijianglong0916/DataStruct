package 排序;/*
 *@author:
 *@time
 */

import java.util.Arrays;

/**
 * 基数排序
 * 首先根据个位数的数值，在走访数值时将它们分配至编号0到9的桶子中：
 *接着再进行一次分配，这次是根据十位数来分配：
 * 百位数。。
 */
public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //获取最大数的位数，确定遍历的次数
        int times = (max + "").length();
        //用来存储的桶数组
        int storeArr[][]=new int[10][arr.length];
        //用来确定每个桶中放入了多少个数
        int index[];
        for(int i=0,n=1;i<times;i++,n=n*10){
            //每次遍历重新初始化桶，清空里面上次使用保留的数据
            index=new int[10];
            //遍历数组，将值放入对应的桶中
            for(int j=0;j<arr.length;j++){
                //依次根据n的值获取个位数、十位数等的数字，确定该数对应的桶子
                int value=arr[j]/n%10;
                //将值放入对应的桶子中
                storeArr[value][index[value]]=arr[j];
                //该桶中数据的数量+1
                index[value]++;
            }
            for(int k=0,m=0;k<10;k++){
                if(index[k]!=0){
                    for(int j=0;j<index[k];j++){
                        arr[m]=storeArr[k][j];
                        m++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {15, 56, 1, 21, 5, 16, 2, 69, 5, 498, 6, 1515, 45, 561, 23, 16, 65, 21, 2};
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }
}
