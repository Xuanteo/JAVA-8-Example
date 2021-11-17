package Features.Optional;

import Features.Repository.Person;
import Features.Repository.PersonRepository;
import com.ptx.ForEachAndComparator.Persion;

import java.util.Optional;

public class OptionalIfElseExample {
    public static void main(String[] args) {
        orElse();
        orElseGet();
    }

    static void orElse() {
        Optional<Person> per = PersonRepository.getOptionalPerson();
        // Viết mã check điều kiện theo kiểu:
        String name = per.isPresent() ? per.get().getName() : "Data not found";
        // Viết theo 1 dạng khác tối ưu hơn mà ý nghĩa vẫn thế:
        String name1 = per.map(Person::getName).orElse("Data not found");
        System.out.println("orElse Persion Name: " + name);
        System.out.println("orElse Persion Name1: " + name1);
    }

    // Có 1 phương thức khác để viết 1 số logic ở trong lambdas.
    static void orElseGet() {
        Optional<Person> per = PersonRepository.getOptionalPerson();
        String name = per.map(Person::getName).orElseGet(() -> {
            // có thể thực hiện 1 số logic bên trong
            // to send a notification mail
            // Initiate any script
            return "Data not found";
        });
        System.out.println("orElseGet Persion Name: " + name);
    }

    // 1 Phương thức tiếp theo thực hiện cũng tương tự giống.
    // Sử dụng trong 1 số trường hợp dữ liệu không tìm thấy.
    // Hoặc trả về 1 thông báo ngoại lệ
    static void orElseThrow() {
        Optional<Person> per = PersonRepository.getOptionalPerson();
        String name = per.map(Person::getName).orElseThrow(() -> new RuntimeException("Data not found"));
        System.out.println("orElseThrow Persion Name: " + name);
    }
}
