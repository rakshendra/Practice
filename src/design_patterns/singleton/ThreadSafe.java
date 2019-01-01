package src.design_patterns.singleton;

/**
 * We can synchronize our static helper method to prohibit concurrent access
 * But above implementation is time consuming if instance is already created, so instead we can keep a synchronized block
 * inside our method to be efficient
 */
public class ThreadSafe {

    private static ThreadSafe instance;

    private ThreadSafe(){

    }

    public static synchronized ThreadSafe getInstance(){
        if(instance==null){
            instance = new ThreadSafe();
        }
        return instance;
    }

    public static ThreadSafe getInstanceEfficient(){
        if(instance==null){
            synchronized (ThreadSafe.class){
                if(instance==null){
                    instance = new ThreadSafe();
                }
            }
        }
        return instance;
    }

}
