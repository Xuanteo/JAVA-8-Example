package Features.Predicate;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> lessThan = a -> (a <= 50);
        Predicate<Integer> greaterThan = a -> (a >= 100);
        Predicate<Integer> equalTo = a -> (a == 0);
        boolean result = lessThan.test(55);
        System.out.println("Result: " + result);
        System.out.println("Lessthan: " + lessThan.test(150));
        System.out.println("GreaterThan: " + greaterThan.test(150));
        System.out.println("EqualTo: " + equalTo.test(0));

        // Viết cách gộp chung:
        // So sánh thoả mãn đồng thời các điều kiện.
        boolean result1 = lessThan.and(greaterThan).and(equalTo).test(150);
        System.out.println("Result1: " + result1);
        // So sánh thoả mãn 1 trong 2 điều kiện
        boolean result2 = lessThan.or(greaterThan).test(150);
        System.out.println("Result2: " +result2);
        // negate đảo ngược lại kết quả trả về của điều kiện
        boolean result3 = lessThan.or(greaterThan).negate().test(150);
        System.out.println("Result3: " +result3);
    }
}
