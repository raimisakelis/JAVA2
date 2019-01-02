package lt.bt.task.Stream;

import lt.bt.task.Trikampiai;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Stream {


    public static void main(String[] args){


        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jonas", 1200));
        employees.add(new Employee("Petras", 1000));
        employees.add(new Employee("Ona", 800));
        employees.add(new Employee("Maryte", 900));
        employees.add(new Employee("Jonas", 1200));
        employees.add(new Employee("Vytas", 600));


        Comparator<Employee> comparator =  (o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary());

        //Comparator<Employee> comparator = Comparator.comparingDouble(Employee::getSalary);



        employees.stream()
                .sorted(comparator)
                .forEach(new Consumer<Employee>() {
                  @Override
                   public void accept(Employee employee) {
                      System.out.println(employee.getName() + " - " + employee.getSalary());
                   }
                });


        System.out.println("po konvertavimo i mapa");

        Map<String, Double> newMap = new Stream().mapList(employees);
        List<Employee> newList = new LinkedList<>();

        newMap.keySet().forEach(key ->{
            newList.add(new Employee(key,newMap.get(key)));
        });


        newList.stream()
                .sorted(comparator)
                .forEach(new Consumer<Employee>() {
                    @Override
                    public void accept(Employee employee) {
                        System.out.println(employee.getName() + " - " + employee.getSalary());
                    }
                });










    }

    //smart add element into Map list
    public Map<String,Double> mapList(List<Employee> employees){
        Map<String,Double> list = new HashMap<>();

        for(Employee e: employees) {

            if (!list.containsKey(e.getName())){
                list.put(e.getName(), e.getSalary());
            } else {
                list.put(e.getName(), list.get(e.getName()) + e.getSalary());
            }
        }

        return list;
    }

}
