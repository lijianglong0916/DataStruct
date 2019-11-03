package link.递归;/*
 *@author:
 *@time
 */

public class RecurrenceTest {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9};
        BinarySearch aaa=new BinarySearch(a);
        int data=aaa.search(1, 0, 8);
        if (data!=-1){
            System.out.println(a[data]);
        }
    }

}
