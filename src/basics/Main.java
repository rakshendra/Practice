package src.basics;

public class Main {
    public static void main(String[] args){
        SubExample subExample = new SubExample();
        subExample.printStr();

        Example example = subExample;
        example.printStr();

        System.out.println(subExample.str);
        System.out.println(example.str);
    }
}
