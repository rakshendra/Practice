package src.questions;

public class SecondLargest {
    public static int secondLargest(int[] arr){
        if(arr.length < 2){
            return Integer.MIN_VALUE;
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length;i++){
            if(arr[i] > first){
                second = first;
                first = arr[i];
            }else if(arr[i] < first && arr[i] > second){
                second = arr[i];
            }
        }
        return second;
    }
}
