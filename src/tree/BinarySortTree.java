package tree;/*
 *@author:
 *@time
 */

public class BinarySortTree {
    private TreeNode node;

    public TreeNode getNoBalanceNode() {
        return noBalanceNode;
    }

    private TreeNode noBalanceNode = null;

    public BinarySortTree() {
    }

    public BinarySortTree(TreeNode node) {
        this.node = node;
    }

    public void changeToBalanceBinaryTree(){
        isBalanceBinaryTree(node);
        while (noBalanceNode!=null){
            int leftDeep=0;
            int rightDeep=0;
            int l=0;
            int r=0;
            if (noBalanceNode.getlNode() != null ) {
                leftDeep= node.getlNode().getHeight();
            }
            if(noBalanceNode.getrNode() != null){
                rightDeep= node.getrNode().getHeight();
            }
            if (leftDeep > rightDeep) {
                //非平衡二叉树时且左边比右边深，该节点的左节点的左节点深度比右节点深度浅，先右旋
                if(noBalanceNode.getlNode()!=null){
                    if(noBalanceNode.getlNode().getlNode()!=null){
                        l=noBalanceNode.getlNode().getlNode().getHeight();
                    }
                    if(noBalanceNode.getlNode().getrNode()!=null){
                        r=noBalanceNode.getlNode().getrNode().getHeight();
                    }
                    if(l<r){
                        rightChange(noBalanceNode.getlNode());
                    }
                }
                leftChange(noBalanceNode);
            } else {
                if(noBalanceNode.getrNode()!=null){
                    //非平衡二叉树时且右边比左边深，该节点的右节点的左节点深度比右节点深度深，先左旋旋
                    if(noBalanceNode.getrNode().getlNode()!=null){
                        l=noBalanceNode.getrNode().getlNode().getHeight();
                    }
                    if(noBalanceNode.getrNode().getrNode()!=null){
                        r=noBalanceNode.getrNode().getrNode().getHeight();
                    }
                    if(l>r){
                        rightChange(noBalanceNode.getrNode());
                    }
                }
                rightChange(noBalanceNode);
            }
            noBalanceNode=null;
            isBalanceBinaryTree(node);
        }
    }

    /**
     * 左旋为平衡二叉树
     * @param node
     */
    public void leftChange(TreeNode node) {
        TreeNode currentNode=new TreeNode(node.getData());
        if(node.getrNode()==null){
            node.setData(node.getlNode().getData());
            node.setlNode(node.getlNode().getlNode());
            node.setrNode(currentNode);
        }else{
            currentNode.setrNode(node.getrNode());
            currentNode.setlNode(node.getlNode().getrNode());
            node.setData(node.getlNode().getData());
            node.setlNode(node.getlNode().getlNode());
            node.setrNode(currentNode);
        }
    }

    /**
     * 右旋为平衡二叉树
     * @param node
     */
    public void rightChange(TreeNode node) {
        TreeNode currentNode=new TreeNode(node.getData());
        if(node.getlNode()==null){
            node.setData(node.getrNode().getData());
            node.setrNode(node.getrNode().getrNode());
            node.setlNode(currentNode);
        }else{
            currentNode.setlNode(node.getlNode());
            node.setData(node.getrNode().getData());
            node.setrNode(node.getrNode().getrNode());
            node.setlNode(currentNode);
        }
    }

    /**
     * 判断该树是否是平衡树，如果不是，调整为平衡二叉树
     *
     * @return
     */
    public void isBalanceBinaryTree(TreeNode node) {
        if (node == null) {
            return;
        }
        if (isBalanceBinaryNode(node) == true) {
            isBalanceBinaryTree(node.getlNode());
            isBalanceBinaryTree(node.getrNode());
        } else {
            noBalanceNode = node;
        }

    }

    /**
     * 判断该节点以下是否是平衡二叉树
     *
     * @return
     */
    public boolean isBalanceBinaryNode(TreeNode node) {

        int heightCut = 0;
        if (node.getlNode() != null && node.getrNode() != null) {
            heightCut = node.getlNode().getHeight() - node.getrNode().getHeight();
        }
        if (node.getlNode() != null && node.getrNode() == null) {
            heightCut = node.getlNode().getHeight();
        }
        if (node.getlNode() == null && node.getrNode() != null) {
            heightCut = node.getrNode().getHeight();
        }
        if (heightCut * heightCut > 1)
            return false;
        return true;
    }

    /**
     * 向二叉排序树中添加元素
     *
     * @param data
     */
    public void add(TreeNode data) {
        if (data == null) {
            System.out.println("传入的节点为空！");
            return;
        }
        if (node == null) {
            node = data;
            return;
        }
        TreeNode currentNode = this.node;

        while (true) {
            if ((int) currentNode.getData() >= (int) data.getData()) {
                if (currentNode.getlNode() == null)
                    break;
                currentNode = currentNode.getlNode();
            } else {
                if (currentNode.getrNode() == null)
                    break;
                currentNode = currentNode.getrNode();
            }
        }
        if ((int) currentNode.getData() >= (int) data.getData()) {
            currentNode.setlNode(data);
        } else {
            currentNode.setrNode(data);
        }

    }

