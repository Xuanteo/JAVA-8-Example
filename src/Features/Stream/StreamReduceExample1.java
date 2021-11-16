package Features.Stream;

import Features.Repository.Persion;
import Features.Repository.PersionRepository;

import java.util.Optional;

public class StreamReduceExample1 {
    public static void main(String[] args) {
        combineNames();
        // Viết tuỳ chọn:
        Optional<Persion> tallestPerson = getTallestPerson();
        System.out.println("Tallest Persion is: "+ tallestPerson.get());
    }

    private static void combineNames() {
        // Nối các tên của Persion thành 1 chuỗi:
        String names = PersionRepository.getAllPersions()
                .stream()
                .map(Persion::getName)
                .reduce("", (a,b)-> a.concat(b));
        System.out.println("Result Name: " + names);
    }
    // Optinal cho phép chúng ta làm việc với con trỏ null linh hoạt.
    static Optional<Persion> getTallestPerson (){
        return PersionRepository.getAllPersions()
                .stream().reduce((x,y) -> x.getHeight() > y.getHeight() ? x : y);
    }
}
