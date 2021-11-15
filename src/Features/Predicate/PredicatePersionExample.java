package Features.Predicate;

import Features.Repository.Persion;
import Features.Repository.PersionRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatePersionExample {
    static Predicate<Persion> predicate1 = p -> p.getHeight() >= 170;
    static Predicate<Persion> predicate2 = p -> p.getGender().equals("Male");

    public static void main(String[] args) {
        List<Persion> listPersion = PersionRepository.getAllPersions();
        // Sử dụng Stream API để lọc persion có chiều cao > 170 và là nam in ra:
        listPersion.stream().filter(predicate1).collect(Collectors.toList());
        listPersion.forEach(p -> {
            if(predicate1.and(predicate2).test(p)) {
                System.out.println(p);
            }
        });
    }
}
