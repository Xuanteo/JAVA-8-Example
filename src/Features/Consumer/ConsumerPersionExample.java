package Features.Consumer;

import Features.Repository.Persion;
import Features.Repository.PersionRepository;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerPersionExample {

    static Consumer<Persion> c1 = p -> System.out.println(p);

    static Consumer<Persion> c2 = p -> System.out.println(p.getName().toUpperCase());

    static Consumer<Persion> c3 = p -> System.out.println(p.getHobbies());

    static List<Persion> persionList = PersionRepository.getAllPersions();

    static void printNameAndHobbies() {
        persionList.forEach(c2.andThen(c3));
    }

    static void printWithCondition() {
        // iterate list
        persionList.forEach(p -> {
            if (p.getGender().equals("Male") && p.getHeight()>= 170){
                c2.andThen(c3).accept(p);
            };
        });
    }

    public static void main(String[] args) {
        // Lấy ra thông tin 1 sinh viên.
        c1.accept(PersionRepository.getPersion());
        c2.accept(PersionRepository.getPersion());
        c3.accept(PersionRepository.getPersion());
        c1.andThen(c2).andThen(c3).accept(PersionRepository.getPersion());
        // Lấy ra thông tin name và hobbies của persion.
        System.out.println("Lấy ra thông tin Name và Hobbies của Persion: ");
        printNameAndHobbies();
        System.out.println("Lấy ra thông tin Persion với Persion = Male và Height >=170mm: ");
        printWithCondition();
    }
}
