package Features.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonRepository {

    public static List<Person> getAllPersions() {
        Person p1 = new Person("Xuan", 167, 2000, "Male", 2, Arrays.asList("Football", "Swimming", "Backetball"));
        Person p2 = new Person("Luc", 175, 5000, "FeMale", 2, Arrays.asList("Driving", "Tenis", "Music"));
        Person p3 = new Person("Kien", 182, 6200, "Male", 2, Arrays.asList("Football", "Driving", "Music"));
        Person p4 = new Person("Duc", 165, 9000, "FeMale", 2, Arrays.asList("Football", "Driving", "Music"));
        Person p5 = new Person("Nam", 174, 9700, "FeMale", 2, Arrays.asList("Tenis", "Swimming", "Music"));
        Person p6 = new Person("Vu", 174, 9700, "Male", 2, Arrays.asList("Football", "Swimming", "Backetball"));
        Person p7 = new Person("Tien", 182, 9000, "Male", 2, Arrays.asList("Football", "Backetball"));
        return Arrays.asList(p1, p2, p3, p4, p5, p6, p7);
    };

    public static Person getPersion() {
        return new Person("Xuan", 167, 2000, "Male", 2, Arrays.asList("Football", "Swimming", "Backetball"));
    };
    public static Optional<Person> getOptionalPerson(){
        return Optional.of(getPersion());
    }
}
