package tree;/*
 *@author:
 *@time
 */

/**
 * 完全二叉树，简单的规律
 * 1.第i节点的左子节点为i*2+1;右子节点为i*2+2
 * 2.第i个节点的父节点为(i-1)/2
 */

public class FullBinaryTree {
    int [] treeArray;
    public FullBinaryTree(int[] array){
        treeArray=array;
    }

    public void beforeTra(int index){
        if(treeArray==null||treeArray.length==0)
            return;
        System.out.print(treeArray[index]+" ");
        if((index*2+1)<treeArray.length){
            //注意 index不能赋值给自己，否则本次递归会异常
            int bl=index*2+1;
            beforeTra(bl);
        }
        if((index*2+2)<treeArray.length){
            int al=index*2+2;
            beforeTra(al);
        }
    }
    public void midStr(int index){
        if(treeArray==null||treeArray.length==0)
            return;
        if(index*2+1<treeArray.length){
            int bl=index*2+1;
            beforeTra(bl);
        }
        System.out.print(treeArray[index]+" ");
        if((index*2+2)<treeArray.length){
            int al=index*2+2;
            beforeTra(al);
        }
    }
    public void maxHeap(int index){
        if(treeArray==null||treeArray.length==0)
            return;
        if(index*2+1<treeArray.length){
            if(treeArray[index]<treeArray[index*2+1]){
                swap(treeArray,index,index*2+1);
                maxHeap(0);
            }
            if(index*2+2<treeArray.length&&treeArray[index]<treeArray[index*2+2]){
                swap(treeArray, index,index*2+2);
                maxHeap(0);
            }
            maxHeap(index*2+1);
        }
        if(index*2+2<treeArray.length){
            if(treeArray[index]<treeArray[index*2+1]){
                swap(treeArray,index,index*2+1);
                maxHeap(0);
            }
            if(treeArray[index]<treeArray[index*2+2]){
                swap(treeArray, index,index*2+2);
                maxHeap(0);
            }
            maxHeap(index*2+2);
        }
    }
    //堆排序
    public void heapSort(){
        int[] temp=new int[treeArray.length];
        for(int i=0,j=(treeArray.length-1);i<treeArray.length;i++,j--){
            maxHeap(0);
            temp[i]=treeArray[0];
            treeArray[0]=treeArray[j];
            treeArray[j]=0;

        }
        for(int i=0;i<treeArray.length;i++){
            treeArray[i]=temp[i];
        }

    }

    public void swap(int[]arr,int left,int right){
        arr[left]=arr[left]^arr[right];
        arr[right]=arr[left]^arr[right];
        arr[left]=arr[left]^arr[right];
    }
}
