package LamdasExpression;

import java.util.Comparator;

public class ComparatorLamdasExample {
    public static void main(String[] args) {
        // Tạo ra 1 bộ so sánh 2 số nguyên.
        // Sử dụng Java 7 để viết : nhập vào x, y nếu x>y trả về 1, x=y trả về 0, x<y trả về -1
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x.compareTo(y);
            }
        };
        System.out.println("Comparator 1: "+comparator1.compare(15, 25));

        // Sử dụng Java 8 để viết:
        Comparator<Integer> comparator2 = (Integer x,Integer y) -> {return x.compareTo(y);};
        System.out.println("Comparator 2: "+comparator2.compare(15, 25));

        Comparator<Integer> comparator3 = (x,y) -> x.compareTo(y);
        System.out.println("Comparator 3: "+comparator3.compare(15, 10));
    }
}
