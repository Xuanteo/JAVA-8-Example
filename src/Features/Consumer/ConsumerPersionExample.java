package Features.Consumer;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerPersionExample {

    static Consumer<Person> c1 = p -> System.out.println(p);

    static Consumer<Person> c2 = p -> System.out.println(p.getName().toUpperCase());

    static Consumer<Person> c3 = p -> System.out.println(p.getHobbies());

    static List<Person> personList = PersonRepository.getAllPersions();

    static void printNameAndHobbies() {
        personList.forEach(c2.andThen(c3));
    }

    static void printWithCondition() {
        // iterate list
        personList.forEach(p -> {
            if (p.getGender().equals("Male") && p.getHeight()>= 170){
                c2.andThen(c3).accept(p);
            };
        });
    }

    public static void main(String[] args) {
        // Lấy ra thông tin 1 sinh viên.
        c1.accept(PersonRepository.getPersion());
        c2.accept(PersonRepository.getPersion());
        c3.accept(PersonRepository.getPersion());
        c1.andThen(c2).andThen(c3).accept(PersonRepository.getPersion());
        // Lấy ra thông tin name và hobbies của persion.
        System.out.println("Lấy ra thông tin Name và Hobbies của Persion: ");
        printNameAndHobbies();
        System.out.println("Lấy ra thông tin Persion với Persion = Male và Height >=170mm: ");
        printWithCondition();
    }
}
