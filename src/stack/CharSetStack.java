package stack;/*
 *@author:
 *@time
 */

public class CharSetStack {
    private char[] stackArray;
    private int maxSize;
    private int top;
    public CharSetStack(int size){
        maxSize=size;
        stackArray=new char[maxSize];
        top=-1;
    }

    public void push(char data){
        stackArray[++top]=data;
    }

    public char pop(){
        return stackArray[top--];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void disPlay(){
        for (int i=0;i<top;i++){
            System.out.print(stackArray[i]+"  ");
        }
    }
}
