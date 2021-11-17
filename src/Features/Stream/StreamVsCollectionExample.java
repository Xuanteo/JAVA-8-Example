package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamVsCollectionExample {

    public static void main(String[] args) {
        // Khai báo ra 1 list:
        List<String> names = new ArrayList<>();
        names.add("Xuan");
        names.add("Loc");
        names.add("Cuong");
        names.add("Chung");

        // In ra tên sử dụng cách cũ java < 8
        // Theo collection: có thể viết lặp lại nhiều lần.
        for (String name : names) {
            System.out.println("Sử dụng java cũ : " + name);
        }
        for (String name : names) {
            System.out.println("Sử dụng java cũ 1: " + name);
        }
        // In ra sử dụng Stream: Với stream khi luồng tạo ra chạy thì không được lặp lại.
        Stream<String> nameStream = names.stream();
        nameStream.forEach(p -> System.out.println("Áp dụng Stream + lambdas: " + p));
//        nameStream.forEach(p -> System.out.println("Áp dụng Stream + lambdas: "+p));

        // Lấy tên của persion trong list persion sử dụng stream để mở luồng.
        List<String> namePersion = PersonRepository
                .getAllPersions()
                .stream()
                .peek(per -> System.out.println(per)) //Trả về kết quả của mở luồng Stream of persion. dùng gỡ lỗi kiểm tra kết quả Stream.
                .map(Person::getName)
                .peek(System.out::println)  // Có thể đặt ở các vị trí để kiểm tra kết quả trả ra sau map.
                .collect(Collectors.toList());
        System.out.println(namePersion);
    }
}
