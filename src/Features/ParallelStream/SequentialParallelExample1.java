package Features.ParallelStream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SequentialParallelExample1 {

    public static void main(String[] args) {
        // In ra:
        System.out.println("Sum from Sequential: " + sumMethodUsingSeq());
        // In ra:
        System.out.println("Sum from Parallel: " + sumMethodUsingParallel());

        // In ra kiểm tra phản hồi của chạy tuần tự và chạy song song: logic phức tạp nhiều thì chạy // sẽ nhanh hơn.
        // In ra:
        System.out.println("Sum from Sequential: "
                + checkPerformance(SequentialParallelExample1::sumMethodUsingSeq, 25));
        // In ra:
        System.out.println("Sum from Parallel: "
                + checkPerformance(SequentialParallelExample1::sumMethodUsingParallel, 25));
    }

    // Câu hỏi đặt ra xem luồng nào chạy nhanh hơn.
    // Viết 1 phương thức check perfomence.
    static long checkPerformance(Supplier<Integer> sum, int numOfTimes) {
        long start = System.currentTimeMillis();
        for (int i = 0; i <= numOfTimes; i++) {
            sum.get();
        }
        long end = System.currentTimeMillis();

        return end - start;
    }


    // Viết method thực hiện theo seq
    static int sumMethodUsingSeq() {
        return IntStream.rangeClosed(0, 100000000).sum();
    }

    // Viết 1 method khác cùng chạy nhưng hoạt động 1 cách //
    static int sumMethodUsingParallel() {
        return IntStream.rangeClosed(0, 100000000).parallel().sum();
    }
}
