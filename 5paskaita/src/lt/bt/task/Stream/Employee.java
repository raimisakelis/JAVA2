package lt.bt.task.Stream;

import java.util.Objects;

public class Employee {

    private String name;


    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


        @Override
    public boolean equals(Object o) {
        if (this == o) return true;//palygina rodykles, jeigu rodykles rodo i ta pacia atminties vieta, vadinasi objektai lygus
        if (o == null || getClass() != o.getClass()) return false;//jei objektas o lygus null("tuscias") arba lyginamu objektu klases nelygios(skirtingu klasiu) grazinama false;
        Employee emp = (Employee) o;//skliausteliuose po lygybes uzrasu(Trikampis) mes kompiliatoriui pasakome, kad mes zinome, jog lyginami objektai tos pacios klases

        return Objects.equals(emp.name, name);
    }

    @Override

    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }



}
