package Features.Funtion;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFuntionExample {
    static BiFunction<String, String, String> bf1 = (a, b) -> (a + " " + b);

    static Predicate<Person> p1 = per -> per.getHeight() >= 170;

    static Predicate<Person> p2 = per -> per.getGender().equals("Male");

    static BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> bf2 = (listPersion, predicate) -> {
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
        List<Person> listOfPerson = PersonRepository.getAllPersions();
        Map<String,Double> map = bf2.apply(listOfPerson, p2);
        System.out.println("Result Persion: " + map);
    }
}
