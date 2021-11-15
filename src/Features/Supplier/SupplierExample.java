package Features.Supplier;

import Features.Repository.Persion;
import Features.Repository.PersionRepository;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    static Supplier<Persion> s1 = () -> PersionRepository.getPersion();
    static Supplier<List<Persion>> s2 = () -> PersionRepository.getAllPersions();

    public static void main(String[] args) {
        System.out.println("Result 1: " + s1.get());
        System.out.println("Result 2: " + s2.get());
    }
}
