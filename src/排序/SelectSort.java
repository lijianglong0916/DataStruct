package 排序;/*
 *@author:
 *@time
 */

import java.util.Arrays;

/**
 * 插入排序
 * 从第一个数开始向后遍历，
 * 从第一个数开始将最小值交换至每次遍历的起始位置
 */
public class SelectSort {
    public static void selectSort(int[]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }
    public static void swap(int[]arr,int left,int right){
        arr[left]=arr[left]^arr[right];
        arr[right]=arr[left]^arr[right];
        arr[left]=arr[left]^arr[right];
    }

    public static void main(String[] args) {
        int[] a = {15, 56, 1, 21, 5, 16, 2, 69, 5, 498, 6, 1515, 45, 561, 23, 16, 65, 21, 2};
        System.out.println(Arrays.toString(a));
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
