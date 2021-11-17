package Features.Stream;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamFactoryMethodExample1 {
    public static void main(String[] args) {
        // Sử dụng tính tổng của dãy trong luồng IntStream.
        int sum = IntStream.rangeClosed(1, 50).sum();
        System.out.println("Total is: " + sum);
        // Sử dụng tuỳ chọn để kiểm tra số lớn nhất trong luồng IntStream. và lấy ra kết quả từ tuỳ chọn.
        OptionalInt max = IntStream.rangeClosed(1, 50).max();
        System.out.println("Number Value max is: " + max.getAsInt());
        // Sử dung Min.
        OptionalLong min = LongStream.rangeClosed(1, 50).min();
        System.out.println("Number Value min is: " + min.getAsLong());
        // Sử dung Average.
        OptionalDouble avg = LongStream.rangeClosed(1,50).average();
        System.out.println("Number Value Avg is: " + avg.getAsDouble());
    }
}
