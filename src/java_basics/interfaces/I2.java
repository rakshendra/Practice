package src.java_basics.interfaces;

public interface I2 {
    void method1();
    default void method2(){
        System.out.println("Metod2 in interface 2");
    }
}
