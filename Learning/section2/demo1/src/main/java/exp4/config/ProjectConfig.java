package exp4.config;


import exp4.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    String hello(){
        return "Hello World" ;
    }

    @Bean
    Integer luckyNumber(){
        return 16 ;
    }

    @Bean("myfavVehicle")
    Vehicle veh1(){
        System.out.println("this myfavVehicle created using bean");

        var veh3 = new Vehicle() ;
        veh3.setName("ferrari")  ;
        return veh3  ;
    }

}
