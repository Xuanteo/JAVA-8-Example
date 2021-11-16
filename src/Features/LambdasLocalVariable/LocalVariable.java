package Features.LambdasLocalVariable;

import java.util.function.Consumer;

public class LocalVariable {
    // Biến instance
    String x = "Hello";
    // Biến Static
    static int k = 0;
    public static void main(String[] args) {
        // Là biến cục bộ không thể sử dụng bên ngoài của method, lớp
        // Không thể thay đổi biến nhưng có thể thay đổi giá trị
        // Biến local:
        int i =0;
        Consumer<Integer> con1 = (j) -> {
//            i++;
            k =15;
            System.out.println("Value is: " + (i+j));
            System.out.println("Value is with static variable K: " + k);
        };
        con1.accept(25);
        // Cách gọi biến instance phải thông qua class
        LocalVariable localVariable = new LocalVariable();
        System.out.println(localVariable.x);
    }
}
