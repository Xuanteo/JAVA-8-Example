package Features.Stream;

import java.util.Arrays;
import java.util.List;

public class StreamLimitExample {

    public static void main(String[] args) {
        // Khai báo 1 list
        List<String> fruits = Arrays.asList("Apple", "Orange", "Graphs", "Banana", "Pineapple");
        // Bài toán đặt ra là ko muốn in ra cả list mà chỉ in ra 2 phần tử:
        System.out.println("In ra 2 phần tử trong list: ");
        fruits.stream().limit(2).forEach(System.out::println);
        // Khai báo 1 list Integer:
        List<Integer> listInteger = Arrays.asList(1, 2, 3, 4, 5, 6);
        // In ra kết quả của tổng 4 số đầu tiên trong dãy. sử dụng limit.
        int sum = listInteger.stream().limit(4).reduce(0, (x, y) -> x + y);
        System.out.println("Tổng 4 số đầu trong dãy là:" + sum);
        // Sử dung skip để bỏ qua các phần tử và tính tổng các phần tử ko bị bỏ qua. Bỏ qua 2 phần tử.
        int skip = listInteger.stream().skip(2).reduce(0, (x, y) -> x + y);
        System.out.println("Sum of skip: " + skip);

    }
}
