package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJoiningExample {
    // Sử dung joining nối chuỗi tên persion.
    static String joiningExample(){
        String s = PersonRepository.getAllPersions()
                .stream()
                .map(Person::getName)
//                .collect(Collectors.joining());
//                .collect(Collectors.joining(",");
                .collect(Collectors.joining(",", "[", "]"));
        return s;
    }
    public static void main(String[] args) {
        // Kết hợp dữ liệu bằng Stream joining. kết hợp dữ liệu từ đầu cuối của colect.
        // Khai báo 1 mảng.
        char[] ch = {'a', 'b', 'c', 'd', 'e'};
        String join = Stream.of(ch).map(arr -> new String(arr)).collect(Collectors.joining());
        // In ra kết quả join
        System.out.println("Joined data: " + join);
        // Sử dung joining có thêm param: dấu phân các của param delimiter không thể thực hiên với kí tự đơn.
        String join1 = Stream.of(ch).map(arr -> new String(arr))
                .collect(Collectors.joining("/", "[", "]"));
        System.out.println("Joined data: " + join1);
        // Sử dụng joining để nối chuỗi tên persion :
        System.out.println("Joined data: " + joiningExample());
    }
}