    /**
     * 通过value删除该树中的节点
     * 1.如果该节点是叶子节点，直接删
     * 2.如果有右孩子，则右孩子最小的节点上位并删除该节点
     * 3.如果没有右孩子，左孩子最大的节点上位并删除该节点
     *
     * @param value
     */
    public void delete(int value) {
        if (search(value) == null) {
            System.out.println("无该数据！");
            return;
        }
        //该值为1时，当前节点是父节点的左子树，为-1时为父节点的右子树
        int state = 0;
        TreeNode currentNode = this.node;
        TreeNode preNode = currentNode;
        while ((int) currentNode.getData() != value) {
            if ((int) currentNode.getData() > value) {
                preNode = currentNode;
                currentNode = currentNode.getlNode();
                state = 1;
            } else {
                preNode = currentNode;
                currentNode = currentNode.getrNode();
                state = -1;
            }
        }
        if (currentNode.getrNode() == null && currentNode.getlNode() == null) {
            //当前删除节点为该节点且没有一个子孙节点时
            if (currentNode == this.node) {
                this.node = null;
                return;
            }
            if (state == 1)
                preNode.setlNode(null);
            if (state == -1)
                preNode.setrNode(null);
            return;
        }
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        //删除节点为祖节点（起始节点）
        if (this.node == currentNode) {
            if (this.node.getrNode() != null) {
                leftNode = this.node.getlNode();
                rightNode = this.node.getrNode();
                if (rightNode.getlNode() == null) {
                    rightNode.setlNode(leftNode);
                    this.node = rightNode;
                } else {
                    currentNode = rightNode;
                    TreeNode nowNode = currentNode;
                    while (currentNode != null) {
                        nowNode = currentNode;
                        currentNode = currentNode.getlNode();
                    }
                    nowNode.setlNode(null);
                    currentNode.setlNode(leftNode);
                    currentNode.setrNode(rightNode);
                    this.node = currentNode;
                }

            } else {
                leftNode = this.node.getlNode();
                if (leftNode.getrNode() == null) {
                    this.node = leftNode;
                } else {
                    currentNode = leftNode.getrNode();
                    TreeNode nowNode = currentNode;
                    while (currentNode.getrNode() != null) {
                        nowNode = currentNode;
                        currentNode = currentNode.getrNode();
                    }
                    nowNode.setrNode(null);
                    currentNode.setlNode(leftNode);
                    this.node = currentNode;
                }

            }
            return;
        }
        if ((int) currentNode.getData() == value) {
            //要删除的当前节点有右节点，获取右边最小的节点
            if (currentNode.getrNode() != null) {
                //如果当前节点的左节点不为空，记录下来给新节点作为左节点
                if (currentNode.getlNode() != null)
                    leftNode = currentNode.getlNode();
                //获取目标节点的右节点
                currentNode = currentNode.getrNode();
                rightNode = currentNode;
                TreeNode nowNode = currentNode;
                //从目标节点的右节点中获取最小的（也就是右节点左子树最左的，有左子树的话）
                while (currentNode.getlNode() != null) {
                    nowNode = currentNode;
                    currentNode = currentNode.getlNode();
                }
                //删除目标右子树最小位置
                nowNode.setlNode(null);
                //当前节点是前继节点的右儿子时
                if (state == -1) {
                    //如果目标节点的右子树没有左孩子，则直接将目标节点换为其右子树
                    if (currentNode == rightNode) {
                        preNode.setrNode(currentNode);
                    } else {//如果目标节点的右子树有左孩子，左子树，右子树都要设置
                        preNode.setrNode(currentNode);
                        preNode.getrNode().setlNode(leftNode);
                        preNode.getrNode().setlNode(rightNode);
                    }
                }
                //当前节点是前继节点的左儿子时
                if (state == 1) {
                    if (rightNode == currentNode) {
                        currentNode.setlNode(leftNode);
                        preNode.setlNode(currentNode);
                    } else {
                        preNode.setlNode(currentNode);
                        preNode.getlNode().setlNode(leftNode);
                        preNode.getlNode().setlNode(rightNode);
                    }
                }
            } else {
                //要删除的当前节点没有右节点，将左边最大的节点放到该位置
                currentNode = currentNode.getlNode();
                TreeNode nowNode = currentNode;
                leftNode = currentNode;
                if (currentNode.getrNode() == null) {
                    if (state == 1) {
                        preNode.setlNode(leftNode);
                    }
                    if (state == -1)
                        preNode.setrNode(leftNode);
                } else {
                    while (currentNode.getrNode() != null) {
                        nowNode = currentNode;
                        currentNode = currentNode.getrNode();
                    }
                    //删除目标位置左子树最大值
                    nowNode.setrNode(null);
                    if (state == 1) {
                        preNode.setlNode(currentNode);
                        preNode.getlNode().setlNode(leftNode);
                    }
                    if (state == -1) {
                        preNode.setrNode(currentNode);
                        preNode.getrNode().setlNode(leftNode);
                    }
                }
            }
        }
    }

    /**
     * 通过node的data查询是否有该数据
     *
     * @param value
     * @return
     */
    public TreeNode search(int value) {
        if (this.node == null) {
            System.out.println("目标树为空！");
            return null;
        }
        TreeNode currentNode = this.node;
        while (true) {
            if ((int) currentNode.getData() == value) {
                return currentNode;
            } else if ((int) currentNode.getData() > value) {
                if (currentNode.getlNode() == null) {
                    System.out.println("无该数据！");
                    break;
                } else {
                    currentNode = currentNode.getlNode();
                }
            } else {
                if (currentNode.getrNode() == null) {
                    System.out.println("无该数据！");
                    break;
                } else {
                    currentNode = currentNode.getrNode();
                }
            }
        }
        return null;
    }

    public void midShow() {
        if (this.node != null) {
            midShow(node);
        }
    }

    /**
     * 中序遍历二叉排序树
     * 获取从小到大的有序数列
     *
     * @param node
     */
    public void midShow(TreeNode node) {
        if (node == null) {
            return;
        }
        midShow(node.getlNode());
        System.out.print(node.getData() + "  ");
        midShow(node.getrNode());
    }
}
