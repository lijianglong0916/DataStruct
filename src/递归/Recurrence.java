package 递归;/*
 *@author:
 *@time
 */

public class Recurrence {

    public static int number(int i) {
        if (i == 1) {
            return i;
        } else {
            return i * number(--i);
        }
    }

    public static void main(String[] args) {
        int i = number(4);
        System.out.println(i);
    }
}
