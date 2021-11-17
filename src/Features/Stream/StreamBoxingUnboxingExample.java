package Features.Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamBoxingUnboxingExample {
    // Method for boxing : chuyển đổi kiểu dữ liệu từ kiểu nguyên thuỷ Primitive -> kiểu object wapperclass.
    static List<Integer> boxingMethod(){
        return IntStream.rangeClosed(1,40) // primitive int
                .boxed() // converting to wapper class
                .collect(Collectors.toList()); // collect as list
    }
    // Method for Unboxing: Chuyển đổi kiểu dữ liệu từ wapper class -> primitive.
    static int calculateSum(List<Integer> list){
        return list.stream()
                .mapToInt(Integer::intValue) // map do the converting part
                .sum(); // performing sum operation.
    }

    public static void main(String[] args) {
        // Thực hiện kiểm tra kết quả của BoxingMethod:
        System.out.println("Result Boxing Method: ");
        boxingMethod().forEach(System.out::println);
        // Thực hiện kiểm tra Unboxing method:
        System.out.println("Result sum is: " + calculateSum(boxingMethod()));

    }
}
