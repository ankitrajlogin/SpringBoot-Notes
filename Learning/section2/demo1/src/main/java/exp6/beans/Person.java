package exp6.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Person {

    private String name ;


    // this is call field injection ;
    @Autowired
    private Vehicle vehicle ;


    // this is a setter injection
//    @Autowired
//    public void setEngine(Vehicle vehicle){
//        this.vehicle = vehicle ;
//    }

    public Person(){
        this.name = "ankit" ;
        System.out.println("Person bean created") ;
    }

    public String getName(){
        return name ;
    }

    public void setName(String name){
        this.name = name ;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle(){
        return vehicle ;
    }
}
