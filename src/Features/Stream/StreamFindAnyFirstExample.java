package Features.Stream;

import Features.Repository.Persion;
import Features.Repository.PersionRepository;

import java.util.Optional;
import java.util.function.Predicate;

public class StreamFindAnyFirstExample {
    static Predicate<Persion> p1 = per -> per.getHeight() >= 200;
    static Predicate<Persion> p2 = per -> per.getGender().equals("Male");

    public static void main(String[] args) {
        // Tìm kiếm bất kì.
//        System.out.println("Find Any Result: " + findAny().get());
        // Viết theo cách kiểm tra 1 đối tượng trong Optional có rỗng hay không.
        Optional<Persion> findAny = findAny();
        if (findAny.isPresent()){
            System.out.println("Find Any Result1: "+ findAny.get());
        }
        else System.out.println("No Record Found");
        // Tìm kiếm đầu tiên
//        System.out.println("Find First Result: " + findFirst().get());
        // Viết theo cách kiểm tra 1 đối tượng trong Optional có rỗng hay không.
        Optional<Persion> findFirst = findFirst();
        if (findFirst.isPresent()){
            System.out.println("Find First Result1: " + findFirst.get());
        }
        else System.out.println("No Record Found");
    }

    // Method lấy ra 1 đối tượng ngẫu nhiên thoả mãn điều kiện. Tìm kiếm bất kì.
    static Optional<Persion> findAny() {
        return PersionRepository.getAllPersions()
                .stream()
                .filter(p1)
                .findAny();
    }
    // Method lấy ra 1 đối tượng đầu tiên thoả mãn điều kiện. Tìm kiếm đối tượng đầu tiên.
    static Optional<Persion> findFirst() {
        return PersionRepository.getAllPersions()
                .stream()
                .filter(p2)
                .findFirst();
    }
}
