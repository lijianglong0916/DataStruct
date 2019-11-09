package tree;/*
 *@author:
 *@time
 */

public class HuffmanNode<E> {
    private E data;
    private int weight;
    public HuffmanNode leftNode;
    public HuffmanNode rightNode;

    public HuffmanNode() {
    }

    public HuffmanNode(E data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
