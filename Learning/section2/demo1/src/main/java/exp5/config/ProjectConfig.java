package exp5.config;


import exp5.beans.Person;
import exp5.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Vehicle vehicle(){
        Vehicle vehicle = new Vehicle() ;
        vehicle.setName("Toyota");
        return vehicle ;
    }

//    @Bean
//    Person person(){
//        Person person = new Person() ;
//        person.setName("Lucy");
//        person.setVehicle(vehicle());
//        return person ;
//    }


    // 2nd method => passing in
    @Bean
    Person person(Vehicle vehicle){
        Person person = new Person() ;
        person.setName("Lucy");
        person.setVehicle(vehicle());
        return person ;
    }

}
