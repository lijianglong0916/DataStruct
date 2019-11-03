package link.链表;/*
 *@author:
 *@time
 */

public class Node<E> {
    private E data;
    public Node next;

    public E getData() {
        return data;
    }
    public Node(E data) {
        this.data=data;
    }


    public void setData(E data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
