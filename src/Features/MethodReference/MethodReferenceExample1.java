package Features.MethodReference;

import Features.Repository.Persion;
import Features.Repository.PersionRepository;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MethodReferenceExample1 {
    // Sử dụng lambdas
    static Function<String, String> f1 = name -> name.toUpperCase();
    // Sử dụng tham chiếu
    static Function<String, String> f2 = String::toUpperCase;

    static Predicate<Persion> p1 = per -> per.getHeight() >= 170;

    static Predicate<Persion> p2 = MethodReferenceExample1 :: HeightCheck;

    static BiPredicate<Persion,Integer> p3 = MethodReferenceExample1 :: HeightCheckWithParam;

    public static void main(String[] args) {
        System.out.println("Lambdas Expression Result: " + f1.apply("java 8"));
        System.out.println("Method Reference Result: " + f2.apply("java 8"));
        //Sử dụng cho 1 persion:
        System.out.println("Sử dụng để kiểm tra 1 persion ");
        System.out.println("Predicate Result Using lamda: " + p1.test(PersionRepository.getPersion()));
        System.out.println("Predicate Result Using Reference: " + p2.test(PersionRepository.getPersion()));
        // Check theo param nhập vào height:
        System.out.println("Result check With Param: " + p3.test(PersionRepository.getPersion(), 160));
        // Sử dụng cho 1 danh sách persion:
        System.out.println("Sử dụng check điều kiện cho 1 list Persion: ");
        List<Persion> listPersion = PersionRepository.getAllPersions();
        // Sử dụng lamda
        listPersion.stream().filter(p1).collect(Collectors.toList());
        listPersion.forEach(persion -> {
            if (p1.test(persion)) {
                System.out.println(persion);
            }
        });
        // Sử dung reference:
        System.out.println("Sử dụng Reference: ");
        listPersion.stream().filter(p2).collect(Collectors.toList());
        listPersion.forEach(p -> {
            if (p2.test(p)){
                System.out.println(p);
            }
        });
    }
    static boolean HeightCheck (Persion persion){
        return persion.getHeight() >=170;
    };
    static boolean HeightCheckWithParam (Persion persion, Integer height){
        return persion.getHeight() >=height;
    };
}
