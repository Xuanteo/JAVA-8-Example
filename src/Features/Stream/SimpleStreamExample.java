package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStreamExample {

    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 6);
        s1.forEach(p -> System.out.println(p));
        System.out.println("==========");
        Stream<Integer> s2 = Stream.of(new Integer[]{1, 2, 3, 4, 5});
        s2.forEach(p -> System.out.println(p));

        // Dùng stream API lấy dữ liệu persion:
        // iterater of persion -> Stream persion.
        Map<String, List<String>> mapPersion = PersonRepository
                .getAllPersions() // iterate all persition
                .stream() // Stream of persion
                .collect(Collectors.toMap(Person::getName, Person::getHobbies));
        System.out.println("Result Map Persion: " + mapPersion);

        // Lọc có thêm điều kiện lọc:
        Predicate<Person> p1 = (per) -> per.getHeight() >= 170;
        Predicate<Person> p2 = per -> per.getGender().equals("Male");

        Map<String, List<String>> mapPersion1 = PersonRepository
                .getAllPersions()
                .stream()
                .filter(p1)
                .filter(p2)
//                .filter(p1.and(p2)) // có thể lọc được 1 hoặc nhiều điều kiện.
                .collect(Collectors.toMap(Person::getName, Person::getHobbies));
        System.out.println("Result Map Persion 1: " + mapPersion1);

        // Lấy ra danh sách sở thích của persion.
        List<String> listHobbies = PersonRepository
                .getAllPersions()  // List of persion
                .stream() // Stream of persion
                .map(Person::getHobbies) // Stream list<String>
                .flatMap(List ::stream)     // Stream<String> vì persion đã khai báo 1 list Hobbies nên phải sử dụng
                .collect(Collectors.toList()); // colection to be returned.
        System.out.println("List Hobbies Persion: " + listHobbies);

        // Kết quả tra ra có trùng lặp vì chỉ cần lấy list ko trùng lặp:
        List<String> listHobbies1 = PersonRepository
                .getAllPersions()  // List of persion
                .stream() // Stream of persion
                .map(Person::getHobbies) // Stream list<String>
                .flatMap(List ::stream)     // Stream<String> vì persion đã khai báo 1 list Hobbies nên phải sử dụng
                .distinct()
                .collect(Collectors.toList()); // colection to be returned.
        System.out.println("List Hobbies Persion 1: " + listHobbies1);
    }
}
