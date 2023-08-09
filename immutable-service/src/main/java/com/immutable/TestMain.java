/*
     Immutable class requirement
     ----------------------------
     1) The class must be declared as final so that child classes can’t be created.
     2) Data members in the class must be declared private so that direct access is not allowed.
     3) Data members in the class must be declared as final so that we can’t change
        the value of it after object creation.
     4) A parameterized constructor should initialize all the fields performing a deep copy
        so that data members can’t be modified with an object reference.
     5) Deep Copy of objects should be performed in the getter methods to return a copy rather
        than returning the actual object reference)
     6) There should be no setters or in simpler terms, there should be no option to change
        the value of the instance variable.
*/
import com.immutable.Customer;

import java.util.HashMap;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("1", "first");
        stringMap.put("2", "second");

        Customer customer = new Customer("ABC", 101, stringMap);

        System.out.println(customer.getName());
        System.out.println(customer.getRegNo());
        System.out.println(customer.getMetadata());

        stringMap.put("3", "third");

        System.out.println(customer.getMetadata());
        customer.getMetadata().put("4", "fourth");

        System.out.println(customer.getMetadata());
    }

}



