package src.questions;

public class BinarySearchRotatedSorted {

    public static int searchElement(int[] arr, int key){

        int pivot = findPivot(arr, 0, arr.length-1);
        if(pivot==-1){
            return binarySearchC(arr, 0, arr.length-1, key);
        }
        if(arr[pivot]==key){
            return pivot;
        }
        if(arr[0] <= key){
            return binarySearchC(arr, 0, pivot-1, key);
        }
        return binarySearchC(arr, pivot+1, arr.length-1, key);
    }

    private static int binarySearchC(int[] arr, int l, int r, int key) {
        if(r < l){
            return -1;
        }
        int mid = (l+r)/2;
        if(arr[mid]==key){
            return mid;
        }else if(key < arr[mid]){
            return binarySearchC(arr,l,mid-1, key);
        }else{
            return binarySearchC(arr, mid+1, r, key);
        }
    }

    private static int findPivot(int[] arr, int l, int r) {
        if(r < l){
            return -1;
        }
        if(l==r){
            return l;
        }
        int mid = (l+r)/2;
        if(mid < r && arr[mid] > arr[mid+1]){
            return mid;
        }
        if(mid > l && arr[mid] < arr[mid-1]){
            return mid-1;
        }
        if(arr[l] > arr[mid]){
            return findPivot(arr, l,mid-1);
        }
        return findPivot(arr, mid+1, r);
    }

}
