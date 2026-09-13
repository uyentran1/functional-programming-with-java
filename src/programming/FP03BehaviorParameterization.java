package programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03BehaviorParameterization {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        // Instead of this:
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        numbers.stream()
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);


        // We can do this:
        filterAndPrint(numbers, x -> x % 2 == 0);
        filterAndPrint(numbers, x -> x % 2 != 0);


        // Instead of this:
        List<Integer> squares1 = numbers.stream()
                .map(x -> x * x)
                .toList();

        // We can do this:
        List<Integer> squares2 = transformAndCollect(numbers, x -> x * x);
        List<Integer> cubes = transformAndCollect(numbers, x -> x * x * x);

        System.out.println(squares1);
        System.out.println(squares2);
        System.out.println(cubes);

    }

    private static List<Integer> transformAndCollect(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .toList();
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

}
