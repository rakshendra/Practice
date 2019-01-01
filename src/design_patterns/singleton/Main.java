package src.design_patterns.singleton;

public class Main {
    public static void main(String[] args){
        EagerInitialized eagerInitialized = EagerInitialized.getInstance();
        eagerInitialized.printSomething();

        LazyInitialized lazyInitialized = LazyInitialized.getInstance();
        lazyInitialized.printSomething();
    }
}
