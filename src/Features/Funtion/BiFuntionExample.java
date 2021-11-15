package Features.Funtion;

import Features.Repository.Persion;
import Features.Repository.PersionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFuntionExample {
    static BiFunction<String, String, String> bf1 = (a, b) -> (a + " " + b);

    static Predicate<Persion> p1 = per -> per.getHeight() >= 170;

    static Predicate<Persion> p2 = per -> per.getGender().equals("Male");

    static BiFunction<List<Persion>, Predicate<Persion>, Map<String, Double>> bf2 = (listPersion, predicate) -> {
        Map<String, Double> map = new HashMap<String, Double>();
        listPersion.forEach(per -> {
            if (p1.and(predicate).test(per)){
                map.put(per.getName(), per.getSalary());
            }
        });
        return map;
    };

    public static void main(String[] args) {
        System.out.println("Result: " + bf1.apply("java", "features"));
        // Lấy ra tên và salary của persion thoả mãn điều kiện :
        List<Persion> listOfPersion = PersionRepository.getAllPersions();
        Map<String,Double> map = bf2.apply(listOfPersion, p2);
        System.out.println("Result Persion: " + map);
    }
}
