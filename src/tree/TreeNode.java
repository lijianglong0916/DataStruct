package tree;/*
 *@author:
 *@time
 */

public class TreeNode<E> {
    private E data;
    private TreeNode lNode;
    private TreeNode rNode;

    public TreeNode(E data) {
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

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
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

    public TreeNode search(E i) {
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

    /**
     * 获取当前节点的深度
     * @return
     */
    public int getHeight() {
         return Math.max(rNode==null?0:rNode.getHeight(), lNode==null?0:lNode.getHeight())+1;
    }

    public void delete(E data) {
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
                "data=" + data +'}';
    }

    public TreeNode(E data, TreeNode lNode, TreeNode rNode) {
        this.data = data;
        this.lNode = lNode;
        this.rNode = rNode;
    }
}
