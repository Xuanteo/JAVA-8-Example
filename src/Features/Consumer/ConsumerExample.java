package Features.Consumer;

import java.util.Locale;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> consumer1 = (s) -> {
            System.out.println(s.toUpperCase());
        };
        consumer1.accept("java 8");
        Consumer<String> consumer2 = s -> System.out.println(s.toLowerCase());
        consumer2.accept("Java 8");

        consumer1.andThen(consumer2).accept("Java 8");
    }
}

