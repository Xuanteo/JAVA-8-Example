package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.Comparator;

public class StreamCustomSortExample {

    public static void main(String[] args) {
        // Sắp Xếp Persion theo tên: viết trong cùng 1 luồng
        System.out.println("Sort by Name Persion: ");
        PersonRepository.getAllPersions()
                .stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
        // Sắp xếp theo Height:
        System.out.println("Sort by Height: ");
        PersonRepository.getAllPersions()
                .stream()
                .sorted(Comparator.comparing(Person::getHeight))
                .forEach(System.out::println);
        // Sắp xếp name theo thứ tự ngược lại.
        System.out.println("Reverse Sort by Name: ");
        PersonRepository.getAllPersions()
                .stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .forEach(System.out::println);
    }
}
