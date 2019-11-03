package link.双向链表;/*
 *@author:
 *@time
 */

public class OrderLink {
    private Node first;
    public int length;
    public OrderLink(){
        first=null;
        length=0;
    }
    public void insert(Node node){
        if (node==null){
            System.out.println("要插入的节点为空！");
            return;
        }
        if(first==null){
            first=node;
            return;
        }
        Node currentNode=first;
        Node prevNode=first;
        if(node.getId()<first.getId()){
            first=node;
            node.setNext(currentNode);
            return;
        }
        while (node.getId()>=currentNode.getId()){
            prevNode=currentNode;
            currentNode=currentNode.getNext();
        }
        prevNode.setNext(node);
        node.setNext(currentNode);
    }
    public Node remove(int id){
        if(first==null){
            System.out.println("链表为空，无法操作！");
            return null;
        }
        Node currentNode=first;
        Node prevNode=first;
        if(id==first.getId()){
            first=currentNode.getNext();
            return currentNode;
        }
        while(id!=currentNode.getId()){
            prevNode=currentNode;
            currentNode=currentNode.getNext();
        }
        if(id==currentNode.getId()){
            prevNode.setNext(currentNode.getNext());
            return currentNode;
        }else{
            System.out.println("链表中无该数据！");
            return null;
        }
    }

    public void display(){
        if(first==null){
            System.out.println("空链表无数据！");
            return;
        }
        Node currentNode=first;
        while(currentNode!=null){
            System.out.println(currentNode.getData());
            currentNode=currentNode.getNext();
        }
    }
}
