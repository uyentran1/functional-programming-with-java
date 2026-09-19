package programming;

import java.util.stream.LongStream;

public class FP05Parallelism {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        // 0, 1000000000
//        System.out.println(
//            LongStream.range(0, 1000000000).sum() // 499999999500000000
//        );

        System.out.println(
                LongStream.range(0, 1000000000).parallel().sum() // 499999999500000000
        );

        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
