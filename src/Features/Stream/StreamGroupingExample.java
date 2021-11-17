package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGroupingExample {
    // Grouping ở collect với gender của person.
    static void groupByGender() {
        // Dử liệu trả về sẽ có kiểu key-value nên dùng map để nhận dữ liệu
        Map<String, List<Person>> groupData = PersonRepository.getAllPersions()
                .stream()
                .collect(Collectors.groupingBy(Person::getGender));
        // In dữ liệu map.
        groupData.entrySet().forEach(data -> System.out.println("Gender: " + data.getKey()
                + " Listperson: " + data.getValue()));
        // Hoặc in theo kiểu Stream.
        Stream.of(groupData).forEach(System.out::println);
    }

    static void groupByHeight() {
        Map<String, List<Person>> groupData = PersonRepository.getAllPersions()
                .stream()
                .collect(Collectors.groupingBy(per -> per.getHeight() >= 170 ? "Tallest" : "Shortest"));
        // In ra:
        Stream.of(groupData).forEach(System.out::println);
    }

    // Check 2 điều kiện đồng thời: gender và height.
    static void twoLevelGrouping() {
        Map<String, Map<String, List<Person>>> groupData = PersonRepository.getAllPersions()
                .stream()
                .collect(Collectors.groupingBy(Person::getGender,
                        Collectors.groupingBy(per -> per.getHeight() >= 170 ? "Tallest" : "Shortest")));
        // In ra:
        Stream.of(groupData).forEach(System.out::println);
    }

    // Check 2 điều kiện name và kids : Tính tổng kíds của persion.
    static void twoLevelGroupingCount() {
        Map<String, Integer> groupData = PersonRepository.getAllPersions()
                .stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.summingInt(Person::getKids)));
        //In ra.
        Stream.of(groupData).forEach(System.out::println);
    }
    // Check three level for Grouping.
    static void threeLevelGrouping(){
        Map<String, List<Person>> groupData = PersonRepository.getAllPersions()
                .stream()
                .collect(Collectors.groupingBy(Person::getName //Nhóm theo tên.
                        , HashMap::new // Tất cả thể hiện dưới hashmap mã bảng băm.
                        ,Collectors.toList())); // Data trả ra thể hiện dưới 1 list.
    }

    public static void main(String[] args) {
        // Goi ra method Grouping:
        groupByGender();
        System.out.println("-------------------");
        groupByHeight();
        System.out.println("-------------------");
        twoLevelGrouping();
        System.out.println("-------------------");
        twoLevelGroupingCount();
        System.out.println("-------------------");
        threeLevelGrouping();
    }
}
