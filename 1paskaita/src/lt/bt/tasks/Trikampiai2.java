package lt.bt.tasks;

import java.util.*;

public class Trikampiai2 {

    public static void main(String[] args) {
        Trikampiai2 trik = new Trikampiai2();



        Set<Trikampis1> trikampiai = new TreeSet<>();
        Trikampis1 trik1 = new Trikampis1(3, 4, 5);
        Trikampis1 trik2 = new Trikampis1(3, 3, 3);
        Trikampis1 trik3 = new Trikampis1(3, 5, 4);


        trikampiai.add(trik1);
        trikampiai.add(trik2);
        trikampiai.add(trik3);

        System.out.println("Viso skirtingu trikampiu " + trikampiai.size());


        System.out.println("trik 1 hash kodas " + trik1.hashCode());
        System.out.println("trik 2 hash kodas " + trik2.hashCode());
        System.out.println("trik 3 hash kodas " + trik3.hashCode());

    }

}



class Trikampis1 implements Comparable<Trikampis1> {


    private double a, b, c;
    private double area;


    public Trikampis1(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public double getA() { return a; }

    public void setA(double a) { this.a = a;}

    public double getB() { return b; }

    public void setB(double b) { this.b = b;}

    public double getC() {return c; }

    public void setC(double c) { this.c = c; }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }


    private List<Double> sortTriangle (){
        List<Double> triangleList = Arrays.asList(a, b, c);
        triangleList.sort(Comparator.naturalOrder());
        setA(triangleList.get(0));
        setB(triangleList.get(1));
        setC(triangleList.get(2));
        //System.out.println("bandymas " + triangleList);
        return triangleList;
    }




    private void countArea (Trikampis1 trik){
        double pusper = (trik.a + trik.b + trik.c) / 2;
        if(trik.a < trik.b + trik.c && trik.b < trik.a + trik.c && trik.c < trik.a + trik.b){
            double areatrik =  Math.sqrt(pusper * (pusper - trik.a) * (pusper - trik.b) * (pusper - trik.c));
            trik.setArea(areatrik);
            System.out.println(areatrik);
        } else {
            System.out.println("Trikampio sudaryti negalima");

        }
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;


        Trikampis1 trikampis = (Trikampis1) o;
//            trikampis.SortTriangle ();
//            System.out.println("trikamapio krastines " + trikampis.getA()  + " " + trikampis.getB() + " " + trikampis.getC());
//            System.out.println("trikampis.a " + trikampis.a);

        return Double.compare(trikampis.a, a) == 0 &&

                Double.compare(trikampis.b, b) == 0 &&

                Double.compare(trikampis.c, c) == 0;
    }


    @Override

    public int hashCode() {

        return Objects.hash(sortTriangle ());

    }


    @Override
    public int compareTo(Trikampis1 o) {
        return 0;
    }







}
