package src.all_sort_of_sorts;

import java.util.Arrays;

/**
 * Worst Case Time Complexity - O(nlogn)
 * Avg Case Time Complexity - O(nlogn)
 * Best Case Time Complexity - O(nlogn)
 * Auxiliary Space - O(n)
 * In Place - NO
 * Stable - Yes
 */
public class MergeSort {

    public static void main(String[] args){
        int[] arr = {3,1,2,7,9,6,5,10,4,11};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int l, int r){
         if(l<r){
             int m = (l+r)/2;
             mergeSort(arr, l,m);
             mergeSort(arr,m+1,r);
             merge(arr,l,m,r);
         }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int lowerHalfLength = m-l+1;
        int upperHalfLength = r-m;
        int[] lowerHalf = new int[lowerHalfLength];
        int[] upperHalf = new int[upperHalfLength];
        for(int i=0; i<lowerHalfLength;i++){
            lowerHalf[i] = arr[l+i];
        }
        for(int i=0; i<upperHalfLength;i++){
            upperHalf[i] = arr[m+i+1];
        }

        int i=0,j=0;
        int k=l;
        while (i<lowerHalfLength && j < upperHalfLength){
            if(lowerHalf[i] < upperHalf[j]){
                arr[k]=lowerHalf[i++];
            }else{
                arr[k]=upperHalf[j++];
            }
            k++;
        }

        while(i<lowerHalfLength){
            arr[k++]=lowerHalf[i++];
        }
        while(j<upperHalfLength){
            arr[k++]=upperHalf[j++];
        }
    }
}


