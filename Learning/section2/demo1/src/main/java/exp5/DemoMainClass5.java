package exp5;

import exp5.beans.Vehicle;
import exp5.beans.Person;
import exp5.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DemoMainClass5{
    public static void main(String[] args){


        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var person = context.getBean(Person.class);
        var vehicle = context.getBean(Vehicle.class);
        System.out.println("Person name from $pring Context is: "+ person.getName());
        System.out.println("Vehicle name from Spring Context is: "+ vehicle.getName());
        System.out.println("Vehicle that Person own is: " + person.getVehicle());

        System.out.println(vehicle == person.getVehicle());
    }
}

/*
Spring Container
-------------------------
Vehicle Bean  (1 object)
Person Bean   (1 object)

Person → refers to Vehicle bean
Main   → refers to same Vehicle bean
 */
