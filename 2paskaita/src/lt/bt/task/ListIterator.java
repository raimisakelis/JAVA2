package lt.bt.task;

import java.util.ArrayList;
import java.util.Iterator;


public class ListIterator {


    public static void main(String[] args){


//        ArrayList<String> listas = new ArrayList<>();
//        listas.add("Miestas");
//
//        System.out.println(listas.get(0));
//
//
//        Iterator<String> iterator = listas.iterator();
//        while (iterator.hasNext()){
//
//        }


        Iter<Integer> listas2 = new Iter<>();
        listas2.add(1);
        listas2.add(2);
        listas2.add(3);

        System.out.println("listas2 elementas" + listas2.get(1));





    }


    static class Iter<E> implements Iterable<E>{

        private ArrayList<E> list = new ArrayList<>();


        public boolean add(E element){
            list.add(element);
            return true;
        }


        public E get(int index){
            E element = list.get(index);
            return element;
        }


        @Override
        public Iterator<E> iterator() {
            return null;
        }


    }

 }
