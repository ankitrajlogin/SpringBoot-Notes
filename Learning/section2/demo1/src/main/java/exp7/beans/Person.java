package exp7.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// final only used for the constructor

@Component
public class Person {

    private String name ;
    final private  Vehicle vehicle ;

    @Autowired
    public Person(Vehicle vehicle){
        System.out.println("Person constructor called") ;
        this.vehicle = vehicle ;
        this.name = "ankit" ;
        System.out.println("Car bean created") ;
    }


    public String getName(){
        return name ;
    }

    public void setName(String name){
        this.name = name ;
    }


    public Vehicle getVehicle(){
        return vehicle ;
    }
}
