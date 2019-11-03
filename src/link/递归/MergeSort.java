package link.递归;/*
 *@author:
 *@time
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4, 6, 8, 4, 5, 9, 1};
        mergeSort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int left = 0;
        int right = arr.length - 1;
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right)
            return;
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < right - left + 1; i++) {
            arr[left + i] = help[i];
        }
    }
}
