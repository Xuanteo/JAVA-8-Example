package Features.Stream;

import Features.Repository.Persion;
import Features.Repository.PersionRepository;

import java.util.Comparator;

public class StreamCustomSortExample {

    public static void main(String[] args) {
        // Sắp Xếp Persion theo tên: viết trong cùng 1 luồng
        System.out.println("Sort by Name Persion: ");
        PersionRepository.getAllPersions()
                .stream()
                .sorted(Comparator.comparing(Persion::getName))
                .forEach(System.out::println);
        // Sắp xếp theo Height:
        System.out.println("Sort by Height: ");
        PersionRepository.getAllPersions()
                .stream()
                .sorted(Comparator.comparing(Persion::getHeight))
                .forEach(System.out::println);
        // Sắp xếp name theo thứ tự ngược lại.
        System.out.println("Reverse Sort by Name: ");
        PersionRepository.getAllPersions()
                .stream()
                .sorted(Comparator.comparing(Persion::getName).reversed())
                .forEach(System.out::println);
    }
}
