package lt.bt.task;

import java.util.*;

public class Trikampiai {

    public static void main(String[] args){

        List<Trikampis> trikampiai = new ArrayList<>();
        trikampiai.add(new Trikampis(5,3,5));
        trikampiai.add(new Trikampis(4,3,5));
        trikampiai.add(new Trikampis(5,3,5));

        System.out.println("Listo size " + trikampiai.size());
        print("Trikampiai liste", trikampiai);


        boolean arLygus = trikampiai.get(0).equals(trikampiai.get(2));
        System.out.println("Ar lygus trikampiai " + arLygus);

        //trikampiai sete

        Set<Trikampis> trik = new HashSet<>();
        trik.add(new Trikampis(5,3,5));
        trik.add(new Trikampis(4,3,5));
        trik.add(new Trikampis(5,3,5));

        System.out.println("Seto size " + trik.size());
        print("Trikampiai sete", trik);




    }


    public static void print(String title, Collection<Trikampis> trikampiai){
        System.out.println(title);
        for (Trikampis t: trikampiai){
            System.out.println(t);
        }
    }

    static class Trikampis {

        private double a, b, c;


        public Trikampis(double a, double b, double c){
            this.a = a;
            this.b = b;
            this.c = c;

        }

        private List<Double> sortTriangle() {
            List<Double> triangleList = Arrays.asList(a, b, c);
            triangleList.sort(Comparator.naturalOrder());
            return triangleList;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;//palygina rodykles, jeigu rodykles rodo i ta pacia atminties vieta, vadinasi objektai lygus
            if (o == null || getClass() != o.getClass()) return false;//jei objektas o lygus null("tuscias") arba lyginamu objektu klases nelygios(skirtingu klasiu) grazinama false;
            Trikampis trik = (Trikampis) o;//skliausteliuose po lygybes uzrasu(Trikampis) mes kompiliatoriui pasakome, kad mes zinome, jog lyginami objektai tos pacios klases

            return Double.compare(trik.a, a) == 0 &&
                    Double.compare(trik.b, b) == 0&&
                    Double.compare(trik.c, c) == 0;

            //alternatyvus budas uzrasyti lyginima. ((Trikampis)o) kompiliatoriui nurrodome, kad o traktuotu kaip trikampi, tada matomi laukai a, b, c
//            return Double.compare(((Trikampis)o).a, a) == 0 &&
//                    Double.compare(((Trikampis)o).b, b) == 0&&
//                    Double.compare(((Trikampis)o).c, c) == 0;

        }

        @Override

        public int hashCode() {
            return Objects.hash(sortTriangle());
        }


        @Override
        public String toString() {
            return "a = " + a + " b = " + b + " c = " + c;
        }

    }
}




