package 双向链表;/*
 *@author:
 *@time
 */

public class DoubleLink {
    private Node first;
    public int length;
    public DoubleLink(){
        first=null;
        length=0;
    }
    public void insert(Node data){
        if (first==null&&length==0){
            first=data;
            length++;
            return;
        }
        Node currentNode=first;
        data.setNext(currentNode);
        currentNode.setPerv(data);
        first=data;
    }
    public Node remove(int id){
        Node currentNode=first;
        Node prevNode=currentNode;
        if(first==null){
            System.out.println("该链表是空链表！");
            return null;
        }
        if(id==first.getId()){
            first=currentNode.getNext();
            currentNode.getNext().setPerv(null);
            return currentNode;
        }
        while (id!=currentNode.getId()){
            prevNode=currentNode;
            currentNode=currentNode.getNext();
        }
        if (id==currentNode.getId()){
            if(currentNode.getNext()==null){
                prevNode.setNext(null);
                return currentNode;
            }
            currentNode.getNext().setPerv(prevNode);
            prevNode.setNext(currentNode.getNext());
            return currentNode;
        }else {
            System.out.println("该链表中没有该数据！");
            return null;
        }
    }
    public void display(){
        while(first!=null){
            System.out.println(first.getData());
            first=first.getNext();
        }

    }
    public boolean isEmpty(){
        return first==null;
    }
}
