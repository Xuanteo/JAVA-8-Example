package Features.ParallelStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelWhenNotToUseExample {
    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
        // Gọi method kiểm tra phản hồi của 2 phương pháp chạy luồng.
        System.out.println("Sequential Duration: " + sequentialCaculator(integerList));
        System.out.println("Parallel Duration: " + parallelCaculator(integerList));
        // Tốc độ của sequential> parallel vì với lượng bản ghi nhở, và trong list Interge sử dụng ép kiểu dữ liệu.
    }

    // Tạo method sử dụng Sequential:
    static int sequentialCaculator(List<Integer> list) {
        long start = System.currentTimeMillis();
        int total = list.stream().reduce(0, (x, y) -> x + y);
        long end = System.currentTimeMillis();
        System.out.println("Sequential Duration: " + (end - start));
        return total;
    }

    // Tạo method sử dung Parallel:
    static int parallelCaculator(List<Integer> list) {
        long start = System.currentTimeMillis();
        int total = list.parallelStream().reduce(0, (x, y) -> x + y);
        long end = System.currentTimeMillis();
        System.out.println("Parallel Duration: " + (end - start));
        return total;
    }
}
