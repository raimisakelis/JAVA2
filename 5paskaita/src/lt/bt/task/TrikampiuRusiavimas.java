package lt.bt.task;

import java.util.*;

public class TrikampiuRusiavimas {
    public static void main(String[] args){


        //trikampiai treesete

        Set<Trikampis> trikampiai = new TreeSet<>();
        trikampiai.add(new Trikampis(5,3,5));
        trikampiai.add(new Trikampis(4,3,5));
        trikampiai.add(new Trikampis(5,3,5));

        System.out.println("Treeseto size " + trikampiai.size());
        print("Trikampiai Treesete", trikampiai);


        List<Trikampis> trikListas = new ArrayList<>();
        trikListas.add(new Trikampis("Pirmas",5,3,5));
        trikListas.add(new Trikampis("Antras",4,3,5));
        trikListas.add(new Trikampis("Trecias",3,3,5));
        trikListas.add(new Trikampis("Ketvirtas",5,3,4));
        trikListas.add(new Trikampis("Penktas",4,2,5));
        trikListas.add(new Trikampis("Sestas",3,3,3));

        System.out.println("Array listo size " + trikListas.size());
        print("Trikampiai Array liste", trikListas);


        //pagal trikampio perimetra
        Comparator<Trikampis> comp = (o1, o2) -> Double.compare(o1.a + o1.b + o1.c, o2.a + o2.b + o2.c);

        //Comparator<Trikampis> comp = Comparator.comparingDouble(o -> o.a + o.b + o.c);//kompaktiskesne lambda forma



        trikListas.sort(comp);
        print("Trikampiai Array liste surusiuoti pagal perimetra", trikListas);


        //pagal trikampio plota
        Comparator<Trikampis> comp2 = (o1, o2) -> Double.compare(o1.countArea(),o2.countArea());

        //Comparator<Trikampis> comp2 = Comparator.comparingDouble(o -> o.countArea());//kompaktiskesne lambda forma
        //Comparator<Trikampis> comp2 = Comparator.comparingDouble(Trikampis::countArea);//kompaktiskesne lambda forma su reference

        trikListas.sort(comp2);
        print("Trikampiai Array liste surusiuoti pagal plota", trikListas);







        //pilna forma
//        class TrikampioComp implements Comparator<Trikampis>{
//
//            @Override
//            public int compare(Trikampis o1, Trikampis o2) {
//                return Double.compare(o1.a + o1.b + o1.c, o2.a + o2.b + o2.c);
//            }
//        }
//
//        Comparator<Trikampis> comp = new TrikampioComp();
//        trikListas.sort(comp);
//        print("Trikampiai Array liste surusiuoti pagal perimetra", trikListas);
//
//        //pagal trikampio plota
//        class TrikampioComp2 implements Comparator<Trikampis>{
//            @Override
//            public int compare(Trikampis o1, Trikampis o2) {
//                return Double.compare(o1.countArea(),o2.countArea());
//            }
//        }
//
//        Comparator<Trikampis> comp2 = new TrikampioComp2();
//        trikListas.sort(comp2);
//        print("Trikampiai Array liste surusiuoti pagal plota", trikListas);


    }






    public static void print(String title, Collection<Trikampis> trikampiai){
        System.out.println(title);
        for (Trikampis t: trikampiai){
            System.out.println(t);
        }
    }

    static class Trikampis implements Comparable<Trikampis> {

        private String name;
        private double a, b, c;

        public Trikampis(String name, double a, double b, double c) {
            this.name = name;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public Trikampis(double a, double b, double c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        private double halfPerimeter(){
            double halfPer = (a + b + c) / 2;
            return halfPer;
        }


        //TODO galbut reiketu dayti su exeption
        private double countArea(){
            if(a < b + c && b < a + c && c < a + b) {
                double area = Math.sqrt(halfPerimeter() * (halfPerimeter() - a)
                        * (halfPerimeter() - b) * (halfPerimeter() - c));
                return area;
            } else {
                System.out.println("Trikampio sudaryti negalima");
                return 0;
            }
        }


        @Override
        public String toString() {
            return name + " a = " + a + " b = " + b + " c = " + c;
        }


        //pagal krastines
        @Override
        public int compareTo(Trikampis o) {
            int cmp = Double.compare(this.a, o.a);
            if (cmp != 0) return -cmp;

            cmp = Double.compare(this.b, o.b);
            if (cmp != 0) return -cmp;

            return -Double.compare(this.c, o.c);

        }
    }
}
