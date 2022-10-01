package java8.features;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static java8.features.Employee.createEmployee;
import static java8.features.Employee.createEmployeeDuplicateValue;



public class Java8Features {
    static int count = 1;

    static void line() {
        System.out.println("------------------------------------------------");
        count++;
    }

    static void printMap(Map map) {
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    public static void main(String[] args) {

        //PURE FUNCTION: It is he function which returns same value each time it is called. With same input.
        //LAZY Evaluation:  Lazy Evaluation requires purity of function means it should be PURE in nature.


        List<Employee> employeeList = createEmployee();
        System.out.println("Total employees are " + createEmployee().size());
        line();
        //1. List name of Emp who is having PINCODE as 140126
        System.out.println(count + ". List name of Emp who is having PINCODE as 140126");
        createEmployee().stream().filter(employee -> employee.getAddress().getPinCode() == 140126)
                .map(Employee::getName)
                .forEach(System.out::println);
        line();

        System.out.println(count + ". List name of Emp who is having Age Greater than 33");
        List<String> listOfNameAgeGreater30 = createEmployee().stream()
                .filter(employee -> employee.getAge() >= 33)
                .map(employee -> employee.getName() + "-" + employee.getAge())
                .map(String::toUpperCase)
                .collect(toList());
        listOfNameAgeGreater30.forEach(System.out::println);
        line();

        System.out.println(count + ". Create Map of Name and Age of Employee");
        Map<String, Integer> nameAgeMap = createEmployee().stream().collect(toMap(Employee::getName, Employee::getAge));
        System.out.println(nameAgeMap);
        line();


        System.out.println(count + ". Employee with Even Age and ODD Age");
        //PartitioningBy : is used to group the data ONLY in TWO GROUPS.
        //For MULTIPLE GROUPS: Use GroupBy
        System.out.println(createEmployee().stream().collect(partitioningBy(employee -> employee.getAge() % 2 == 0)));
        line();

        System.out.println(count + ". Employee with same age group together andList of Employee");
        Map<Integer, List<Employee>> mapOfNameAndmployee = createEmployeeDuplicateValue()
                .stream().collect(
                        groupingBy(Employee::getAge));
        printMap(mapOfNameAndmployee);
        line();
        System.out.println(count + ". Employee with same name and Ages as value");
        // this Grouping by has structure like
        // Colector(Function, Collector(Function, Collector))
        //Get the Map Keys as Name and also Want Age only instead Employee Object
        Map<String, List<Integer>> mapOfNameAndAge = createEmployeeDuplicateValue()
                .stream().collect(
                        groupingBy(Employee::getName,
                                mapping(Employee::getAge, toList())));
        printMap(mapOfNameAndAge);
        line();


        System.out.println(count + ". 8 Find the no of occurrence of Each word in String ");
        List<String> aSentence = Arrays.asList("Find the no no no of occurrence of Each word in String ".split(" "));
        Map<String, Long> mapOfWordAndCountLong = aSentence.stream()
                .collect(groupingBy(words -> words, counting()));
        System.out.println("Printing values as Long ");
        System.out.println(mapOfWordAndCountLong);

        System.out.println(count + "Printing values as Integer");
        //Now We need to get Value as Integer then we have to expecitly tell collector to convert the Values into Integer
        Map<String, Integer> mapOfWordAndCountInteger = aSentence.stream().
                collect(groupingBy(words -> words,
                        collectingAndThen(counting(), Long::intValue)));
        System.out.println(mapOfWordAndCountInteger);
        line();

        System.out.println(count + " Get the employee with max Salary");
        String nameOfHigestSalariedEmployee = createEmployeeDuplicateValue()
                .stream().collect(
                        collectingAndThen(
                                maxBy(comparing(Employee::getSalary)),
                                employee -> employee.map(Employee::getName).orElse("")));
        System.out.println(nameOfHigestSalariedEmployee);
        line();

        System.out.println(count + " Sort the Employee based on based on Name and then Salary - ");
        Comparator<Employee> employeeComparator = Comparator.
                comparing(Employee::getName).thenComparing(Employee::getSalary);
          List<Employee> empList = createEmployee();
        System.out.println( " Before Sorting --- "+empList);
          Collections.sort(empList,employeeComparator);
        System.out.println(" After Sorting --- "+empList);
        line();

        System.out.println(count + " Get Employee Name which belong from 1 location.");

        List<Employee> employeeBelongFromPunjab =createEmployee().stream().filter(employee-> employee.getAddress()
                .getState().equalsIgnoreCase("Punjab")).collect(Collectors.toList());
        Comparator<Employee> sortReveresAge = Comparator.comparing(Employee::getAge).reversed();
        employeeBelongFromPunjab.stream().sorted(sortReveresAge).forEach(System.out::println);
        line();

        String[] str = new String[10];
        str[5] = "JAVA OPTIONAL CLASS EXAMPLE";  // Setting value for 5th index
        Optional<String> checkNull = Optional.ofNullable(str[5]);
        checkNull.ifPresent(System.out::println);   // printing value by using method reference
        System.out.println(checkNull.get());    // printing value by using get method
        System.out.println(str[5].toLowerCase());

    }
}

