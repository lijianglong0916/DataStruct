package 递归;/*
 *@author:
 *@time
 */

public class TowerQuestion {
    public static void tower(int topN,char from,char inter,char to){
        if(topN==1)
            System.out.println("disk from  "+from+"  to  "+to);
        else {
            tower(topN-1,from,to,inter);
            System.out.println("disk from  "+from+"  to   "+to);
            tower(topN-1, inter, from, to);
        }
    }

    public static void main(String[] args) {
        tower(3, 'a', 'b', 'c');
    }
}
