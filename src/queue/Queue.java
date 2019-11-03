package queue;/*
 *@author:
 *@time
 */

public class Queue {
    private int[]arrayQue;
    private int maxSize;
    private int top;
    private int front;
    private int length;
    public Queue(int size){
        this.maxSize=size;
        this.arrayQue=new int[maxSize];
        this.top=-1;
        this.front=0;
        this.length=0;
    }
    public void insert(int data){
        if(top==maxSize-1){
            top=-1;
        }
        if(length>=maxSize){
            System.out.println("队列已满！  "+data);
            return;
        }
        arrayQue[++top]=data;
        length++;
    }
    public int remove(){
        int data = arrayQue[front++];
        if(length>0){
            length--;
        }
        if(front==maxSize){
            front=0;
        }
        return data;
    }

    public boolean isEmpty(){
        return length==0;
    }
}
