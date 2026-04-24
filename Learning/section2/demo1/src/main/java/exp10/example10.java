package exp10;

import exp10.beans.Bike;
import exp10.beans.Engine;
import exp10.beans.Vehicle;
import exp10.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class example9 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Bike bike1 = context.getBean(Bike.class) ;
        Bike bike2 = context.getBean(Bike.class) ;

        System.out.println(bike1 == bike2);

    }

}

