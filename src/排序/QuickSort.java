package 排序;/*
 *@author:
 *@time
 */

import java.util.Arrays;

public class QuickSort {
    /**
     * 从第一个数开始作标记数，依次从最后向前比较，如果第一个数比后面的大时，
     * 互换位置，如果第一个数换到后面，则遍历从第二个数开始往后
     * 遍历过程中有比后面一个大的，互换位置，然后从标记数换过来的位置-1向前遍历，直到下标相同
     * 一轮结束后，标记数为点，该点前面的一定比该数小，后面的一定比该数大
     * 然后按标记数的位置将数组分为两部分，继续上面的排序，
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        int begin = 0;
        int end = arr.length - 1;
        quickSort(arr, begin, end);

    }

    public static void quickSort(int[] arr, int begin, int end) {
        //每次进入遍历时从最后一个开始向前遍历
        boolean inBegin = true;
        int left = begin;
        int right = end;
        //标记标志位
        int title = begin;
        if (begin >= end)
            return;
        while (left < right) {
            if (inBegin == true) {
                while (arr[left] <= arr[right] && left < right) {
                    right--;
                }
                if (arr[left] > arr[right] && left < right) {
                    inBegin = (!inBegin);
                    swap(arr, left, right);
                    //转移后标志数的所在数组下标
                    title = right;
                }
            }
            if (inBegin == false) {
                while (arr[left] <= arr[right] && left < right) {
                    left++;
                }
                if (arr[left] > arr[right]) {
                    inBegin = (!inBegin);
                    swap(arr, left, right);
                    //转移后标志数的所在数组下标
                    title = left;
                }

            }
        }
        quickSort(arr, begin, title);
        quickSort(arr, title + 1, end);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {15, 56, 1, 21, 5, 16, 2, 69, 5, 498, 6, 1515, 45, 561, 23, 16, 65, 21, 2};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
