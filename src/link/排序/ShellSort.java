package link.排序;/*
 *@author:
 *@time
 */

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[]arr,int step){
        if(step==0)
            return;
        for(int i=0;i<arr.length-1;i+=step){
            if(i+step<=(arr.length-1)&&arr[i]>arr[i+step]){
                for(int j=i;j>=0&&arr[j]>arr[j+step];j-=step){
                    swap(arr ,j, j+step);
                }
            }
        }
        step=step/2;
        shellSort(arr,step);
    }
    public static void swap(int[]arr,int left, int right){
        arr[left]=arr[left]^arr[right];
        arr[right]=arr[left]^arr[right];
        arr[left]=arr[left]^arr[right];
    }

    public static void main(String[] args) {
        int[]a={1,4,1,11,49,2,566,4,5151,7,8,5,12,44};
        System.out.println(Arrays.toString(a));
        Long beginTime=System.currentTimeMillis();
        shellSort(a,a.length/2);
        Long currentTime=System.currentTimeMillis();
        System.out.println("用时"+(currentTime-beginTime)+"毫秒！");// new Date()为获取当前系统时间
        System.out.println(Arrays.toString(a));
    }
}
