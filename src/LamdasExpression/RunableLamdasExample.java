package LamdasExpression;

public class RunableLamdasExample {
    public static void main(String[] args) {
        // Khi sử dụng Java 7 để chạy đa luồng
        // Ví dụ về sử dụng đa luồng xử lý.
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1");
            }
        };
        // Để bắt đầu chạy 1 luồng.
        new Thread(t1).start();

        // Sử dụng Java 8 để xây dựng đa luồng chạy.
         Runnable t2 = () -> {
             System.out.println("Thread 2");
         };
         new Thread(t2).start();

         // Sử dụng nhiều luồng chạy với lamdas.
        Runnable t3 = () -> {
            System.out.println("Thread 3");
            System.out.println("Thread 3.1");
        };
        new Thread(t3).start();

        // Viết tạo chạy 1 luồng bằng cách viết ngắn gọn hơn.
        // Viêt Java 7.
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 4");
            }
        }).start();
        // Viết với Java 8 sử dụng lamdas.
        new Thread(()-> {System.out.println("Thread 5");}).start();
        // Nếu muốn tạo và chạy nhiều luồng.
        new Thread(()-> {
            System.out.println("Thread 6");
            System.out.println("Thread 6.1");
        }).start();
    }
}
