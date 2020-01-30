package com.me.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    /**
     * 递归1
     * @param array
     * @param start
     * @param end
     */
    public static void quickSortByRecursive1(int[] array, int start, int end){
        if(array != null && array.length > 1 && start < end){
            int location = getPivotLocation(array, start, end);
            quickSortByRecursive1(array, start, location - 1);
            quickSortByRecursive1(array, location + 1, end);
        }
    }

    private static int getPivotLocation(int[] array, int start, int end){
        int pivot = array[start];
        while(start < end){
            while(start < end && pivot <= array[end]){
                end--;
            }
            array[start] = array[end];

            while(start < end && array[start] <= pivot){
                start++;
            }
            array[end] = array[start];
        }
        array[start] = pivot;
        return start;
    }


    /**
     * 递归2
     * @param array
     * @param start
     * @param end
     */
    public static void quickSortByRecursive2(int[] array, int start, int end){
        if(array != null && array.length > 1 && start < end){
            int left = start;
            int right = end;
            int pivot = array[start];
            while(left < right){
                while(left < right && pivot <= array[right]){
                    right--;
                }
                while(left < right && array[left] <= pivot){
                    left++;
                }
                if(left < right){
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                }
            }
            array[start] = array[left];
            array[left] = pivot;
            quickSortByRecursive2(array, start, left - 1);
            quickSortByRecursive2(array, left + 1, end);
        }
    }

    public static void main(String[] args){
        int[] array = {5,4,3,2,1};
        quickSortByRecursive2(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
