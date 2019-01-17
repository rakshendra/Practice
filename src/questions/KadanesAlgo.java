package src.questions;

public class KadanesAlgo {

    public static int maxSumSubArray(int[] arr){
        int maxHere = arr[0];
        int maxTillNow = arr[0];

        for(int i=1; i<arr.length;i++){
            maxHere = Math.max(maxHere+arr[i],arr[i]);
            if(maxHere > maxTillNow){
                maxTillNow = maxHere;
            }
        }
        return maxTillNow;
    }
}
