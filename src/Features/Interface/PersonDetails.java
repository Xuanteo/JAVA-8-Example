package Features.Interface;

import Features.Repository.Person;

import java.util.List;
import java.util.stream.Collectors;

public interface PersonDetails {
    double caculationTotalSalary(List<Person> personlist);
    // Khi cung cấp 1 phương thức mặc định thì không cần implement mà cũng ko có lỗi.
    // Chúng ta có thể gọi trực tiếp từ tầng giao diện
    default int totalKids(List<Person> personOfList) {
        return personOfList.stream().map(Person::getKids).reduce(0, (x, y) -> x + y);
    };
    // Phương thức tĩnh ko cần implement cũng không xảy ra ngoại lệ.
    // Luu ý vì là 1 phương thức tĩnh nên ko thể dùng lớp để gọi phải dùng interface.
    // Phương thức static thì không thể ghi đè Overide
    static List<String> personNames(List<Person> listOfPerson){
        return listOfPerson.stream().map(Person::getName).collect(Collectors.toList());
    }
}
