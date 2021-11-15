package Features.Consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        // 2 tham số truyền vào:
        BiConsumer<Integer, Integer> con1 = (a, b) -> System.out.println("Add: " + (a + b));
        con1.accept(10, 15);

        // So sánh leght 2 list :
        List<Integer> list1 = Arrays.asList(new Integer(10), new Integer(10), new Integer(10));
        List<Integer> list2 = Arrays.asList(new Integer(10), new Integer(10));
        BiConsumer<List<Integer>, List<Integer>> consumer = (l1, l2) -> {
            if (l1.size() == l2.size()) System.out.println("True");
            else System.out.println("False");
        };
        consumer.accept(list1, list2);

        // Có 3 người dùng thực hiện 3 phép tính tiêu dùng khác nhau.
        BiConsumer<Integer, Integer> addConsumer1 = (a, b) -> System.out.println("Add: " + (a + b));
        BiConsumer<Integer, Integer> subsConsumer2 = (a, b) -> System.out.println("Subs: " + (a - b));
        BiConsumer<Integer, Integer> multConsumer3 = (a, b) -> System.out.println("Mul: " + (a * b));
        addConsumer1.andThen(subsConsumer2).andThen(multConsumer3).accept(20,10);
    }
}