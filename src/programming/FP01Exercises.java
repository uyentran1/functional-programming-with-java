package programming;

import java.util.List;

public class FP01Exercises {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");

//        printCoursesWithSpringWord(courses);
//        printCoursesWithAtLeastFourLetters(courses);
        printNumOfChars(courses);
    }

    private static void printCoursesWithSpringWord(List<String> courses) {
        courses.stream()
                .filter(c -> c.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printCoursesWithAtLeastFourLetters(List<String> courses) {
        courses.stream()
                .filter(c -> c.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printNumOfChars(List<String> strings) {
        strings.stream()
                .map(s -> s + " " + s.length())
                .forEach(System.out::println);
    }
}
