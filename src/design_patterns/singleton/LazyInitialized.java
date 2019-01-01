package src.design_patterns.singleton;

/**
 * In this case, instance is created only when required
 * Works well in single threaded environment.
 * May cause issues in multi-threaded environment when more than 1 thread enter 'if' condition simultaneously,
 * all will get different instances of this class
 */
public class LazyInitialized {
    private static LazyInitialized instance;

    private LazyInitialized(){

    }

    public static LazyInitialized getInstance(){
        if(instance==null){
            instance = new LazyInitialized();
        }
        return instance;
    }

    public void printSomething(){
        System.out.println("Lazy Initialization");
    }
}
