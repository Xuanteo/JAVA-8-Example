package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterExample {

    static Predicate<Person> p1 = per -> per.getHeight() >170;
    static Predicate<Person> p2 = per -> per.getGender().equals("Male");

    public static void main(String[] args) {
        // Tạo 1 list:
        List<String> names = Arrays.asList("Sam", "Anderson", "Peter", "Nancy");
        // Lấy tên có chiều dài chuỗi lớn hơn 4.
        Stream<String> allNames = names.stream();
        Stream<String> updateList = allNames.filter(p-> p.length()>3);
        updateList.forEach(System.out::println);
        //Cách viết khác:
        List<String> nameLenght = names.stream().filter(p -> p.length() > 3).collect(Collectors.toList());
        System.out.println(nameLenght);
        // Lấy danh sách persion thoả mãn điều kiện chiều cao > 170.
        List<Person> l1 = PersonRepository.getAllPersions()
                .stream()
                .filter(per-> per.getHeight() >170)
                .collect(Collectors.toList());
        // In ra list:
        System.out.println("In ra danh sách persion có chiều cao > 170: ");
        l1.forEach(System.out::println);
        // Lấy danh sánh persion thoả mãn là nam có chiều cao > 170.
        System.out.println("In ra những Persion thoả mãn điều kiện Height > 170, và là Male");
        PersonRepository.getAllPersions()
                .stream()
                .filter(per -> per.getHeight()>170)
                .filter(per-> per.getGender().equals("Male"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // Viết theo check điều kiện perdicate:
        System.out.println("Check theo điều kiện predicate viết ngoài: ");
        PersonRepository.getAllPersions()
                .stream()
                .filter(p1.and(p2))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
