package nothis;

interface MyFunction {
    int apply(String s);
}

public class Example {
    public static void main(String[] args) {
        MyFunction strlen = new MyFunction() {
            @Override
            public int apply(String s) {
                if("".equals(s)){
                    return 0;
                }
                else return  1 + this.apply( s.substring(1));
            }
        };
        System.out.println("length of hello is " + String.valueOf(strlen.apply("hello")));
    }
}
