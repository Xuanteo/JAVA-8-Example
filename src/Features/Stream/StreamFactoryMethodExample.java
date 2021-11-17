package Features.Stream;

import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamFactoryMethodExample {
    // Tạo 1 toán tử 1 ngôi.
    static UnaryOperator<Integer> add = x -> x + 5;

    public static void main(String[] args) {
        // Sử dụng iterate để lặp lại: Stream iterate sẽ chạy vòng lặp tuần tự vô hạn. Sử dụng limit để hạn chế dữ liệu.
        Stream<Integer> s1 = Stream.iterate(0, add).limit(10);
        // In ra kết quả lặp
        s1.forEach(System.out::println);
        // Sử dụng Generate truyền 1 supplier vào để tự động generate ra element. In ra:
        Stream<Double> s2 = Stream.generate(Math::random).limit(10);
        s2.forEach(System.out::println);
        // Sử dụng Generate với số nguyên
        Stream<Integer> s3 = Stream.generate(new Random()::nextInt).limit(10);
        s3.forEach(System.out::println);
        // Sử dụng Stream of trả về kết quả  trong luồng 1 cách tuần tự.
        Stream<String> s4 = Stream.of("One", "Two", "Three","Four");
        s4.forEach(System.out::println);
    }
}
