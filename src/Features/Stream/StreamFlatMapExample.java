package Features.Stream;

import Features.Repository.Persion;
import Features.Repository.PersionRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {
    // Viết method lấy ra hobbies của persion:
    static List<String> listHobbies(List<Persion> listOfPersion) {
        return listOfPersion
                .stream()
                .map(Persion::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    // Viết method lấy ra hobbies của persion không bi trùng lặp:
    static List<String> distinctListHobbies(List<Persion> listOfPersion) {
        return listOfPersion
                .stream()
                .map(Persion::getHobbies)
                .flatMap(List::stream)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    // Khi muốn đếm số lượng sở thích của persion trong 1 ứng dụng lớn ta làm như thế nào:
    static long countHobbies(List<Persion> listOfPersion) {
        return listOfPersion
                .stream()
                .map(Persion::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    public static void main(String[] args) {
        // Khai báo list:
        List<Integer> oldList = Arrays.asList(1, 3, 5, 7);
        List<Integer> evenList = Arrays.asList(2, 4, 6, 8);
        // Ghép 2 list với nhau:
        List<List<Integer>> listOfList = Arrays.asList(oldList, evenList);
        //In ra list trước khi Flatmap:
        System.out.println("Before flatmap: " + listOfList);
        // Sử dụng Stream Flatmap:
        List<Integer> listOfFlatmap = listOfList
                .stream()
//                .flatMap(list -> list.stream())
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("After Flatmap: " + listOfFlatmap);

        //In ra list hobbies Persion Duplicates.
        System.out.println("Hobbies of Persion with Duplicates: " +
                listHobbies(PersionRepository.getAllPersions()));

        //In ra list hobbies Persion đã sắp xếp loại bỏ trùng lặp.
        System.out.println("Hobbies of Persion without Duplicates: " +
                distinctListHobbies(PersionRepository.getAllPersions()));
        // In ra số lượng Hobbies:
        System.out.println("Count of Hobbies: " +
                countHobbies(PersionRepository.getAllPersions()));
    }
}
