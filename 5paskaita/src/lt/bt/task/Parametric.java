package lt.bt.task;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parametric {


    public static void main(String[] args){

        MyList<String> city = new MyList<>();

        city.add("Kaunas");
        city.add("Vilnius");
        city.add("Panevezys");
        city.add("Klaipeda");

        city.print("pradine tvarka", city);
        city.printBack("atbuline tvarka", city);

        MyList<Integer> number = new MyList<>();

        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);

        number.print("pradine tvarka", number);
        number.printBack("atbuline tvarka", number);




    }


    public static class MyList<E> implements Iterable<E> {

        private List<E> list = new LinkedList<>();

        public void add(E element){
            list.add(element);
        }

        public void get(int index){
            list.get(index);
        }


        @Override
        public Iterator<E> iterator() {
            return list.iterator();
        }

        public Iterable<E> back() {
            return () -> new Iterator<E>() {

                int index = list.size();

                @Override
                public boolean hasNext() {
                    return index > 0;
                }

                @Override
                public E next() {
                    return list.get(--index);
                }
            };

        }

        public void print (String title, MyList<E> listas) {
            System.out.println(title);

            for (E e : listas) {
                System.out.println(e);
            }
        }

        public void printBack (String title, MyList<E> listas) {
            System.out.println(title);

            for (E e : listas.back()) {
                System.out.println(e);
            }
        }


//        public Iterable<E> back() {
//            return new Iterable<E>() {
//
//                @Override
//                public Iterator<E> iterator() {
//
//                    return new Iterator<E>() {
//
//                        int index = list.size();
//
//                        @Override
//                        public boolean hasNext() {
//                            return index > 0;
//                        }
//
//                        @Override
//                        public E next() {
//                            return list.get(--index);
//                        }
//                    };
//                }
//            };
//
//        }

    }

}
