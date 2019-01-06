package src.questions;

/**
 * for 123
 *  1 2 3
 *  12 3
 *  1 23
 */
public class CombinationsOfDigitsInOrder {
    public static void findOrderedCombinations(String num){
        findOCRec(num, "",0);
    }

    private static void findOCRec(String num, String out, int index){
        if(index==num.length()){
            System.out.println(out);
            return;
        }
        findOCRec(num, out+num.charAt(index)+" ",index+1);
        if(index+1 < num.length())
            findOCRec(num,out+num.charAt(index),index+1);
    }
}
