package programming;

import java.util.stream.IntStream;

public class FP05Threads {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(
                            Thread.currentThread().threadId() + ":" + i
                    );
                }
            }
        };

        Runnable runnable_functional = () -> IntStream.range(0, 10)
                .forEach(i -> System.out.println(Thread.currentThread().threadId() + ":" + i));

        Thread thread = new Thread(runnable_functional);
        thread.start();

        Thread thread1 = new Thread(runnable_functional);
        thread1.start();

        Thread thread2 = new Thread(runnable_functional);
        thread2.start();

    }
}
