package Features.Optional;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // In ra để kiểm tra:
        System.out.println("Result: " + myName("John"));
        // Sử dụng với Optional hoạt động tuỳ chọn hơn với trường hợp method return null;
        // Khi sử dụng Optional phải chắc chăn rằng dữ liệu đã có nếu không khi get sẽ xảy ra lỗi.
        // Khi sử dung phải check rằng dữ liệu có không
        Optional<String> name = Optional.ofNullable(myName("John"));
        // có thể viết đơn giản hơn:
//        String name1 = Optional.ofNullable(myName("John")).get();
        System.out.println(name.isPresent() ? name.get() : "Data Empty");
//        System.out.println(Optional.ofNullable(myName("John")));
        Optional<String> personname = personNameWithOptional(PersonRepository.getOptionalPerson());
        System.out.println("Optional person name is: "+personname.get());
    }

    // Viết 1 method lấy name:
    static String myName(String name) {
        return name;
    }

    // Viết method lấy dữ liệu từ person:
    static String personName(Person person) {
        if (person != null) {
            return person.getName();
        } else
            return "No data Found";
    }

    // Viết method tuỳ chọn với Optional:
    static Optional<String> personNameWithOptional(Optional<Person> per) {
        if (per != null) {
            return per.map(Person::getName);
        } else
            return Optional.empty();
    }
}

