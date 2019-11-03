package link.排序;/*
 *@author:
 *@time
 */

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[]arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                for(int j=i;j>=0&&arr[j]<arr[j-1];j--){
                    swap(arr,j-1,j);
                }
            }
        }
    }

    public static void swap(int[]arr,int left,int right){
        arr[left]=arr[left]^arr[right];
        arr[right]=arr[left]^arr[right];
        arr[left]=arr[left]^arr[right];
//        int temp=arr[left];
//        arr[left]=arr[right];
//        arr[right]=temp;
    }

    public static void main(String[] args) {
        int[]a={1,4,1,11,49,2,566,4,5151,7,8,5,12,44};
        System.out.println(Arrays.toString(a));
        Long beginTime=System.currentTimeMillis();
        insertSort(a);
        Long currentTime=System.currentTimeMillis();
        System.out.println("用时"+(currentTime-beginTime)+"毫秒！");// new Date()为获取当前系统时间
        System.out.println(Arrays.toString(a));
    }
}
