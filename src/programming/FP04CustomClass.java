package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        super();
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }

}


public class FP04CustomClass {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        // allMatch, noneMatch, anyMatch
        Predicate<Course> reviewScoreGt95Predicate =
                course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGt90Predicate =
                course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLt90Predicate =
                course -> course.getReviewScore() < 90;

        System.out.println(courses.stream().allMatch(reviewScoreGt95Predicate));
        System.out.println(courses.stream().noneMatch(reviewScoreGt95Predicate));
        System.out.println(courses.stream().noneMatch(reviewScoreLt90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreLt90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreGt90Predicate));


        Comparator<Course> comparingByNoOfStudentsAsc = Comparator.comparingInt(Course::getNoOfStudents);
        List<Course> sortedByNoOfStudents = courses.stream()
                .sorted(comparingByNoOfStudentsAsc)
                .toList();
        System.out.println(sortedByNoOfStudents);
        //[FullStack:14000:91, Spring Boot:18000:95, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96]

        Comparator<Course> comparingByNoOfStudentsDesc = Comparator.comparingInt(Course::getNoOfStudents).reversed();
        List<Course> sortedByNoOfStudentsDesc = courses.stream()
                .sorted(comparingByNoOfStudentsDesc)
                .toList();
        System.out.println(sortedByNoOfStudentsDesc);
        //[Microservices:25000:96, API:22000:97, AWS:21000:92, Azure:21000:99, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

        Comparator<Course> comparingByNoOfStudentsAndReviewScore =
                Comparator.comparingInt(Course::getNoOfStudents)
                        .thenComparingInt(Course::getReviewScore)
                        .reversed();
        List<Course> sorted = courses.stream()
                .sorted(comparingByNoOfStudentsAndReviewScore)
                .toList();
        System.out.println(sorted);
        //[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

        List<Course> sortedLimit5 = courses.stream()
                .sorted(comparingByNoOfStudentsAndReviewScore)
                .limit(5)
                .toList();
        System.out.println(sortedLimit5);
        //[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98]

        List<Course> sortedSkip3 = courses.stream()
                .sorted(comparingByNoOfStudentsAndReviewScore)
                .skip(3)
                .toList();
        System.out.println(sortedSkip3);
        //[AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

        List<Course> sortedSkip3Limit5 = courses.stream()
                .sorted(comparingByNoOfStudentsAndReviewScore)
                .skip(3)
                .limit(5)
                .toList();
        System.out.println(sortedSkip3Limit5);
        //[AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95]

        // takeWhile
        System.out.println(
                courses.stream()
                .takeWhile(course -> course.getReviewScore() >= 95)
                .toList()
        );
        //[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96]

        //dropWhile
        System.out.println(
                courses.stream()
                        .dropWhile(course -> course.getReviewScore() >= 95)
                        .toList()
        );
        //[FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]

        // max -> last of list returned after Comparator
        System.out.println(
            courses.stream()
                    .max(comparingByNoOfStudentsAndReviewScore)
        );
        //Optional[FullStack:14000:91]

        // min -> first of list returned after Comparator
        System.out.println(
                courses.stream()
                        .min(comparingByNoOfStudentsAndReviewScore)
                        .orElse(new Course("Kubernetes", "Cloud", 91, 20000))
        );
        //Optional[Microservices:25000:96]
        System.out.println(
                courses.stream()
                        .filter(reviewScoreLt90Predicate)
                        .min(comparingByNoOfStudentsAndReviewScore)
        );
        //Optional.empty
        System.out.println(
                courses.stream()
                        .filter(reviewScoreLt90Predicate)
                        .min(comparingByNoOfStudentsAndReviewScore)
                        .orElse(new Course("Kubernetes", "Cloud", 91, 20000))
        );
        //Kubernetes:20000:91

        // findFirst
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt95Predicate)
                        .findFirst()
        );
        //Optional[Spring:20000:98]

        // findAny
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt95Predicate)
                        .findAny()
        );
        //Optional[Spring:20000:98]

        // sum
        // sum all students across courses with reviews scores > 95
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .sum()
        );
        //88000

        // average
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .average()
        );
        //OptionalDouble[22000.0]

        // count
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt95Predicate)
                        .count()
        );
        //4

        // max
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGt95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .max()
        );
        //OptionalInt[25000]

        // groupingBy
        // group by category -> courses
        System.out.println(
            courses.stream()
                    .collect(Collectors.groupingBy(Course::getCategory))
        );
        // {Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91],
        // FullStack=[FullStack:14000:91],
        // Microservices=[API:22000:97, Microservices:25000:96],
        // Framework=[Spring:20000:98, Spring Boot:18000:95]}

        // group by category -> count courses
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );
        //{Cloud=4, FullStack=1, Microservices=2, Framework=2}

        // group by category -> the course with the highest review score
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(
                                Course::getCategory,
                                Collectors.maxBy(Comparator.comparingInt(Course::getReviewScore))))
        );
        //{Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}

        // group by category -> the course names list
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(
                                Course::getCategory,
                                Collectors.mapping(Course::getName, Collectors.toList())))
        );
        //{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}

    }
}
