package Features.Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapExample {
    // method converting int -> double and sum.
    static double map2Double() {
        return IntStream.rangeClosed(1, 10) // Primitive int elements
                .mapToDouble(x -> x) // converting the elements to double
                .sum(); // performing sum.
    }

    // Method converting int -> long and sum.
    static long map2Long() {
        return IntStream.rangeClosed(1, 10) // Primitive int elements
                .mapToLong(x -> x) // converting the elements to long
                .sum(); // performing sum.
    }

    // Method converting int -> object
    static List<Integer> map2Object() {
        return IntStream.rangeClosed(1, 10)
//                .mapToObj(x -> {return new Integer(x);})
                .mapToObj(x -> x)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Thực hiện In ra kiểm tra method converting int -> double and sum.
        System.out.println("Map 2 Double: " + map2Double());
        // Thực hiện In ra kiểm tra method converting int -> long and sum.
        System.out.println("Map 2 Double: " + map2Long());
        // Thực hiện In ra kiểm tra map converting int -> object.
        System.out.println("Map 2 Object: " + map2Object());
    }


}
