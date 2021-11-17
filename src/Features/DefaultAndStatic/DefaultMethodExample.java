package Features.DefaultAndStatic;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultMethodExample {
    public static void main(String[] args) {
        // Lấy ra namelist của list person:
        List<String> nameList = PersonRepository.getAllPersions()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        // In ra danh sách của person trước sort. theo java < 8
//        System.out.println("Before Sort: ");
//        nameList.forEach(System.out::println);
//        System.out.println("-------------");
//        Collections.sort(nameList);
//        System.out.println("After sort: ");
//        nameList.forEach(x-> System.out.println(x));
        // Theo java 8:
        System.out.println("NaturaOder Name");
        nameList.sort(Comparator.naturalOrder());
        nameList.forEach(x-> System.out.println(x));
        System.out.println("---------------------");
        System.out.println("reverse Name");
        nameList.sort(Comparator.reverseOrder());
        nameList.forEach(x-> System.out.println(x));
    }
}
