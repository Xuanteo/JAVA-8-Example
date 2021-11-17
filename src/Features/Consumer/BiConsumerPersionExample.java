package Features.Consumer;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerPersionExample {
    public static void printPersionDetail() {
        BiConsumer<String, List<String>> persionConsumer = (name, hobbies) -> System.out.println(name + " : " + hobbies);
        BiConsumer<String,Double> salaryConsumer = (name, salary) -> System.out.println(name + " : " + salary);
        List<Person> listPerson = PersonRepository.getAllPersions();
        listPerson.forEach(persion -> persionConsumer.accept(persion.getName(), persion.getHobbies()));
        listPerson.forEach(per-> salaryConsumer.accept(per.getName(),per.getSalary()));
        // Viết ngắn gọn:
        listPerson.forEach(per-> {
            persionConsumer.accept(per.getName(), per.getHobbies());
            salaryConsumer.accept(per.getName(),per.getSalary());
        }) ;

    }

    public static void main(String[] args) {
        printPersionDetail();
    }
}
