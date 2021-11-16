package Features.Stream;

import Features.Repository.Persion;
import Features.Repository.PersionRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamMinMaxbyExample {
    // Viết method tìm ra người cao nhất trong list Person:
    static Optional<Persion> getTallestPerson() {
        return PersionRepository.getAllPersions()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Persion::getHeight)));
    }

    // Viết method tìm ra người thấp nhất trong list Persion
    static Optional<Persion> getShortestPerson() {
        return PersionRepository.getAllPersions()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Persion::getHeight)));
    }
    // Viết kiểm tra kịch bản có 2 người có cùng chiều cao trong List:
    static List<Persion> filterMultiplePerson(){
        // Khai báo ra 1 list rỗng:
        List<Persion> personList = new ArrayList<Persion>();
        // Tuỳ chọn person có chiều cao nhất:
        Optional<Persion> maxHeight = getTallestPerson();
        // Kiểm tra 1 đối tượng xem có rỗng hay không.
        Persion persion = maxHeight.isPresent() ? maxHeight.get() : null;
        // Check điều kiện:
        if (persion != null){
            personList = PersionRepository.getAllPersions()
                    .stream()
                    .filter(per-> per.getHeight() == persion.getHeight())
                    .collect(Collectors.toList());
        }
        return personList;
    }

    public static void main(String[] args) {
        // In ra Person có chiều cao cao nhất:
        Optional<Persion> tallestPersion = getTallestPerson();
        System.out.println("Maxby Tallest Person: " + tallestPersion.get());
        // In ra person có chiều cao thấp nhất:
        System.out.println("Minby Shortest Person: " + getShortestPerson().get());
//        PersionRepository.getAllPersions().stream().collect(Collectors.toList()).forEach(System.out::println);
        // In ra list person có chiều cao lớn nhất:
        System.out.println("List Tallest Multiple Person: " + filterMultiplePerson());
    }
}
