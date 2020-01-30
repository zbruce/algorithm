package com.me.algorithm.search;

/**
 * 二分查找/折半查找
 */
public class BinarySearch {

    /**
     * 递归
     * @param array
     * @param start 查找范围内的最小索引
     * @param end   查找范围内的最大索引
     * @param target
     * @return
     */
    public static int binarySearchByRecursive(int[] array, int start, int end, int target){
        if(array == null || array.length == 0 || start > end){
            return -1;
        }

        int middle = (start + end) / 2;
        if(array[middle] == target){
            return middle;
        }else if(target < array[middle]){
            return binarySearchByRecursive(array, start, middle - 1, target);
        }else{
            return binarySearchByRecursive(array, middle + 1, end, target);
        }
    }

    /**
     * 循环
     * @param array
     * @param start
     * @param end
     * @param target
     * @return
     */
    public static int binarySearchByLoop(int[] array, int start, int end, int target){
        if(array == null || array.length == 0 || start > end){
            return -1;
        }

        while(start <= end){
            int middle = (start + end) / 2;
            if(array[middle] == target){
                return middle;
            }else if(target < array[middle]){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4};
        System.out.println(binarySearchByLoop(a, 0, a.length - 1, 1));
    }

}
