package programming;

import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfaces2 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        // Supplier: no input, returns something
        Supplier<Integer> getRandomInt = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
        System.out.println(getRandomInt.get());

        // UnaryOperator: 1 arg, returns resof same type
        UnaryOperator<Integer> getTriple = x -> 3 * x;
        System.out.println(getTriple.apply(5));

        // BiPredicate: 2 args, returns boolean
        BiPredicate<Integer, String> biPredicate = (num, str) -> {
            return num < 10 && str.length() > 5;
        };
        System.out.println(biPredicate.test(15, "hello world"));

        // BiFunction: 2 args, returns something
        BiFunction<Integer, String, String> biFunction = (num, str) -> {
            return String.format("num: %s, string: %s", num, str);
        };
        System.out.println(biFunction.apply(15, "hello world"));

        // BiConsumer: 2 args, returns nothing
        BiConsumer<Integer, String> biConsumer = (num, str) -> {
            System.out.println(num);
            System.out.println(str);
        };
        biConsumer.accept(1, "hello world");

        // Use primitive operations when applying to primitive types
        // IntBinaryOperator
        // IntConsumer
        // IntFunction
        // IntPredicate
        // IntSupplier
        // IntToDoubleFunction
        // IntToLongFunction
        // IntUnaryOperator

        // Long, Double, Int

    }
}
