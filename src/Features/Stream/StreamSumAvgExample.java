package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSumAvgExample {
    // Method đếm tổng số kíds của persion thực hiện sum ở phần collect đã thu thập dữ liệu.
    static int sumTotalKids(){
        return PersonRepository.getAllPersions()
                .stream()
                .collect(Collectors.summingInt(Person::getKids));
    }
    // Viết method tính trung bình chiều cao.
    static double averageHeight(){
        return PersonRepository.getAllPersions()
                .stream()
                .collect(Collectors.averagingInt(Person::getHeight));
    }
    public static void main(String[] args) {
        // Gọi phương thức lấy ra tổng số trẻ:
        System.out.println("Sum Total Kids: " + sumTotalKids());
        // Gọi Phương thức lấy ra trung bình chiều cao:
        System.out.println("Average Height of Person: " + averageHeight());

        // Thử với 1 list số nguyên :
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        int total = integerList.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Total integer: " + total);
        double avg = integerList.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println("Average Integer: " + avg);

    }
}
