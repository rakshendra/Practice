package src.all_sort_of_sorts;

import java.util.Arrays;

/**
 * Worst case time complexity: O(n2)
 * Best case time complexity: O(n)
 * Avg case time complexity: O(n2)
 * Auxiliary Space: O(1)
 * Stable: YES
 * Sorting in Place: YES
 */
public class InsertionSort {
    public static void main(String[] args){
        int[] arr = {3,1,2,7,9,6,5,10,4,11,8};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr){
        for(int i=1; i<arr.length;i++){
            int num = arr[i];
            int j=i-1;
            while (j>=0 && num < arr[j]) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=num;
        }
    }
}
