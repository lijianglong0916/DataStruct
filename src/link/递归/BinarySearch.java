package link.递归;/*
 *@author:
 *@time
 */

class BinarySearch {
    private int[] array;
    public BinarySearch(int[] array){
        this.array=array;
    }

    public int search(int data,int lowBound,int upBound){
        int currentKey;
        if(upBound>array.length-1||lowBound<0){
            System.out.println("输入的界限不存在!");
            return -1;
        }
        if(upBound<lowBound){
            System.out.println("不存在该数据！");
            return -1;
        }
        currentKey = (upBound+lowBound)/2;
        if(array[currentKey]==data){
            return currentKey;
        } else if (array[currentKey] < data) {
            lowBound = currentKey + 1;
            return search(data, lowBound, upBound);
        } else if (array[currentKey] > data) {
            upBound = currentKey - 1;
            return search(data, lowBound, upBound);
        }
        return -1;
    }
}
