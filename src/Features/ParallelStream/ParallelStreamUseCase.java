package Features.ParallelStream;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamUseCase {
    public static void main(String[] args) {
        // Gọi method để kiểm tra :
        System.out.println(getHobbiesBySeq());
        System.out.println(getHobbiesByParallel());

    }
    // get hobbies of persion by Sequential.
    static List<String> getHobbiesBySeq(){
        long start = System.currentTimeMillis();
        List<String> hobbies = PersonRepository.getAllPersions()
                .stream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("Sequential Duration: " + (end-start));
        return hobbies;
    }
    static List<String> getHobbiesByParallel(){
        long start = System.currentTimeMillis();
        List<String> hobbies = PersonRepository.getAllPersions()
                .parallelStream()
                .map(Person::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("Parallel Duration: " + (end-start));
        return hobbies;
    }
}
