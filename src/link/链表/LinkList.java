package link.链表;/*
 *@author:
 *@time
 */

public class LinkList {
    private Node first;
    public LinkList(){
        first=null;
    }

    public void insert(Node node){
        Node currentNode=first;
        //如果头结点为空，则第一个数据插入为头结点并返回
        if(currentNode==null){
            first=node;
            return;
        }
        //头结点不为空时进入链表遍历直到最后一个节点
        while (true){
            Node nextNode=currentNode.next;
            if(nextNode==null){
                //最后一个节点的next为空退出遍历
                break;
            }
            currentNode=nextNode;
        }
        //将数据插入到最后一个节点的next
        currentNode.next=node;
    }
    public void remove(Node node){
        //当前节点
        Node currentNode=first;
        //前一个节点
        Node prevNode=first;
        //遍历当前节点（从first开始）是否与传入的节点相同
        while(currentNode!=node){
            //如果遍历到最后也没找到
            if(currentNode.next==null){
                System.out.println("没有该数据！");
                return;
            }else{
                //如果当前节点的下一个节点不为空，则前一个节点指向当前节点，当前节点指向当前节点的下一个节点
                prevNode=currentNode;
                currentNode=currentNode.next;
            }
        }
        //如果匹配到第一个节点
        if(currentNode == first){
            first=first.next;
        }else{
            prevNode.next=currentNode.next;
            System.out.println("已删除------->"+currentNode.getData());
        }
    }
    public void display(){
        while(first!=null){
            System.out.println(first.getData());
            first=first.next;
        }
    }
}
