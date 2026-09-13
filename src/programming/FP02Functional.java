package programming;

import java.util.Comparator;
import java.util.List;

public class FP02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        int sum = addFunctional(numbers);
        System.out.println("Sum: " + sum);

        int sumOfSquares = sumOfSquares(numbers);
        System.out.println("Sum of squares: " + sumOfSquares);

        int sumOfCubes = sumOfCubes(numbers);
        System.out.println("Sum of cubes: " + sumOfCubes);

        int sumOfOddNums = sumOfOddNums(numbers);
        System.out.println("Sum of odd nums: " + sumOfOddNums);

//        courses.stream()
//                .distinct()
//                .sorted(Comparator.reverseOrder())
//                .forEach(System.out::println);

        courses.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }

    private static int addFunctional(List<Integer> nums) {
        return nums.stream()
                .reduce(0, Integer::sum);
    }

    private static int sumOfSquares(List<Integer> nums) {
        return nums.stream()
                .map(num -> num * num)
                .reduce(0, Integer::sum);
    }

    private static int sumOfCubes(List<Integer> nums) {
        return nums.stream()
                .map(num -> num * num * num)
                .reduce(0, Integer::sum);
    }

    private static int sumOfOddNums(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 != 0)
                .reduce(0, Integer::sum);
    }

}
