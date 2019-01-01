package src.design_patterns.builder;

public class Main {
    public static void main(String[] args){
        NutritionalFacts nutritionalFacts = new NutritionalFacts.Builder(250, 2).calories(500)
                .fat(500).build();

        Example example = new Example.Builder().setA(1).setB(2).build();
    }
}
