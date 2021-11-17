package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.Optional;
import java.util.function.Predicate;

public class StreamFindAnyFirstExample {
    static Predicate<Person> p1 = per -> per.getHeight() >= 200;
    static Predicate<Person> p2 = per -> per.getGender().equals("Male");

    public static void main(String[] args) {
        // Tìm kiếm bất kì.
//        System.out.println("Find Any Result: " + findAny().get());
        // Viết theo cách kiểm tra 1 đối tượng trong Optional có rỗng hay không.
        Optional<Person> findAny = findAny();
        if (findAny.isPresent()){
            System.out.println("Find Any Result1: "+ findAny.get());
        }
        else System.out.println("No Record Found");
        // Tìm kiếm đầu tiên
//        System.out.println("Find First Result: " + findFirst().get());
        // Viết theo cách kiểm tra 1 đối tượng trong Optional có rỗng hay không.
        Optional<Person> findFirst = findFirst();
        if (findFirst.isPresent()){
            System.out.println("Find First Result1: " + findFirst.get());
        }
        else System.out.println("No Record Found");
    }

    // Method lấy ra 1 đối tượng ngẫu nhiên thoả mãn điều kiện. Tìm kiếm bất kì.
    static Optional<Person> findAny() {
        return PersonRepository.getAllPersions()
                .stream()
                .filter(p1)
                .findAny();
    }
    // Method lấy ra 1 đối tượng đầu tiên thoả mãn điều kiện. Tìm kiếm đối tượng đầu tiên.
    static Optional<Person> findFirst() {
        return PersonRepository.getAllPersions()
                .stream()
                .filter(p2)
                .findFirst();
    }
}
