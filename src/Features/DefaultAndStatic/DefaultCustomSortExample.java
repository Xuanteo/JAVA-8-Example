package Features.DefaultAndStatic;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.Comparator;
import java.util.List;

public class DefaultCustomSortExample {
    static Comparator<Person> c1 = Comparator.comparing(Person::getName);
    static Comparator<Person> c2 = Comparator.comparingDouble(Person::getHeight);
    public static void main(String[] args) {
        List<Person> listOfPerson = PersonRepository.getAllPersions();
//        sortByName(listOfPerson);
//        System.out.println("----------");
//        sortByHeight(listOfPerson);
//        System.out.println("----------");
//        sortByHeightAndName(listOfPerson);
//        System.out.println("----------");
        sortByNameWithNullFirst(listOfPerson);
        System.out.println("----------------");
        sortByNameWithNullLast(listOfPerson);
    }
    static void sortByName(List<Person> listOfPerson){
        listOfPerson.sort(Comparator.comparing(Person::getName));
        listOfPerson.forEach(System.out::println);
    }
    static void sortByHeight(List<Person> listOfPerson){
        listOfPerson.sort(c2);
        listOfPerson.forEach(System.out::println);
    }
    static void sortByHeightAndName(List<Person> listOfPerson){
        listOfPerson.sort(c1.thenComparing(c2));
        listOfPerson.forEach(System.out::println);
    }
    static void sortByNameWithNullFirst (List<Person> listOfPerson){
        // Tạo 1 hàm xắp xếp null trước.
        Comparator<Person> c3 = Comparator.nullsFirst(c1);
        listOfPerson.sort(c3);
        listOfPerson.forEach(System.out::println);
    }
    static void sortByNameWithNullLast (List<Person> listOfPerson){
        // Tạo 1 hàm xắp xếp null trước.
        Comparator<Person> c3 = Comparator.nullsLast(c1);
        listOfPerson.sort(c3);
        listOfPerson.forEach(System.out::println);
    }
}
