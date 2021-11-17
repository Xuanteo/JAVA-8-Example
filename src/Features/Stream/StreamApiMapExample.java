package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiMapExample {

    // Viết 1 phương thức lấy tên persion và chuyển tên thành chữ hoa.
    // Sử dụng list:
    public static List<String> toNameUppertransform(List<Person> listOfPerson) {
        return listOfPerson
                .stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
    // Sử dụng Set:
    public static Set<String> toNameUppertransformSet(List<Person> listOfPerson) {
        return listOfPerson
                .stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "orange", "Banana", "PineApple");
        // Câu hỏi đặt ra là lấy ra chiều dài ký tự của chuỗi trong list.
        // Cách viết 1: cách nên thực hiện.
        List<Integer> fruitsLenght = fruits.stream().map(String::length).collect(Collectors.toList());
        System.out.println(fruitsLenght);
        // Cũng có thể viết:
        fruits.stream().map(String::length).collect(Collectors.toList()).forEach(System.out::println);
        // In ra list Name to Upper case.
        System.out.println("List Name Persion to UpperCase List: " +
                toNameUppertransform(PersonRepository.getAllPersions()));
        System.out.println("List Name Persion to UpperCase Set: " +
                toNameUppertransformSet(PersonRepository.getAllPersions()));
    }
}
