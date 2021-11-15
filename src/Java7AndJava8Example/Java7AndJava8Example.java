package Java7AndJava8Example;

import java.util.stream.IntStream;

public class Java7AndJava8Example {
    public static void main(String[] args) {
        // Java 7:
        // Viết hàm tính tổng số < 50.
        int total = 0;
        for (int i = 0; i <= 50; i++) {
            total += i;
        }
        System.out.println("Total: " + total);

        // Viết theo Java8:
        // Sử dụng Stream API.
        // Toán tử (::) trong java gọi là toán tử tham chiếu phương thức. Nó sử dụng để gọi 1 phương thức trong lớp khác.
        // Nó giống như biểu thức lamda chỉ khác toán tử (::) tham chiếu đến phương thức bởi tên của phương thức.
        int total1 = IntStream.rangeClosed(0, 50).map(Integer::new).sum();
        System.out.println("Total using Java 8: " + total1);
    }
}
