package exp3;

import exp3.beans.Vehicle;
import exp3.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DemoMainClass3 {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class) ;

        var veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context that created using component: " + veh.getName());

        veh.about();

        Vehicle veh2 = context.getBean("myfavVehicle", Vehicle.class); ;
        System.out.println("Vehicle name from Spring Context that created using beans: " + veh2.getName());
        veh2.about() ;



    }
}
