package Features.Supplier;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    static Supplier<Person> s1 = () -> PersonRepository.getPersion();
    static Supplier<List<Person>> s2 = () -> PersonRepository.getAllPersions();

    public static void main(String[] args) {
        System.out.println("Result 1: " + s1.get());
        System.out.println("Result 2: " + s2.get());

    }
}
