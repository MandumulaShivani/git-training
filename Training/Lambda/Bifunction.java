package Lambda;

import java.util.function.BiFunction;


public class Bifunction {
    public static void main(String args[]) {
        BiFunction<Integer, String, String>a1=(a, b)->"Hello";
        System.out.println(a1.apply(20, "Shivani"));

    }
}
