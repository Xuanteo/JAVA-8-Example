package Features.Optional;

import java.util.Optional;

public class OptionalMethodExample {
    public static void main(String[] args) {
        // Trường hợp sử dụng ofNullable của Optional:
        Optional<String> ofNullable = Optional.ofNullable("java8");
        // In ra kết quả đang trả về 1 tuỳ chọn. luôn hiển thị vì tuỳ chọn có thể có hoặc empty.
        System.out.println(ofNullable);
        // In ra kết quả chính xác. nếu trường hợp ko có dữ liệu sẽ lỗi phải xét điều kiện isPresent();
        System.out.println(ofNullable.isPresent() ? ofNullable.get() : Optional.empty());

        // Trường hợp sử dụng of của Optional:
        // Với trường hợp để of trong Optinal khi giá trị trong of là null. Kể cả xét điều kiện isPresent() vẫn trả ra Exception.
        // Vậy cách sử lý là gì?
        Optional<String> of = Optional.of("Hello");
        System.out.println(of.isPresent() ? of.get() : Optional.empty());
        System.out.println(Optional.empty());
    }
}
