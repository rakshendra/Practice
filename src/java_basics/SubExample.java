package src.java_basics;

public class SubExample extends Example{
    public String str = "SubExample";

    public void printStr(){
        System.out.println(str);
        System.out.println(super.str);
    }
}
