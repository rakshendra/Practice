package src.test.all_sort_of_sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.all_sort_of_sorts.QuickSort;

class QuickSortTest {

    @Test
    void quickSort() {
        int[] arr1 = {1};
        QuickSort.quickSort(arr1, 0,0);
        Assertions.assertArrayEquals(arr1, new int[] {1});

        int[] arr2 = {1,2,3,4};
        QuickSort.quickSort(arr2, 0,3);
        Assertions.assertArrayEquals(arr2, new int[] {1,2,3,4});

        int[] arr3 = {2,1,2,3};
        QuickSort.quickSort(arr3, 0,3);
        Assertions.assertArrayEquals(arr3, new int[] {1,2,2,3});
    }
}