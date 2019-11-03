package queue;/*
 *@author:
 *@time
 */

public class QueueTest {
    public static void main(String[] args) {
        Queue queue=new Queue(6);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
//        queue.insert(80);
        while(!queue.isEmpty()){
            System.out.print(queue.remove()+"  ");
        }

    }
}
