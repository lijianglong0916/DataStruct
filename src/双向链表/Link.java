package 双向链表;/*
 *@author:
 *@time
 */

public class Link {
    private Node first;
    private Node last;
    public Link(){
        first=null;
        last=null;
    }
    public void insert(Node data){
        Node currentNode=first;
        if(currentNode==null){
            first=data;
            last=first;
            return;
        }
        while (currentNode.getNext()!=null){
            currentNode=currentNode.getNext();
        }
        currentNode.setNext(data);
        last=currentNode.getNext();
    }

    public Node remove(int id){
        Node currentNode=first;
        Node perNode=first;
        if(currentNode==null){
            System.out.println("error：链表为空");
            return null;
        }
        if(currentNode.getId()==id){
            System.out.println(currentNode.getData()+"-----------》已删除！");
            first=currentNode.getNext();
            return null;
        }
        while (currentNode.getId()!=id&&currentNode.getNext()!=null){
            perNode=currentNode;
            currentNode=currentNode.getNext();
        }
        if (currentNode.getId()==id){
            perNode.setNext(currentNode.getNext());
            System.out.println(currentNode.getData()+"-----------》已删除！");
            return currentNode;
        }else {
            System.out.println("链表中不存在该数据！");
            return null;
        }
    }
    public void display(){
        if(first==null){
            System.out.println("链表为空！");
            return;
        }
        while (first!=null){
            System.out.println(first.getData());
            first=first.getNext();
        }
    }
    public Node getData() {
        return first;
    }

    public void setData(Node data) {
        this.first = data;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }
}
