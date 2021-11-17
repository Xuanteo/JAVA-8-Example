package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamPartitioningExample {
    // Tạo 1 điều kiện Predicate để check Height.
    static Predicate<Person> p1 = per -> per.getHeight() >= 170;

    // Method tìm kiếm theo phần vùng theo điều kiện Predicate.
    // Kết quả trả lại của phân vùng thì trả ra dưới dạng key value
    static void partitionByHeight() {
        Map<Boolean, List<Person>> map = PersonRepository.getAllPersions()
                .stream()
                .collect(Collectors.partitioningBy(p1));
        // In ra dữ liệu:
        System.out.println("Persion Map:" + map);
    }

    // Method tìm theo phân vùng với 2 điều kiện Param truyền vào.
    static void byHeightWith2Param() {
        Map<Boolean, Set<Person>> map = PersonRepository.getAllPersions()
                .stream()
                .collect(Collectors.partitioningBy(p1, Collectors.toSet()));
        System.out.println("Person map 2 param: " + map);
    }
    // Method tìm theo phân vùng với 2 điều kiện. điều kiện thứ 2 sử dụng map.
    static  void byHeightWithMap(){
         Map<Boolean, Map<String,List<String>>> map = PersonRepository.getAllPersions()
                .stream()
                .collect(Collectors.partitioningBy(p1,
                        Collectors.toMap(Person::getName, Person::getHobbies)));
        System.out.println("Person map 2 param with Map: " + map);
    }

    public static void main(String[] args) {
        partitionByHeight();
        System.out.println("--------------");
        byHeightWith2Param();
        System.out.println("--------------");
        byHeightWithMap();
    }
}
