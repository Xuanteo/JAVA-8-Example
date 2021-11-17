package Features.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class NumericStreamExample {
    //Tạo toán tử nhị phân thực hiện cộng:
    static BinaryOperator<Integer> bo1 = (x, y) -> x + y;

    // Tạo phương thức tính tổng sử dụng reduce trong luồn Stream.
    static int calculateSum(List<Integer> l1) {
        return l1.stream().reduce(0, bo1);
    }

    // Tạo 1 phương thức tính tổng sử dụng luồng số nguyên thuỷ.
    static int calculateSumWithIntStream(IntStream intStream) {
        return intStream.sum();
    }

    public static void main(String[] args) {
        // Tạo 1 list số nguyên :
        List<Integer> l1 = Arrays.asList(4, 5, 6, 7, 8, 9);
        System.out.println("Result Sum: " + calculateSum(l1));

        // Sử Dung IntStream 1 luồng số nguyên thuỷ để thực hiên. và In ra kết quả.
        // rangeClose là phạm vi luồng đóng trong khoảng.
        IntStream intStream = IntStream.rangeClosed(4, 9);
        System.out.println("Result Total with IntStream: "+ calculateSumWithIntStream(intStream));
        // Có thể viết tình tổng số nguyên trong luồng 1->6
        System.out.println("Result Sum IntStream(1->6): "+IntStream.rangeClosed(1, 6).sum());
    }
}
