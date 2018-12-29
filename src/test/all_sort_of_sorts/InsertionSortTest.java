package src.test.all_sort_of_sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.all_sort_of_sorts.InsertionSort;

class InsertionSortTest {

    @Test
    void insertionSort() {
        int[] arr1 = {1};
        InsertionSort.insertionSort(arr1);
        Assertions.assertArrayEquals(arr1, new int[] {1});

        int[] arr2 = {1,2,3,4};
        InsertionSort.insertionSort(arr2);
        Assertions.assertArrayEquals(arr2, new int[] {1,2,3,4});

        int[] arr3 = {2,1,2,3};
        InsertionSort.insertionSort(arr3);
        Assertions.assertArrayEquals(arr3, new int[] {1,2,2,3});
    }
}