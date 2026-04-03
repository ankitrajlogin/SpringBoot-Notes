package exp3.config;



import exp3.beans.Vehicle;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"exp3.beans"})
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
