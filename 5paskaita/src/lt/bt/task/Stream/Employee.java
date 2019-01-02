package lt.bt.task.Stream;

import lt.bt.task.Trikampiai;

import java.util.Objects;

import static com.sun.xml.internal.ws.util.VersionUtil.compare;

public class Employee {


    private String name;
    private double salary;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//palygina rodykles, jeigu rodykles rodo i ta pacia atminties vieta, vadinasi objektai lygus
        if (o == null || getClass() != o.getClass()) return false;//jei objektas o lygus null("tuscias") arba lyginamu objektu klases nelygios(skirtingu klasiu) grazinama false;
        Employee emp = (Employee) o;//skliausteliuose po lygybes uzrasu(Trikampis) mes kompiliatoriui pasakome, kad mes zinome, jog lyginami objektai tos pacios klases

        return compare(String.valueOf(emp.name), name) == 0;
    }

    @Override

    public int hashCode() {
        return Objects.hash(name);
    }


}
