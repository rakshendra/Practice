package src.java_basics.binding;

public class Main {
    public static void main(String[] args){
        AbstractExample ex = new ExampleC();
        ex.printExample();

        ExampleA a = (ExampleA) ex;
        a.printExample();

        AbstractExample ab = (ExampleB)ex;
        ab.printExample();

        ExampleB b = (ExampleB)a;
        b.printExample();

        AbstractExample ex2 = new ExampleA();
        ExampleC c = (ExampleC)ex2;
        c.printExample();
    }
}
