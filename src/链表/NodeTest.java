package 链表;/*
 *@author:
 *@time
 */

import bean.Person;

public class NodeTest {
    public static void main(String[] args) {
        Node node1=new Node(new Person(121,14,"张三1",123456789L));
        Node node2=new Node(new Person(122,15,"张三2",123456789L));
        Node node3=new Node(new Person(123,16,"张三3",123456789L));
        Node node4=new Node(new Person(124,17,"张三4",123456789L));
        Node node5=new Node(new Person(125,18,"张三5",123456789L));
        LinkList list =new LinkList();
        list.insert(node1);
        list.insert(node2);
        list.insert(node3);
        list.insert(node4);
        list.insert(node5);
        list.remove(node2);
        list.display();
//        node1.remove(node2);
    }

}
