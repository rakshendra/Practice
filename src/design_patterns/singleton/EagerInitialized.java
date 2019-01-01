package src.design_patterns.singleton;

/**
 * Instance is created at the time of class loading
 * Drawbacks
 *  - Instance is created even though the client application may not be using it
 *  - No option for exception handling(Can use static block initialization for exception handling)
 */
public class EagerInitialized {
    private static EagerInitialized instance = new EagerInitialized();

    private EagerInitialized(){

    }

    public static EagerInitialized getInstance(){
        return instance;
    }

    public void printSomething(){
        System.out.println("Eager Initialization");
    }
}
