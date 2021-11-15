package Features.MethodReference;

import java.util.Comparator;

public class MethodReferenceExample {
    // Tạo 1 phương thức so sánh:
    public static int compare(Integer x, Integer y){
        return x.compareTo(y);
    };
    // sử dụng ClassName :: MethodName
    public static void main(String[] args) {
        System.out.println("Result 1: "+MethodReferenceExample.compare(20,10));
        // Tham chiếu 1 method trong class.
        Comparator<Integer> comparator = MethodReferenceExample :: compare;
        System.out.println("Result 2: " + comparator.compare(20,10));
    }
}
