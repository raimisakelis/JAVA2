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



        //mapa sudedam i lista, surusiuojam pagal komparatoriu (atlyginimu didejimo tvarka) ir atspausdinam
        convertToList(myMap).stream()
                .sorted(comparator)
                .forEach(System.out::println);//ne referensine forma,  .forEach(salary -> System.out.println(salary))


        //nesutraukta forma
//        convertToList(myMap).stream()
//                .sorted(comparator)
//                .forEach(new Consumer<Salary>() {
//                    @Override
//                    public void accept(Salary salary) {
//                        System.out.println(salary);
//                    }
//                });


        //TODO reikia padaryti, kad skaiciuotu kiek kartu kiekvienam darbuotojui ismoketas atlyginimas



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
        myMap.keySet().forEach(key ->{
            newList.add(new Salary(new Employee(key.getName()),myMap.get(key)));
        });
        return newList;
    }

}
