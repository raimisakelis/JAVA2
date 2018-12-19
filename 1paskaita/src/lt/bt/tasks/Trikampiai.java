package lt.bt.tasks;



import java.util.*;


/**

     * HelloWorld

     * Created by valdas on 2018-12-18.

     */

    public class Trikampiai {

        public static void main(String[] args) {
            Trikampiai trik = new Trikampiai();



            Set<Trikampis> trikampiai = new HashSet<>();
            Trikampis trik1 = new Trikampis(3, 4, 5);
            Trikampis trik2 = new Trikampis(3, 3, 3);
            Trikampis trik3 = new Trikampis(3, 5, 4);


            trikampiai.add(trik1);
            trikampiai.add(trik2);
            trikampiai.add(trik3);

            System.out.println("Viso skirtingu trikampiu " + trikampiai.size());


            System.out.println("trik 1 hash kodas " + trik1.hashCode());
            System.out.println("trik 2 hash kodas " + trik2.hashCode());
            System.out.println("trik 3 hash kodas " + trik3.hashCode());

        }

    }



    class Trikampis {


        private double a, b, c;


        public Trikampis(double a, double b, double c) {
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


        private List<Double> sortTriangle () {
            List<Double> triangleList = Arrays.asList(a, b, c);
            triangleList.sort(Comparator.naturalOrder());
            return triangleList;
        }



        @Override

        public boolean equals(Object o) {

            if (this == o) return true;

            if (o == null || this.getClass() != o.getClass()) return false;

            Trikampis trikampis = (Trikampis) o;
            List<Double> t1 = this.sortTriangle();
            List<Double> t2 = trikampis.sortTriangle();

            return  Double.compare(t1.get(0), t2.get(0)) == 0 &&
                    Double.compare(t1.get(1), t2.get(1)) == 0 &&
                    Double.compare(t1.get(2), t2.get(2)) == 0;
        }



        @Override

        public int hashCode() {
            return Objects.hash(sortTriangle());
        }


    }



