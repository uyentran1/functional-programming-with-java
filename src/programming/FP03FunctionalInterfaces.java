package programming;

import java.util.List;
import java.util.function.BinaryOperator;

public class FP03FunctionalInterfaces {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        BinaryOperator<Integer> my_sum = new BinaryOperator<Integer>() {
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        int sum = numbers.stream()
                .reduce(0, my_sum);

        System.out.println(sum);
    }
}
