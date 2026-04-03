package exp2.config;



import exp2.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@Import({anotherConfig.class})
public class ProjectConfig {

    @Bean(value = "hondaVehicle")
    Vehicle vehicle1(){
        var veh = new Vehicle() ;
        veh.setName("honda");
        return veh ;
    }

    @Bean(name = "audiVehicle")
    Vehicle vehicle2(){
        var veh = new Vehicle() ;
        veh.setName("Audi");
        return veh ;
    }

    @Primary
    @Bean({"ferrariVehicle" , "myFavouriteVehicle"})
    Vehicle vehicle3(){
        var veh = new Vehicle() ;
        veh.setName("ferrari")  ;
        return veh  ;
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
