package Features.Stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamFactoryMethodExample {
    public static void main(String[] args) {
        // so sánh sự khác nhau giữa Rangeclosed và range:
        // Range close sễ lấy cả số 6 là vị trí đóng luồng cuối cùng.
        IntStream intStream = IntStream.rangeClosed(1, 6);
        intStream.forEach(System.out::println);
        System.out.println("Xem kết quả để so sánh sự khác biệt.Có sự khác nhau về phạm vi");
        // Range sẽ bỏ vị trí đóng luồng cuối cùng chỉ lấy từ 1->5
        IntStream intStream1 = IntStream.range(1, 6);
        intStream1.forEach(System.out::println);
        System.out.println("-----------------");
        // Sử dung với longStream: Để thấy sự khác biệt
        LongStream.rangeClosed(1,50).forEach(System.out::println);
        System.out.println("So sánh sự khác biệt phạm vi trong luồng LongStream: ");
        LongStream.range(1,50).forEach(System.out::println);
        // Sử dụng với luồng số thực.
        LongStream.rangeClosed(1,50).asDoubleStream().forEach(System.out::println);
        // Hoặc có thể viết.
        DoubleStream db = LongStream.rangeClosed(1,50).asDoubleStream();
    }
}
