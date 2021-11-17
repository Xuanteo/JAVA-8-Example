package Features.Optional;

import Features.Repository.Address;
import Features.Repository.Person;
import Features.Repository.PersonRepository;

import java.util.Optional;

public class OptionalMapExample {
    public static void main(String[] args) {
//        optionalMapExample();
//        optionalFlatmapExample();
        optionalMapFilterExample();
    }

    static void optionalMapExample() {
        Optional<Person> per = PersonRepository.getOptionalPerson();
        per.ifPresent(person -> {
            String name = per.map(Person::getName).orElse("No Data Found");
            System.out.println("Name: " + name);
        });
    }

    static void optionalFlatmapExample() {
        Optional<Person> person = PersonRepository.getOptionalPerson();
        if (person.isPresent()) {
            Optional<Address> address = person.flatMap(Person::getAddress);
            System.out.println("Address: " + address.get());
        }
    }

    static void optionalMapFilterExample() {
        Optional<Person> per = PersonRepository.getOptionalPerson().filter(person -> person.getHeight() >= 165);
        per.ifPresent(person -> System.out.println(person.getAddress().get()));
    }
}

