package src.java_basics.interfaces;

public class C1 implements I1,I2,I3{

    @Override
    public void method1() {
        System.out.println("Method1 implementation in class");
    }

    @Override
    public void method2() {
        I1.super.method2();
        System.out.println("Method2 in class");
    }

    @Override
    public void method3() {
        I3.super.method3();
    }
}
