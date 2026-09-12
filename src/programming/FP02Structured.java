package programming;

import java.util.List;

public class FP02Structured {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        int sum = add(numbers);

        System.out.println(sum);

    }

    private static int add(List<Integer> nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
