package Features.Stream;

import java.util.Arrays;
import java.util.List;

public class StreamReduceExample {

    public static void main(String[] args) {
        // Tạo 1 list:
        List<Integer> listOfInterger = Arrays.asList(1,2,3,4,5,6);
        // Tính tổng của dãy số:
        System.out.println("Tính tổng của 1 dãy số nguyên: ");
        int sum = listOfInterger.stream().mapToInt(i ->i).sum();
        System.out.println("Sum Result: " + sum);
        System.out.println("Đếm số nguyên trong List");
        System.out.println(listOfInterger.stream().mapToInt(i -> i).count());
        // Sử dụng Reduce để nhân các phần tử với nhau trong dãy:
        // Khi sử dụng phép nhân thì param bắt đầu để 1 vì nếu để 0 tất cả phép nhân cho 0 đều =0
        System.out.println("Resulte of Multiplication: "+
                listOfInterger.stream().reduce(1, (a, b) -> a * b));
        //Cách hoạt động:
        //1*1=1
        //1*2=2
        //2*3=6
        //6*4=24
        //24*5=120
        //120*6=720
        // Sử dụng để thực hiện các phần tử trong list:
        // Khi sử dung phép cộng thì param đầu để là 0 ko thay đổi kết quả của chuỗi
        System.out.println("Resulte of Addition: "+
                listOfInterger.stream().reduce(0, (a, b) -> a + b));
    }
}
