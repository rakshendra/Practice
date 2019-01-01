package src.design_patterns.singleton;

public enum EnumSingleton {
    INSTANCE;

    public static void printSomething(){
        System.out.println("Enum Singleton");
    }
}
