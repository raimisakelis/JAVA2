package lt.bt.task.Stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args){


        List<Salary> myList = new ArrayList<>();
        myList.add(new Salary(new Employee("Jonas"),600));
        myList.add(new Salary(new Employee("Ona"),800));
        myList.add(new Salary(new Employee("Petras"),700));
        myList.add(new Salary(new Employee("Maryte"),900));
        myList.add(new Salary(new Employee("Petras"),300));

        print("pradinis listas",myList);


        Comparator<Salary> comparator = Comparator.comparingDouble(Salary::getSalary);
        //Comparator<Salary> comparator =  (o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary());//lambda israiska (ne reference)

        //sukuriam mapa darbuotoju su ju bendrais atlyginimais (jeigu gavo dvi algas, jos bus sudetos)
        Map<Employee, Double> myMap = myList.stream()
                .collect(Collectors.groupingBy(
                        Salary::getEmployee,
                        Collectors.summingDouble(Salary::getSalary)));

        //atsispausdinam map pasitikrinti
//        myMap.keySet().forEach(key ->{
//            System.out.println("myMap " + key + " = " + myMap.get(key));
//        });


        System.out.println("Rusiavimas Map konvertuojant i lista paprastai \n");

        //mapa sudedam i lista, surusiuojam pagal komparatoriu (atlyginimu didejimo tvarka) ir atspausdinam
        convertToList(myMap).stream()
                .sorted(comparator)
                .forEach(System.out::println);//ne referensine forma,  .forEach(salary -> System.out.println(salary))

        System.out.println("\n Rusiavimas naudojant Map.entrySet() \n");


        //nesutraukta forma
//        convertToList(myMap).stream()
//                .sorted(comparator)
//                .forEach(new Consumer<Salary>() {
//                    @Override
//                    public void accept(Salary salary) {
//                        System.out.println(salary);
//                    }
//                });


        //didejimo tvarka
//        myMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue())
//                .forEach(System.out::println);


        //be reference i Stream metoda accept
//        myMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue())
//                .forEach(employeeDoubleEntry ->
//                        System.out.println(employeeDoubleEntry.getKey() + " " + employeeDoubleEntry.getValue()));


        //nesutraukta foreach forma (+ kitokia System.out.println() teksto forma)
//        myMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue())
//                .forEach(Stream::accept);


        //mazejimo tvarka atspausdinta
        myMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<Employee,Double>::getValue).reversed())
                .forEach(e -> System.out.println(e.getKey() +" "+ e.getValue()));


        System.out.println("\n kiek kartu kiekvienam darbuotojui ismoketas atlyginimas \n");

        //Kiek kartu kiekvienam darbuotojui ismoketas atliginimas
        Set<Salary> setList = new HashSet<>(myList);
        for (Salary salary : setList) {
            System.out.println(salary.getEmployee().getName() + ": " + Collections.frequency(myList, salary));

        }


    }

    private static void print(String title, List<Salary> list){
        System.out.println(title);
        for(Salary s: list){
            System.out.println(s);
        }
        System.out.println("\n");
    }


    private static List<Salary> convertToList(Map<Employee, Double> myMap){
        List<Salary> newList = new LinkedList<>();
        myMap.keySet().forEach(key -> newList.add(new Salary(new Employee(key.getName()),myMap.get(key))));
        return newList;
    }

    private static void accept(Map.Entry<Employee, Double> employeeDoubleEntry) {
        System.out.println(employeeDoubleEntry.getKey() + " " + employeeDoubleEntry.getValue());
    }
}
