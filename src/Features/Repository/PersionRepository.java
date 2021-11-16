package Features.Repository;

import java.util.Arrays;
import java.util.List;

public class PersionRepository {

    public static List<Persion> getAllPersions() {
        Persion p1 = new Persion("Xuan", 167, 2000, "Male", 2, Arrays.asList("Football", "Swimming", "Backetball"));
        Persion p2 = new Persion("Luc", 175, 5000, "FeMale", 2, Arrays.asList("Driving", "Tenis", "Music"));
        Persion p3 = new Persion("Kien", 182, 6200, "Male", 2, Arrays.asList("Football", "Driving", "Music"));
        Persion p4 = new Persion("Duc", 165, 9000, "FeMale", 2, Arrays.asList("Football", "Driving", "Music"));
        Persion p5 = new Persion("Nam", 174, 9700, "FeMale", 2, Arrays.asList("Tenis", "Swimming", "Music"));
        Persion p6 = new Persion("Vu", 174, 9700, "Male", 2, Arrays.asList("Football", "Swimming", "Backetball"));
        Persion p7 = new Persion("Tien", 182, 9000, "Male", 2, Arrays.asList("Football", "Backetball"));
        return Arrays.asList(p1, p2, p3, p4, p5, p6, p7);
    }

    ;

    public static Persion getPersion() {
        return new Persion("Xuan", 167, 2000, "Male", 2, Arrays.asList("Football", "Swimming", "Backetball"));
    }

    ;
}
