package Features.Predicate;



import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerPredicateExample {
    static Predicate<Person> p1 = p -> p.getHeight() >= 170;
    static Predicate<Person> p2 = p -> p.getGender().equals("Male");
    // Có thể viết BiConsumer để check.
    static BiPredicate<Integer, String> p3 = (height, gender) -> height >= 170 && gender.equals("Male");

    static BiConsumer<String, List<String>> nameHobbiesConsumer = (name, hobbies) -> System.out.println(name+ " " + hobbies);
    static Consumer<Person> persionConsumer = persion -> {
        // check chiều cao và giới tính nếu đúng sẽ in tên người dùng và sở thích.
//        if (p1.and(p2).test(persion)){
//            nameHobbiesConsumer.accept(persion.getName(), persion.getHobbies());
//        }
        // Viết theo các check chung
        if (p3.test(persion.getHeight(), persion.getGender())){
            nameHobbiesConsumer.accept(persion.getName(), persion.getHobbies());
        }
    };
    public static void main(String[] args) {
    List<Person> listPerson = PersonRepository.getAllPersions();
    listPerson.forEach(persionConsumer);
    }
}
