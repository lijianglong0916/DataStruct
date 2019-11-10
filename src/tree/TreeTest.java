package tree;/*
 *@author:
 *@time
 */

import java.util.Arrays;

public class TreeTest {
    public static void main(String[] args) {
//        simpleTree();
//        fullBinaryTree();
//        huffmanTreeTest();
        binarySortTree();
    }

    public static void binarySortTree(){
        TreeNode treeNode2 = new TreeNode(12);
        TreeNode treeNode3 = new TreeNode(13);
        TreeNode treeNode4 = new TreeNode(14);
        TreeNode treeNode5 = new TreeNode(15);
        TreeNode treeNode6 = new TreeNode(16);
        TreeNode treeNode7 = new TreeNode(17);
        TreeNode treeNode8 = new TreeNode(18);
        TreeNode treeNode9 = new TreeNode(19);
        BinarySortTree sortTree=new BinarySortTree();
        sortTree.add(treeNode6);
        sortTree.add(treeNode3);
        sortTree.add(treeNode2);
        sortTree.add(treeNode4);
        sortTree.add(treeNode5);
        sortTree.add(treeNode7);
//        sortTree.add(treeNode8);
//        sortTree.add(treeNode9);
        sortTree.midShow();
//        TreeNode search = sortTree.search(10);
//        sortTree.delete(19);
//        sortTree.midShow();
        System.out.println();
        sortTree.isBalanceBinaryTree(sortTree.search(16));
        System.out.println(sortTree.getNoBalanceNode());
        sortTree.changeToBalanceBinaryTree();
        sortTree.midShow();
        System.out.println(sortTree.getNoBalanceNode());
    }
    public static void huffmanTreeTest() {
        int[] arr = {1, 2, 3, 4, 5, 6, 1, 2, 7, 8, 9};
        HuffmanTree tree = new HuffmanTree();
        TreeNode huffmanTree = tree.createHuffmanTree(arr);
        System.out.println(huffmanTree.getData());
        System.out.println(huffmanTree.getlNode().getData());
        System.out.println(huffmanTree.getrNode().getData());
    }

    public static void fullBinaryTree() {
        int[] arr = {1, 2, 3, 4, 5, 6, 1, 2, 7, 8, 9};
        FullBinaryTree binaryTree = new FullBinaryTree(arr);
        binaryTree.beforeTra(0);
        binaryTree.maxHeap(0);
        System.out.println();
        binaryTree.beforeTra(0);
        System.out.println();
        binaryTree.heapSort();
        System.out.println(Arrays.toString(arr));
    }

    public static void simpleTree() {
        Tree tree = new Tree(new TreeNode(11));
        TreeNode treeNode2 = new TreeNode(12);
        TreeNode treeNode3 = new TreeNode(13);
        TreeNode treeNode4 = new TreeNode(14);
        TreeNode treeNode5 = new TreeNode(15);
        TreeNode treeNode6 = new TreeNode(16);
        TreeNode treeNode7 = new TreeNode(17);
        TreeNode treeNode8 = new TreeNode(18);
        TreeNode treeNode9 = new TreeNode(19);
        tree.getTopTree().setlNode(treeNode2);
        tree.getTopTree().setrNode(treeNode3);
        treeNode2.setlNode(treeNode4);
        treeNode2.setrNode(treeNode5);
        treeNode3.setlNode(treeNode6);
        treeNode3.setrNode(treeNode7);
        treeNode4.setlNode(treeNode8);
        treeNode4.setrNode(treeNode9);
        tree.getTopTree().frontTra();
        System.out.println();
        TreeNode node = tree.getTopTree().search(12);
        System.out.println(node);
        tree.getTopTree().delete(12);
        tree.getTopTree().frontTra();
        System.out.println();
    }
}
