import java8.features.Address;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

public class ImmutableHashMap {
    public static void main(String[] args) {

       // System.out.println("Print all the Employee name in UpperCase who belong from City XYZ.");
        List<DummyEmployee> employee =   DummyEmployee.createDummyEmployee();
        List<DummyEmployee> nameInUpperCase = employee.stream().filter(emp -> emp.getAddress().stream()
                .anyMatch(cur -> cur.getCity().equals("Nangal") || cur.getCity().equalsIgnoreCase("UNA")))
               .collect(Collectors.toList());
       // nameInUpperCase.forEach(System.out::println);

        System.out.println("Checking Immutable Context of hashMap");
        HashMap<DummyEmployee, String> map = new HashMap<>();
        DummyEmployee s1 =  new DummyEmployee("Rahul",1,1000, 3, Collections.singletonList(new Address("Nangal", "Punjab", 140126)));
        map.put(s1,"Rahul");
        System.out.println(map.get(s1));
        System.out.println(map);
        for (Map.Entry<DummyEmployee, String> employeeStringEntry : map.entrySet()) {
            System.out.println(employeeStringEntry.getKey().hashCode());
        }
        s1.setName("YadavG"); //Due to setting this or changing this Student object Value is finding bcze hashcode changed and
        DummyEmployee s2 = new DummyEmployee("Anmol",2,2000, 31, Collections.singletonList(new Address("Nangal","Punjab", 140126)));
        map.put(s2,"Anmol");
        System.out.println(map.get(s1));
        System.out.println(map);

        for (Map.Entry<DummyEmployee, String> employeeStringEntry : map.entrySet()) {
            System.out.println(employeeStringEntry.getKey().hashCode());
        }

//Before Employee builder class
        System.out.println("===================================================");
//After Employee builder class
        HashMap<DummyEmployee, String> mapImmutable = new HashMap<>();

        DummyEmployee employee1 = DummyEmployee.DummyEmployeeBuilder.anEmployee().withEmpId(1)
                .withName("rahul")
                .withAge(1)
                .withSalary(1)
                .withAddress(Collections.singletonList(new Address("Nangal", "Punjab", 140126)))
                .build();
        mapImmutable.put(employee1,"rahul");
        for (Map.Entry<DummyEmployee, String> employeeStringEntry : mapImmutable.entrySet()) {
            System.out.println(employeeStringEntry.getKey().hashCode());
        }
        DummyEmployee immutableUpdatedEmployee1 = DummyEmployee.DummyEmployeeBuilder.anEmployee(employee1).withName("YadavG").build();
        for (Map.Entry<DummyEmployee, String> employeeStringEntry : mapImmutable.entrySet()) {
            System.out.println(employeeStringEntry.getKey().hashCode());
        }
        System.out.println( mapImmutable.get(immutableUpdatedEmployee1));
        System.out.println( mapImmutable.get(employee1));
    }

}


@Data
@AllArgsConstructor
@ToString()
@EqualsAndHashCode
class  DummyEmployee {
    String name;
    Integer empId;
    Integer salary;
    Integer age;
    List<Address> address;

    public DummyEmployee(DummyEmployeeBuilder dummyEmployeeBuilder) {
        this.name = dummyEmployeeBuilder.name;
        this.empId = dummyEmployeeBuilder.empId;
        this.salary = dummyEmployeeBuilder.salary;
        this.age = dummyEmployeeBuilder.age;
        this.address = dummyEmployeeBuilder.address;
    }

    static List<DummyEmployee> createDummyEmployee(){

        return Arrays.asList(
                new DummyEmployee("Rahul",1,1000, 3,Arrays.asList(new Address("Nangal","Punjab", 140126))),
                new DummyEmployee("Anmol",2,2000, 31,Arrays.asList(new Address("Nangal","Punjab", 140126))),
                new DummyEmployee("Ashu",3,3000, 39,Arrays.asList(new Address("Nangal","Punjab", 140126))),
                new DummyEmployee("Rishu",4,19000, 36,Arrays.asList(new Address("Nangal","Punjab", 140126))),
                new DummyEmployee("Darshan",5,10000,32,Arrays.asList( new Address("Una","Himachal", 123456))),
                new DummyEmployee("Sneh",6,98000, 31,Arrays.asList(new Address("Una","Himachal", 123456))),
                new DummyEmployee("Yogesh",6,98000, 31,Arrays.asList( new Address("Rewari","Haryana", 122001)))
        );
}


    public static final class DummyEmployeeBuilder {
        private String name;
        private Integer empId;
        private Integer salary;
        private Integer age;
        private List<Address> address;

        private DummyEmployeeBuilder() {
        }

        public static DummyEmployeeBuilder anEmployee() {
            return new DummyEmployeeBuilder();
        }


        public static DummyEmployeeBuilder anEmployee(DummyEmployee  employee) {
            return anEmployee().withName(employee.getName())
                    .withSalary(employee.getSalary())
                    .withAge(employee.getAge())
                    .withEmpId(employee.getEmpId())
                    .withAddress(employee.getAddress());
        }

        public DummyEmployeeBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DummyEmployeeBuilder withEmpId(Integer empId) {
            this.empId = empId;
            return this;
        }

        public DummyEmployeeBuilder withSalary(Integer salary) {
            this.salary = salary;
            return this;
        }

        public DummyEmployeeBuilder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public DummyEmployeeBuilder withAddress(List<Address> address) {
            this.address = address;
            return this;
        }

        public DummyEmployee build() {
            return new DummyEmployee(this);
        }
    }

}