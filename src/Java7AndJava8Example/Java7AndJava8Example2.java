package Java7AndJava8Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java7AndJava8Example2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Nam","Tuan","Linh","Nam");
        // Lấy ra tên không trùng lặp.
        // Dựa trên Java 7 lấy ra các tên không trùng lặp.
        List<String> uniqueNames = new ArrayList<>();
        for (String name: names) {
            // phương thức contains sử dụng để kiểm tra xem chuỗi có nằm trong chuỗi khác hay không.
            if (!uniqueNames.contains(name)){
                uniqueNames.add(name);
            }
        }
        System.out.println("List String Using Java 7: " + uniqueNames);

        // Dựa trên Java 8 để thực hiện lấy ra tên các phần tử không trùng lặp.
        // Collect trả về 1 collection được chỉ định.
        List<String> uniqueNames1 = names.stream().distinct().collect(Collectors.toList());
        System.out.println("List String Using Java 8: " + uniqueNames1);
    }
}
