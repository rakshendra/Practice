package src.all_sort_of_sorts;

import java.util.Arrays;

/**
 * Worst Case time complexity: O(n2)
 * Best Case time complexity: O(nlogn)
 * Avg Case time complexity: O(nlogn)
 * Auxiliary Space:O(1)
 * In Place: YES
 * Stable: NO
 */
public class QuickSort {

    public static void main(String[] args){
        int[] arr = {3,1,2,7,9,6,5,10,4,11};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r){
        if(l<r){
            int pivot = partition(arr, l, r);
            quickSort(arr, l, pivot-1);
            quickSort(arr, pivot+1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int pivotElement = arr[r];
        int i=l-1;
        for(int j=l;j<=r-1;j++){
            if(arr[j] < pivotElement){
                i++;
                swap(arr, i , j);
            }
        }
        swap(arr, i+1, r);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
