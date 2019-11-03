package stack;/*
 *@author:
 *@time
 */

public class Stack {
    private int stackArray[];
    private int maxSize;
    private int top;
    public Stack(int size){
        this.maxSize=size;
        this.stackArray=new int[maxSize];
        this.top=-1;
    }
    public void push(int data){
        stackArray[++top]=data;
    }
    public int pop(){
        return stackArray[top--];
    }
    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==maxSize-1;
    }
}
