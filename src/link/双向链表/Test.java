package link.双向链表;/*
 *@author:
 *@time
 */

import link.Person;

public class Test {
    public static void main(String[] args) {
        Node node1=new Node(new Person(121,14,"张三1",123456789L),1);
        Node node2=new Node(new Person(122,15,"张三2",123456789L),2);
        Node node3=new Node(new Person(123,16,"张三3",123456789L),3);
        Node node4=new Node(new Person(124,17,"张三4",123456789L),4);
        Node node5=new Node(new Person(125,18,"张三5",123456789L),5);
        OrderLink link=new OrderLink();
        link.insert(node5);
        link.insert(node2);
        link.insert(node1);
        link.insert(node3);
        link.insert(node4);
        link.remove(5);
        link.display();
    }
}
