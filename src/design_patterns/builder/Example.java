package src.design_patterns.builder;

/**
 * This example is to showcase how to enforce order of setting parameters
 */
public class Example {
    private int a;
    private int b;

    private Example(Builder2 builder){
        this.a = builder.a;
        this.b = builder.b;
    }

    public static class Builder{
        private int a;

        public Builder2 setA(int a) {
            this.a = a;
            return new Builder2(a);
        }

        /*public Example build(){
            return new Example(this);
        }*/
    }

    public static class Builder2{
        private int a;
        private int b;

        public Builder2(int a){
            this.a = a;
        }

        public Builder2 setB(int b) {
            this.b = b;
            return this;
        }

        public Example build(){
            return new Example(this);
        }
    }

    /*public interface PartialBuilder{
        PartialBuilder setB(int b);
    }

    public interface FullBuilder extends PartialBuilder{
        FullBuilder setA(int a);
    }

    public static class Builder implements FullBuilder{
        private int a;
        private int b;

        @Override
        public Builder setB(int b) {
            this.b = b;
            return this;
        }

        @Override
        public FullBuilder setA(int a) {
            this.a = a;
            return this;
        }

        public Example build(){
            return new Example(this);
        }
    }*/
}
