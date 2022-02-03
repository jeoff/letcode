package mytest;

public class Employee {

    String name;
    String occupation;
    String telephone;
    int age;
    int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" +
                "Age :" + this.age + "\n" +
                "Telephone :" + this.telephone + "\n" +
                "Occupation :" + this.occupation + "\n" +
                "Salary :" + this.salary ;
    }

    public void printInfo() {
        System.out.println(this.toString());
    }
}
