package Features.Stream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.function.Predicate;

public class StreamMapFilterReduceExample {

    static Predicate<Person> p1 = per -> per.getHeight() > 170;
    static Predicate<Person> p2 = per -> per.getGender().equals("Male");

    public static void main(String[] args) {
        //Viết hàm đếm số trẻ em của các person: lọc theo điều kiện height > 170 và gender = Male
        int kidsCount = PersonRepository.getAllPersions()
                .stream()
                .filter(p1.and(p2))
                .map(Person::getKids)
//                .reduce(0, Integer::sum); có thể sử dụng tham chiếu giá trị hoặc kiểu lambdas đã viết.
                .reduce(0,(x,y) -> x+y);
        System.out.println("Kids of Person: " + kidsCount);
    }
}
