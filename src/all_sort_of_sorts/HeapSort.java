package src.all_sort_of_sorts;

import java.util.Arrays;

/**
 * Worst case Time complexity:O(nlogn)
 * Best Case time Complexity:O(nlogn)
 * Avg Case Time Complexity:O(nlogn)
 * Auxiliary Space:O(1)
 * Stable: No
 * In Place: Yes
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 7, 9, 6, 5, 10, 4, 11, 8};
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int heapSize = arr.length;

        for (int i = (heapSize / 2) - 1; i >= 0; i--) {
            maxHeapify(arr, i, heapSize);
        }
        for (int i = heapSize - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHeapify(arr, 0, i);
        }
    }

    private static void maxHeapify(int[] arr, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < heapSize && arr[left] > arr[max]) {
            max = left;
        }
        if (right < heapSize && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, max, heapSize);
        }
    }
}
