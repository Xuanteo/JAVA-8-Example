package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;

public class StreamMappingExample {
    static List<String> mappingNames() {
        List<String> names = PersonRepository.getAllPersions()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        // Sử dụng mapping dữ liệu từ collect:
        List<String> names1 = PersonRepository.getAllPersions()
                .stream()
                .collect(mapping(Person::getName, Collectors.toList()));
        return names1;
    }

    // 1 Phương pháp ánh xạ khác: sử dụng Set
    static Set<String> mappingNames1() {
        Set<String> names = PersonRepository.getAllPersions()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toSet());
        // Sử dụng mapping dữ liệu từ collect:
        Set<String> names1 = PersonRepository.getAllPersions()
                .stream()
                .collect(mapping(Person::getName, Collectors.toSet()));
        return names1;
    }
    // Sử dụng counting trong collect
    static long countTallPerson(){
        return PersonRepository.getAllPersions()
                .stream()
                .filter(per-> per.getHeight() >=170)
                .collect(Collectors.counting());
    }

    public static void main(String[] args) {
        // In ra list mapping Name:
        System.out.println("Mapping names using List: ");
        mappingNames().forEach(System.out::println);
        System.out.println("Mapping names using Set: ");
        mappingNames1().forEach(System.out::println);
        // Print Count Tall person
        System.out.println("Count Tall Person: " + countTallPerson());
    }
}
