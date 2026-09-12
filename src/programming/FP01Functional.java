package programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> integers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
//        printAllNumbersInListFunctional(integers);
//        printEvenNumbersInListFunctional(integers);
//        printOddNumbersInListFunctional(integers);
        printSquares(integers);
    }

    private static void printAllNumbersInListFunctional(List<Integer> integers) {
        integers.stream()
                .forEach(System.out::println); // Method reference
    }

    private static void printEvenNumbersInListFunctional(List<Integer> integers) {
        integers.stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }

    private static void printOddNumbersInListFunctional(List<Integer> integers) {
        integers.stream()
                .filter(i -> i % 2 == 1)
                .forEach(System.out::println);
    }

    private static void printSquares(List<Integer> integers) {
        integers.stream()
                .map(i -> i * i)
                .forEach(System.out::println);
    }
}
