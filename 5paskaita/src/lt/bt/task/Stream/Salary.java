package lt.bt.task.Stream;


import java.util.Objects;

public class Salary {

    private Employee employee;
    private double salary;

    public Salary(Employee employee, double salary) {
        this.employee = employee;
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


        @Override
    public boolean equals(Object o) {
        if (this == o) return true;//palygina rodykles, jeigu rodykles rodo i ta pacia atminties vieta, vadinasi objektai lygus
        if (o == null || getClass() != o.getClass()) return false;//jei objektas o lygus null("tuscias") arba lyginamu objektu klases nelygios(skirtingu klasiu) grazinama false;
        Salary sal = (Salary) o;//skliausteliuose po lygybes uzrasu(Trikampis) mes kompiliatoriui pasakome, kad mes zinome, jog lyginami objektai tos pacios klases

        return Objects.equals(sal.employee,employee);
    }

    @Override

    public int hashCode() {
        return Objects.hash(employee);
    }

    @Override
    public String toString() {
        return employee.getName() + " " + salary;
    }
}
