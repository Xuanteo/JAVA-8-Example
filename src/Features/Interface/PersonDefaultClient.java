package Features.Interface;

import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.List;

public class PersonDefaultClient {
    static List<Person> listOfPerson = PersonRepository.getAllPersions();

    public static void main(String[] args) {
        PersonDetails personDetails = new PersonDetailsImpl();
        System.out.println("Total Salary: " + personDetails.caculationTotalSalary(listOfPerson));
        System.out.println("Total Kids Count: " + personDetails.totalKids(listOfPerson));
        // Cần sử dụng interface để gọi cho 1 phương thức tĩnh.
        System.out.println("List Person Name: "+PersonDetails.personNames(listOfPerson));
        // Muôn gọi phương thức static ở lớp impl.
        System.out.println("Person Name Of Impl: "+PersonDetailsImpl.personNames(listOfPerson));
    }
}
