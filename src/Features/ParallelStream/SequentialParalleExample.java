package Features.ParallelStream;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SequentialParalleExample {

    public static void main(String[] args) {
        //Cách lấy ra có bao nhiêu core đang chạy.trên bộ xử lý.
        System.out.println(Runtime.getRuntime().availableProcessors());
        String str[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        // Chạy theo tuần tự từng luồng.
        System.out.println("--------Sequential Run--------");
        printStream(Arrays.stream(str).sequential());
        // Chạy theo luồng //
        System.out.println("--------Parallel Run----------");
        printStream(Arrays.stream(str).parallel());
    }

    // Method tạo 1 luồng chạy stream:
    static void printStream(Stream<String> stream) {
        stream.forEach(p -> {
            System.out.println(LocalTime.now()
                    + " Value :" + p + " - Thead : " + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
