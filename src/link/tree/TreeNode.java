package link.tree;/*
 *@author:
 *@time
 */

public class TreeNode {
    private int data;
    private TreeNode lNode;
    private TreeNode rNode;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode getlNode() {
        return lNode;
    }

    public void setlNode(TreeNode lNode) {
        this.lNode = lNode;
    }

    public TreeNode getrNode() {
        return rNode;
    }

    public void setrNode(TreeNode rNode) {
        this.rNode = rNode;
    }

    public void frontTra() {
        System.out.print(data + "  ");
        if (lNode != null) {
            lNode.frontTra();
        }
        if (rNode != null) {
            rNode.frontTra();
        }
    }

    public void midTra() {
        if (lNode != null) {
            lNode.midTra();
        }
        System.out.print(data + "  ");
        if (rNode != null) {
            rNode.midTra();
        }
    }

    public void behindTra() {
        if (lNode != null) {
            lNode.behindTra();
        }
        if (rNode != null) {
            rNode.behindTra();
        }
        System.out.print(data + "  ");
    }

    public TreeNode search(int i) {
        TreeNode target = null;
        if (i == this.data) {
            return this;
        } else {
            if (lNode != null) {
                target = lNode.search(i);
            }
            if (target != null)
                return target;
            if (rNode != null) {
                target = rNode.search(i);
            }
        }
        return target;
    }

    public void delete(int data) {
        TreeNode parentNode = this;
        if (parentNode.getlNode() != null && parentNode.getlNode().data == data) {
            parentNode.setlNode(null);
            return;
        }
        if (parentNode.getrNode() != null && parentNode.getrNode().data == data) {
            parentNode.setrNode(null);
            return;
        }
        if (lNode != null) {
            lNode.delete(data);
        }
        if (rNode != null) {
            rNode.delete(data);
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", lNode=" + lNode +
                ", rNode=" + rNode +
                '}';
    }

    public TreeNode(int data, TreeNode lNode, TreeNode rNode) {
        this.data = data;
        this.lNode = lNode;
        this.rNode = rNode;
    }
}