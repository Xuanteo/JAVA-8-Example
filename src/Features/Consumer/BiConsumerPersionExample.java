package Features.Consumer;

import Features.Repository.Persion;
import Features.Repository.PersionRepository;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerPersionExample {
    public static void printPersionDetail() {
        BiConsumer<String, List<String>> persionConsumer = (name, hobbies) -> System.out.println(name + " : " + hobbies);
        BiConsumer<String,Double> salaryConsumer = (name, salary) -> System.out.println(name + " : " + salary);
        List<Persion> listPersion = PersionRepository.getAllPersions();
        listPersion.forEach(persion -> persionConsumer.accept(persion.getName(), persion.getHobbies()));
        listPersion.forEach(per-> salaryConsumer.accept(per.getName(),per.getSalary()));
        // Viết ngắn gọn:
        listPersion.forEach(per-> {
            persionConsumer.accept(per.getName(), per.getHobbies());
            salaryConsumer.accept(per.getName(),per.getSalary());
        }) ;

    }

    public static void main(String[] args) {
        printPersionDetail();
    }
}
