package src.design_patterns.singleton;

/**
 * Here when the singleton class is loaded, inner class is not loaded into the memory.
 * Only when someone calls the getInstance method, inner class gets loaded and creates the outer class instance
 */
public class BillPugh {
    private BillPugh(){}

    private static class SingletonHelper{
        private static final BillPugh INSTANCE = new BillPugh();
    }

    public static BillPugh getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
