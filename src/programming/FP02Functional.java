package programming;

import java.util.List;

public class FP02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        int sum = addFunctional(numbers);

        System.out.println(sum);

    }

    private static int addFunctional(List<Integer> nums) {
        return nums.stream()
                .reduce(0, Integer::sum);
    }
}
