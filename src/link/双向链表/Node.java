package link.双向链表;/*
 *@author:
 *@time
 */

public class Node<E> {
    private E data;
    private int id;
    private Node next;
    private Node perv;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", id=" + id +
                ", next=" + next +
                ", perv=" + perv +
                '}';
    }

    public Node(E data, int id) {
        this.data = data;
        this.id = id;

    }

    public Node getPerv() {
        return perv;
    }

    public void setPerv(Node perv) {
        this.perv = perv;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
