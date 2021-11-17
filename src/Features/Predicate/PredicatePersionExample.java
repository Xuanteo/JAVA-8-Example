package Features.Predicate;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatePersionExample {
    static Predicate<Person> predicate1 = p -> p.getHeight() >= 170;
    static Predicate<Person> predicate2 = p -> p.getGender().equals("Male");

    public static void main(String[] args) {
        List<Person> listPerson = PersonRepository.getAllPersions();
        // Sử dụng Stream API để lọc persion có chiều cao > 170 và là nam in ra:
        listPerson.stream().filter(predicate1).collect(Collectors.toList());
        listPerson.forEach(p -> {
            if(predicate1.and(predicate2).test(p)) {
                System.out.println(p);
            }
        });
    }
}
