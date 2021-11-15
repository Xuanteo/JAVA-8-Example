package Features.Funtion;

import Features.Repository.Persion;
import Features.Repository.PersionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class FuntionPersionExample {
    static Function<String, Integer> f1 = name -> name.length();
    static BiPredicate<Integer, String> f3 = (height, gender) -> height >= 170 && gender.equals("Male");
    // Funtion tìm tên + lương của persion thoả mãn điều kiện height >170 && gender = male
    static Function<List<Persion>, Map<String, Double>> f2 = (persionList) -> {
        Map<String, Double> map = new HashMap<String, Double>();
        persionList.forEach(per -> {
            if (f3.test(per.getHeight(), per.getGender())) {
                map.put(per.getName(), per.getSalary());
            }
        });
        return map;
    };

    public static void main(String[] args) {
        // Funtion chuyển số kí tự trong chuỗi đầu vào.
        System.out.println("Result: " + f1.apply("java features"));
        // Funtion lấy ra tên và salary của persion.
        List<Persion> persions = PersionRepository.getAllPersions();
        Map<String, Double> mapPersion = f2.apply(persions);
        System.out.println("Result: " + mapPersion);
    }
}
