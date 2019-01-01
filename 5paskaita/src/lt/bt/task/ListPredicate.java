package lt.bt.task;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class ListPredicate {

    public static void main(String[] args){

        MyList<String> myList = new MyList<>();
        myList.add("Kaunas");
        myList.add("Klaipeda");
        myList.add("Vilnius");
        myList.add("Telsiai");

        myList.print("Stringu listas",myList);


        //listas po filtro
        System.out.println("Stringu listas po filtro");
        Predicate<String> filter = s -> !s.equals("Vilnius");

        for(String s: myList){
            if(filter.test(s))System.out.println(s);
        }

        MyList<Integer> myNumber = new MyList<>();
        myNumber.add(2);
        myNumber.add(11);
        myNumber.add(21);
        myNumber.add(20);
        myNumber.add(18);
        myNumber.add(9);


        myNumber.print("Skaiciu listas",myNumber);

        //Skaiciu listas po filtro
        System.out.println("Skaiciu listas po filtro");
        Predicate<Integer> filter2 =  integer -> integer > 10 && integer < 20;

        for(Integer i: myNumber){
            if(filter2.test(i))System.out.println(i);
        }


    }

    static class MyList<E> implements Iterable<E>{

        private List<E> list = new LinkedList<>();


        public void add(E element){
            list.add(element);
        }

        @Override
        public Iterator<E> iterator() {
            return list.iterator();
        }

        public void print(String title, MyList<E> myList){
            System.out.println(title);
            for(E e: myList){
                System.out.println(e);
            }
        }
    }
}
