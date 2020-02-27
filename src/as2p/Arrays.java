package src.as2p;

public class Arrays {
    public static void main(String[] args){
        int[] arr = {12,3,4,1,23,45,6,10,13,5};

    }

    private static int searchNormal(int[] arr, int num){
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==num){
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int num){

        return 0;
    }

    private static void removeElement(int[] arr, int num){

    }

    private static void removeElementAtIndex(int[] arr, int index){

    }
}
