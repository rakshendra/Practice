package src.questions;

public class ReverseWords {
    public static void main(String[] args){
        String str ="She be the one, she be the girl.";
        String res = reverseOrderOfWords(str.toCharArray());
        System.out.println(str);
        System.out.println(res);
    }

    private static String reverseOrderOfWords(char[] sentence) {
        int n = sentence.length;
        reverseArray(sentence,0, n-1);
        int k;
        for(int i=0; i <n; ){
            k=i;
            while(k < n && sentence[k] != ' '){
                k++;
            }
            reverseArray(sentence, i, k-1);
            i=k+1;
        }
        return new String(sentence);
    }

    private static void reverseArray(char[] arr, int i, int j){
        while (i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
