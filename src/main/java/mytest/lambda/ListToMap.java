package mytest.lambda;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        Customer customer1 = new Customer("1", "Albert", "Einstein");
        Customer customer2 = new Customer("2", "Otto", "Hahn");
        Customer customer3 = new Customer("3", "Isaac", "Newton");

        List<Customer> customerList = Arrays.asList(customer1, customer2, customer3);

//        Map<String, Customer> customerMap = customerList
//                .stream()
//                .collect(Collectors.toMap(Customer::getId, Function.identity()));
//        System.out.println(customerMap);

        customerList.stream().map(Customer::getFirstname).forEach(System.out::println);
    }

}

@Data
class Customer {
    private String id;
    private String firstname;
    private String lastname;


    public Customer(String id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
