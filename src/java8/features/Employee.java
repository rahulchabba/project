package java8.features;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
public class Employee {

    String name;
    Integer empId;
    Integer salary;
    Integer age;
    Address address;


    static List<Employee> createEmployee(){

    return Arrays.asList(
            new Employee("Rahul",1,1000, 3,new Address("Nangal","Punjab", 140126)),
            new Employee("Anmol",2,2000, 31,new Address("Nangal","Punjab", 140126)),
            new Employee("Ashu",3,3000, 39,new Address("Nangal","Punjab", 140126)),
            new Employee("Rishu",4,19000, 36,new Address("Nangal","Punjab", 140126)),
            new Employee("Darshan",5,10000,32, new Address("Una","Himachal", 123456)),
            new Employee("Sneh",6,98000, 31,new Address("Una","Himachal", 123456)),
            new Employee("Yogesh",6,98000, 31, new Address("Rewari","Haryana", 122001))
    );

    }

    static List<Employee> createEmployeeDuplicateValue(){

        return Arrays.asList(
                new Employee("Rahul",1,1000, 3,new Address("Nangal","Punjab", 140126)),
                new Employee("Rahul",1,1000, 3,new Address("Nangal","Punjab", 140126)),
                new Employee("Anmol",2,2000, 31,new Address("Nangal","Punjab", 140126)),
                new Employee("Ashu",3,3000, 39,new Address("Nangal","Punjab", 140126)),
                new Employee("Ashu",3,3000, 39,new Address("Nangal","Punjab", 140126)),
                new Employee("Rishu",4,19000, 36,new Address("Nangal","Punjab", 140126)),
                new Employee("Darshan",5,10000,32, new Address("Una","Himachal", 123456)),
                new Employee("Sneh",6,98000, 31,new Address("Una","Himachal", 123456)),
                new Employee("Yogesh",6,98000, 31, new Address("Rewari","Haryana", 122001))
        );

    }

}
