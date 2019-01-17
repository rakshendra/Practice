package src.java_basics.interfaces;

public interface I1 {
    void method1();
    default void method2(){
        System.out.println("Method2 in interface 1");
    }
}
