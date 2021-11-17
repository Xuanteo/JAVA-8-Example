package Features.Interface;

import Features.Repository.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDetailsImpl implements PersonDetails{
    @Override
    public double caculationTotalSalary(List<Person> personlist) {
        return personlist.stream().map(Person::getSalary).reduce(0d,(x,y)-> x+y);
    }
    // Phương thưc defaut ko thể ghi đè từ lớp cha khi implement
    // Đây là lớp triển khai nên khi khai báo lại thì luôn được ưu tiên ở lớp triển khai.
    // Kết quả in ra cuối cùng là 20 nên thứ tự ưu tiên triển khai vẫn ở lớp con.
    public int totalKids(List<Person> personOfList) {
        return 10+10;
    };
    // Phương thức static đặt ở lớp con triển khai ko báo lỗi nhưng ko có ý nghĩa.
    // Vì phương thức static được gọi trực tiếp từ interface nên khi nó đặt ở lớp triển khai cũng ko đc gọi đến.
    // Phương thức static ở interface và impl là khác biệt
    // có thể gọi đc phương thức này trên client.
    static List<String> personNames(List<Person> listOfPerson){
        return Arrays.asList("One","Two", "Three");
    }
}
