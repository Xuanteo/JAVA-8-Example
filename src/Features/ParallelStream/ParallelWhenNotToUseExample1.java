package Features.ParallelStream;

import java.util.stream.IntStream;

public class ParallelWhenNotToUseExample1 {

    public static void main(String[] args) {
        // Tạo 1 đối tượng tính toán:
        Caculation caculation = new Caculation();
        IntStream.rangeClosed(1, 2000).forEach(caculation::caculation);
        System.out.println("Result is Sequential: " + caculation.getTotal());
        IntStream.rangeClosed(1, 2000).parallel().forEach(caculation::caculation);
        System.out.println("Result is Parallel : " + caculation.getTotal());
        // Khi chạy luồng parallel vì nó chạy song song nên đầu ra của dữ liệu khác nhau
        // Thay đổi mất dữ liêu khi thực hiện tính toán.
        // Khi thực hiện nên đảm bảo nó không ảnh hưởng tới bất cứ điều gì, cả luồng dữ liệu.
        // Phải đảm bảo khi chạy luồng // phải đảm bảo về hiệu suất, kết quả hợp lệ.
    }


}

// Kiểm tra performance trong trường hợp 1 lớp:
class Caculation {
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    // Tạo 1 method tính:
    public void caculation(int input) {
        total += input;
    }

}