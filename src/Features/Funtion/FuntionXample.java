package Features.Funtion;


import java.util.function.Function;

public class FuntionXample {
    static Function<String, String> f1 = name -> name.toUpperCase();
    static Function<String, String> f2 = name -> name.toUpperCase().concat("Features");

    public static void main(String[] args) {
        System.out.println("Result1: " + f1.apply("Java"));
        System.out.println("Result2: " + f2.apply("Java"));
        // Dữ liệu sử lý xong funtion 1-> f2
        System.out.println("And then Result: "+f1.andThen(f2).apply("Python"));
        // Dữ liệu xử funtion 1 -> f2 -> f1
        System.out.println("Compose Result: "+ f1.compose(f2).apply("Java"));

    }
}
