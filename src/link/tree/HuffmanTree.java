package link.tree;/*
 *@author:
 *@time
 */

import java.util.ArrayList;
import java.util.List;

public class HuffmanTree {

    public TreeNode createHuffmanTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空或不存在，无法创建");
            return null;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        for (int i = 0; i < arr.length; i++) {
            TreeNode node = new TreeNode(arr[i]);
            list.add(node);
        }
        TreeNode aimNode = null;
        while(list.size()>0){
            TreeNode firsMin=getMinIndex(list);
            list.remove(firsMin);
            int parentData= (int) firsMin.getData();
            if(list.size()==0){
                break;
            }
            TreeNode secondMin=getMinIndex(list);
            list.remove(secondMin);
            parentData+=(int)secondMin.getData();
            TreeNode parentNode=new TreeNode(parentData);
            list.add(parentNode);
            aimNode=parentNode;
            aimNode.setlNode(firsMin);
            aimNode.setrNode(secondMin);
        }
        return aimNode;
    }

    public TreeNode getMinIndex(List<TreeNode> nodes) {
        int max = Integer.MAX_VALUE;
        TreeNode minNode=new TreeNode(max);
        for (TreeNode node : nodes) {
            if ((int)node.getData() <(int) minNode.getData()){
                minNode=node;
            }
        }
        return minNode;
    }
}
