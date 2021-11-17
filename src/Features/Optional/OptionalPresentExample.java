package Features.Optional;

import java.util.Optional;

public class OptionalPresentExample {
    public static void main(String[] args) {
        // Trường hợp sử dung ofNallable của Optional.
        Optional<String> ofNullable = Optional.ofNullable("java8");
        // Check điều kiện dữ liệu có null ko để xét điều kiện trả ra kết quả.
        System.out.println(ofNullable.isPresent()? ofNullable.get():Optional.empty());
        // Tác dung giống trên cùng trả ra kết quả. hàm này giải thích cơ chế làm việc
        ofNullable.ifPresent(p-> System.out.println(p));
    }
}
