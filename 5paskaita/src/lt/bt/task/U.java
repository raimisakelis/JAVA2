package lt.bt.task;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.LinkedList;

import java.util.List;



public class U {

    public static void main(String[] args) {



        Dezute<String> tekstai = new Dezute<>();

        tekstai.add("A");
        tekstai.add("A1");
        tekstai.add("B");
        tekstai.add("C");
        tekstai.add("C1");
        tekstai.add("D");

        print("Pradiniai:", tekstai);

        tekstai.pull();

        print("Po pull:", tekstai);

        Iterator<String> it = tekstai.iterator();

        while (it.hasNext()) {
            String s = it.next();
            if (s.length() > 1) it.remove();
        }

        print("Po valymo:", tekstai);

        System.out.println("Atvirksciai:");

        for (String x : tekstai.rev()) {
            System.out.println(x);
        }

    }



    static void print(String title, Dezute<String> tekstai) {

        System.out.println(title);

        for (String s : tekstai) {

            System.out.println(s);

        }

    }

}





class Dezute<T> implements Iterable<T> {

    private List<T> listas = new LinkedList<>();

    public List<T> getListas() {
        return listas;
    }


    public boolean add(T t) {
        listas.add(0, t);
        return true;
    }



    public T pull() {
        if (listas.size() == 0) return null;
        return listas.remove(0);
    }



    public void add(int index, T t) {
        listas.add(index, t);
    }



    public void remove(T t) {
        listas.remove(t);
    }



    @Override

    public Iterator<T> iterator() {
        return listas.iterator();
    }



    public Iterable<T> rev() {

        return () -> new Iterator<T>() {

            int index = listas.size();

            @Override
            public boolean hasNext() {
                return index > 0;
            }

            @Override
            public T next() {
                return listas.get(--index);
            }

        };

    }

}


