package Features.LambdasLocalVariable;

import java.util.function.Consumer;

public class LocalVariable {
    String x = "Hello";
    static int k = 0;
    public static void main(String[] args) {
        // Là biến cục bộ không thể sử dụng bên ngoài của method, lớp
        // Không thể thay đổi biến nhưng có thể thay đổi giá trị
        int i =0;
        Consumer<Integer> con1 = (j) -> {
//            i++;
            k =15;
            System.out.println("Value is: " + (i+j));
            
        };
        con1.accept(25);
    }
}
