package exp1;

import exp1.beans.Vehicle;
import exp1.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMainClass1 {
    public static void main(String[] args){

        Vehicle vehicle = new Vehicle();
        vehicle.setName("Audi");
        System.out.println("Vehicle name from non-spring context is: " + vehicle.getName());


        // not need explicit define vehicle class for creation with new

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class) ;
        // get help to bean of class vechicle
//        var veh = context.getBean(Vehicle.class) ;
        // throw error :  expected single matching bean but found 3: vehicle1,vehicle2,vehicle3

        // Java only allows access based on reference type, not actual object.
//        var veh = (vehicle) context.getBean("vehicle1") ;

        // casting
        Vehicle veh = (Vehicle) context.getBean("vehicle1");
        System.out.println("Vehicle name from Spring context is: " + veh.getName()) ;

        Vehicle veh2 = context.getBean("vehicle2" , Vehicle.class) ;
        System.out.println("Vehicle name from Spring context is: " + veh2.getName()) ;







    }
}
