package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamAllOrAnyMatchExample {
    // Viết điều kiên check trong list Fruits
    static Predicate<String> p1 = s -> s.length() > 7;
    // Viết điều kiện check chiều cao trong list Person.
    static Predicate<Person> p2 = per -> per.getHeight() > 170;
    // Viết điều kiện check gender của person.
    static  Predicate<Person> p3 = per -> per.getGender().equals("Male");

    public static void main(String[] args) {
        // Khai báo 1 list
        List<String> fruits = Arrays.asList("Apple", "Orange", "Graphs", "Banana", "Pineapple");
        // Sử dụng lengthCheck all match: cần phù hợp tất cả các phần từ
        System.out.println("Result Length Check all Match: " + fruits.stream().allMatch(p1));
        // Sử dụng lengthCheck Any match: chỉ cần phù hợp 1 phần tử
        System.out.println("Result Length Check all Match: " + fruits.stream().anyMatch(p1));
        // Sử dung All Match check person.
        System.out.println("Result all Match height check: "+ PersonRepository.getAllPersions()
                .stream().allMatch(p2));
        // Sử dung Any Match check person.
        System.out.println("Result all Match height check: "+ PersonRepository.getAllPersions()
                .stream().anyMatch(p2.and(p3)));
    }
}
