package exp1.config;



import exp1.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Tesla") ;
        return veh ;

    }

    @Bean
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Tesla") ;
        return veh ;
    }

    @Bean
    Vehicle vehicle3(){
        var veh = new Vehicle();
        veh.setName("Tesla") ;
        return veh ;
    }

    @Bean
    String hello(){
        return "Hello World" ;
    }

    @Bean
    Integer luckyNumber(){
        return 16 ;
    }

}
